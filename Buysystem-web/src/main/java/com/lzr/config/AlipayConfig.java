package com.lzr.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000116659709";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC9c1RBMSwnI8G9f4XjCp+m0Mg0lMc3VpwKPFu0K4NRUI/MH6SCV5okFWmaaA2Q+pmZVPmPaK33yf8QXrBjqKDxNMev4lbRGsjgmBbB4iXJv13E7Bee6Ggtj3Hkfm1L6ocFVKsHfjoAWIe7vh9lJfcJA/lqHMj0uqWE9d0Udb0VqNZjUt4G7D3maEqzKJ7CpibSGMTBVblSnpX2GAT/mkaYUADpCWeU5i9bhSl2ELJc0f7Xt4yxX5nWzVH/Nz09BrZckPrVsEI/FetBT1rboCh96svxUWR6E7cL34JNTRlIzMgWI0208XNPXbnszfoZKUEpFIV3cpyFGaw5W+Odxnz5AgMBAAECggEAAfrrnYbTDFGuW7myf44D3y19ejc34dcw6FZ7KuXtiHMMHbkS8h3SSaBDq059Hc/QvS6LMTmJ3/YniVdEBrajgAHqOGdoOuVJxjcwvbQMaxBp/X3uPUX2mMtQCHBd2hZIdQDOjNR/7LMAMDEriNYdv+VfvQEyBITS6BHdzrHwWQKXKBH6FcnA/El4YlRDlZ8eajQ1NsvT7eF4A7yeANaLhn5lqPx5PWOuSL7Xi7QsPqLra1nvQyCONRnYVXUKCLX+WzHpmHg5Me0LKFH8vS+uw5zneVGLjnfcF83QLXWTj045DGzGp1huwoesGTayA/rXHROgSrBVZ7TX8vZ2ByxXlQKBgQDiWaolt51Zab6zMo9fsKVDptSQmW0j08rNYgnPLOx2cGblkmiX9GFlJSSgZaDNjiPzadw5nUogqq267NU2WqO8hI1vADF4uj2kgue/PT6DbbbHPOL/DZfkkUhWDajOW5h/HDxfoXeM0aNJbgzW6fzJiL2/Wht63PewmQhWessf+wKBgQDWREidfVYT7zmZEnthft4eGLimI8gsNux9AnD4XMBdCOuqVLWnsJ5TNZUfGMOgfMXxKtP+mBN6y67v56OeVdtKH6sNX3dwJLV9K9nx4j3JNDRcEporHjhXplnjpQM2Cs8/ZBrZGivAwlTs/MaoWdT7NS2G1nka6jBQKPShFKRgmwKBgQDfupTtVwJWgKkX4t/IS4fuyJXOn3g7M3p/a2oat2K65vst63sqx0kFeqMrT4iT5O0wCfC9mfTNOScjXjiY0xqImdRaZSyBEkUfuKxsYJLLwcQqRspwI/WA3QFM3Y9++RZQfY5HUAgkzonBaN+UBg/w/BHhc6U52fORQJH3OMRRxQKBgBBgXbBz0O1rHlrdt8Jm4PEp8Ir6NyVx+TdAxYOmCynRMbnuCYhMjn1Lnh8nVGRixPo+zL8rvmlnQfKiILZMV5tdukQmZMmUdK6heGHtac2ECPB0l4XuJF5Gn54vkYRC5T4yF386adeswrLuSvy5CPc+REGHCPCOr6ygxLm/CyU7AoGBAMh27V+V5eje6J97FLs1/KwzxAjTuCa63z0LqWFceUzHKpYfnFd0diVo5yylDY5CGnu2aqcvCv0fN3cA6acHGRluVPHC4BXyafn9Wo+RjiUDpscP4p12CZ9VcSx3tONnnyiwnKFxynm6WFwWomC/GeBllnYGqALWZseSH0C5pIpf";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA00/c7jX4V0X/AezvvG57QbxPoC5Dv8EcpaRsZ97F0HEFsG/51WEXNKQfhBedOgH1s9kjR+Hxaw+XAaP4mdiqkdLxEWndbPMOCmc+KUw2XQjJU1tB77sJqoekdUqOWlQnb5ELC2csQdPLHbZoMrbiB17/HwiXnkz5aJh7CGpKeFuZeN1+473ofRTgxqeYfHsA5INBDpYYuXZ2DDoT4HeI78/1bLP7HNUvsM50VBYIWv5DXoyT7zoZDorRAs45aTJXSb6xFPUUbfzpj2xhSQpsFyz5oQMECm60v6LebVJi1PkDv6SnnW01jVQb9IdIK/V5fk4DTLQUdpiHmsOVpobuCwIDAQAB/c7jX4V0X/AezvvG57QbxPoC5Dv8EcpaRsZ97F0HEFsG/51WEXNKQfhBedOgH1s9kjR+Hxaw+XAaP4mdiqkdLxEWndbPMOCmc+KUw2XQjJU1tB77sJqoekdUqOWlQnb5ELC2csQdPLHbZoMrbiB17/HwiXnkz5aJh7CGpKeFuZeN1+473ofRTgxqeYfHsA5INBDpYYuXZ2DDoT4HeI78/1bLP7HNUvsM50VBYIWv5DXoyT7zoZDorRAs45aTJXSb6xFPUUbfzpj2xhSQpsFyz5oQMECm60v6LebVJi1PkDv6SnnW01jVQb9IdIK/V5fk4DTLQUdpiHmsOVpobuCwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/orders/returnUrl";

    // 签名方式
	public static String sign_type = "RSA2";

    // 字符编码格式
	public static String charset = "utf-8";

    // 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

