package yanzhengduanxin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import controller.CheckSumBuilder;


/**
 * 发起单人专线电话
 * @author liuxuanlin
 *
 */
public class StartCall {
    //发送单人专线电话的请求路径URL
    private static final String
            SERVER_URL="https://api.netease.im/call/ecp/startcall.action";
    //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
    private static final String
            APP_KEY="fd460d34e786e7754e505bc4fab0f027";
    //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
    private static final String APP_SECRET="xxxxxxxx";
    //随机数
    private static final String NONCE="123456";

    //发起本次请求的用户的accid（需在网易云信注册过的accid，用于鉴权请求）
    private static final String CALLERACC="liuxuanlin"; 

    //主叫方电话号码(不带+86这类国家码,下同)
    private static final String CALLER="13888888888";

    //被叫方电话号码
    private static final String CALLEE="13777777777";

    //本通电话最大可持续时长,单位秒,超过该时长时通话会自动切断。
    private static final String MAXDUR="100";

    public static void main(String[] args) throws Exception {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(SERVER_URL);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        /*
         * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
         */
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);

        // 设置请求的header
        httpPost.addHeader("AppKey", APP_KEY);
        httpPost.addHeader("Nonce", NONCE);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的的参数，requestBody参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        /*
         * callerAcc参数必须要在云信注册下的accid
         */
        nvps.add(new BasicNameValuePair("callerAcc", CALLERACC));
        nvps.add(new BasicNameValuePair("caller", CALLER));
        nvps.add(new BasicNameValuePair("callee", CALLEE));
        nvps.add(new BasicNameValuePair("maxDur", MAXDUR));

        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        /*
         * 1.打印执行结果，打印结果一般会200、403、414、500
         * 2.具体的code有问题的可以参考官网的Code状态表
         */
        System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));

    }
}