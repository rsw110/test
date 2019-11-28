package controller;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class TestShenFen {
	//腾讯云ocr身份证文字识别
		//腾讯云文字识别服务器域名
	 public static final String HOST = "recognition.image.myqcloud.com";
	 //使用application/json格式参数url，其值为图片链接
	 public static final long APPID=1300381493;
	 //sercretida
	 public static final String SECRET_ID="AKIDWpulPv8JDtNcfbc8ZliU3NSOAhy19Pjn";
	 //sercretkey
	 public static final String SECRET_KEY="2pQmskNkrtiJfmeGdkgNo0whDVXWGsFB";
	 //请求的域名
	 public static final String TARGETURL="https://recognition.image.myqcloud.com/ocr/idcard";
	//图片路径
	    public static final String IDURL="https://yyb.gtimg.com/aiplat/static/ai-demo/large/odemo-pic-7.jpg";
public static void main(String[] args) {
	 //发送Http请求，首先创建一个Httpclient
	CloseableHttpClient httpClient = HttpClients.createDefault();
	//创建一个post请求
	HttpPost httpPost=new HttpPost(TARGETURL);
}
}
