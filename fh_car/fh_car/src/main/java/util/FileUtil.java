package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static String  multipartFileUpload(HttpServletRequest request,MultipartFile multipartFile,String upload ){
		String realPath ="";
		if(!multipartFile.isEmpty()){
			//获取原文件名
			String fileMultipartFileName = multipartFile.getOriginalFilename();
			//获取文件路后缀名
			String substring = fileMultipartFileName.substring(fileMultipartFileName.lastIndexOf("."));
			////拼接一个新的文件名，并用uuid防止重复
			String fileName = UUID.randomUUID().toString()+substring;
			//获取一个相对路径
			realPath = upload+"/"+fileName;
			//创建一个新文件夹
			File file = new File(request.getRealPath(upload));
			if(!file.exists()){
				file.mkdirs();
			}
			//创建一个文件流
			FileInputStream fis = null;
			//创建一个客户端
			FTPClient ftpClient = new FTPClient();
			//上传文件
			File tfile = new File(request.getRealPath(upload),fileName);
			try{
				//将文件上传到本地服务器
				multipartFile.transferTo(tfile);
				//通过ip地址进行连接  魔法数字			
				ftpClient.connect("192.168.134.128");
				//用用户名密码登陆
				boolean login = ftpClient.login("rsw", "010513");
				if(login){
					//切换工作目录
					boolean changeWorkingDirectory = ftpClient.changeWorkingDirectory("upload");
					if(!changeWorkingDirectory){
						ftpClient.makeDirectory("upload");
					}
					//转换字符集编码
					ftpClient.changeWorkingDirectory("upload");
					ftpClient.setControlEncoding("utf-8");
					//创建缓冲区
					ftpClient.setBufferSize(1024);
					//更改二进制流的编码
					ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
					//创建文件上传的流
					fis = new FileInputStream(tfile);
					//进行上传
					ftpClient.storeFile(tfile.getName(), fis);		
					 			
				}else{
					System.out.println("没有连接上");
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					fis.close();
					ftpClient.disconnect();
					//删除本地的文件
					tfile.delete();	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return realPath;
	}
	//文件头像下载
		public static void ftpDownload(String filePath,HttpServletRequest req,HttpServletResponse resp){
			InputStream retrieveFileStream = null;
			BufferedInputStream bin = null;
			OutputStream ou =null;
			BufferedOutputStream bou =null;
			FTPClient ftpClient = new FTPClient();
			String encode;
			try {
				encode = URLEncoder.encode(filePath, "UTF-8");
				resp.setContentType("application/octet-stream");
				resp.setHeader("Content-disposition","attachment;filename="+encode);
				ftpClient.connect("192.168.134.128");
				boolean login = ftpClient.login("rsw","010513");
				if(login){
					ftpClient.changeWorkingDirectory("upload");
					ou=resp.getOutputStream();
					bou=new BufferedOutputStream(ou);
					retrieveFileStream = ftpClient.retrieveFileStream(filePath);
					bin = new BufferedInputStream(retrieveFileStream);
					byte[] b=new byte[1024];
					while(bin.read(b)!=-1){
						bou.write(b);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					bin.close();
					retrieveFileStream.close();
					bou.close();
					ou.close();
					ftpClient.disconnect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	 
}
