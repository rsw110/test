 package controller;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class TestOCRClient {
	//腾讯云ocr身份证文字识别
    //腾讯云文字识别服务器域名
    public static final String HOST = "recognition.image.myqcloud.com";
    //使用 application/json 格式，参数为 url ，其值为图片链接
    public static final long APPID=1300381493;
    //secretida秘钥id
    public static final String SECRET_ID = "AKIDWpulPv8JDtNcfbc8ZliU3NSOAhy19Pjn";
    //secretkey
    public static final String SECRET_KEY= "2pQmskNkrtiJfmeGdkgNo0whDVXWGsFB";
    //请求的域名
    public static final String TARGETURL = "https://recognition.image.myqcloud.com/ocr/idcard";
	//图片路径
    public static final String IDURL="https://yyb.gtimg.com/aiplat/static/ai-demo/large/odemo-pic-7.jpg";
	
	public static void main(String[] args) {
		try {
			//发送http请求，首先要创建一个httpclient；
			CloseableHttpClient httpClient = HttpClients.createDefault();
			//创建一个post请求
			HttpPost httpPost = new HttpPost(TARGETURL);
			//组装请求头信息
			httpPost.setHeader("host", "recognition.image.myqcloud.com");
			httpPost.setHeader("content-type", "application/json");
			httpPost.setHeader("authorization", Sign.appSign(APPID, SECRET_ID, SECRET_KEY, null, 10));
			//组装接口需要的参数
			JSONObject json = new JSONObject();
			json.put("appid", APPID);
			json.put("card_type", 0);
			json.put("url_list", IDURL);
			//将需要的参数放入http请求中
			StringEntity stringEntity = new StringEntity(json.toString(), "utf-8");
			httpPost.setEntity(stringEntity);
			//发送请求
			CloseableHttpResponse response = httpClient.execute(httpPost);
			int code = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity);
			System.out.println(code);
			System.out.println(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
