package com.hm.travel.config;

/**
 * @author jlz
 * @date 2019/8/24 20:00
 */
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
    public static String app_id = "2016100200645127";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCQs05rMD2WIeJ2zlMWliiwSxG4UHukj42daFO7WM5LCkQCojzvYe2HsFMYsteXCPEsyACs1ACujBDei7zI8WczsPa+Yn+0FUOQBiK9E2dNqVKQ2ou51NAsFWsn76NFS8wLjdR3gZGSe14hHTcL+01X7E9geFh8nyhKoiUP2kRUvu8TQ6fI4/w6hlu9Rsdcp+Wk5Ia1pdRRjnd/dVihPyOX1tbaryqsboeh85jEZuNQvmd7PaYb1AdXUpvp3OZuzffkxuJA+/pyXxbi14A0ze9rKb5xQHI4UbGyJ4Be7iCtAj283SMTFop56P9BPzGuJP+dM4UtH2GMRo+s9RLUOhzZAgMBAAECggEAZMYblRbxrT9IAsnKn+5PxAdj/eM/WOoJDFj+B3nfoe8yUks++NBQprEsDgVvk+ZMYI2hurujBezSSssy3RcScrOKBCmBGp+8f+9l/hwnU7TapbsumGsX17vK9vMz2CzjnCBYmioIgeWdNp6sGZIY2WTgGyV1KsWFQAUQnqu57vJGEpg0BpkLE2Txh3OI1SKVeZzvOnxMgcge+Bs6swuRNl4w5aMmLUSo87buks3LlDAAcn4e5EttPuw/D/iE4wdZNcJv6vmkC+V3/hYldjLdgp5z6Horc0o5yAjMh9NWrynlE+NCc7IogJZL7A1NzuliGulo76AwC906t2MsD80DaQKBgQDKILc64a0+Q8z4eNVRhPTWFa9oYFV52BHepXPMSTjw/948jwks5k8rG3G/rSn36bYApeW5lyWkhX1V8ZUA6FoYsEcX1OR3DXJD8hNXwON6+Q0wVP/Pc3OAhLkSceh92kIk1KyB/0SLDXV70nWXzGEcA9AKsq2lBwOpWjlGXk5WmwKBgQC3REpn0So8cPmXyV4QMeSyIxDyodgMf+ZUzbL2pD9LYpyWdcJwxpyEOQ+D5L6vJu/gS9guBC4i3Yk6dZAZsLKCqerPS0Vu1bBCkhlWOv7FlieDC2Fs+MYz22dtJfmnEmtEdJm57jnq8nQvAZCSJtN8uxnBnYnM4C9mZ2LVeWdXmwKBgDaA6+eswxJvJe46Zws8VukDn/D9SQ85/FeVNcx4UipqVHrv9wFseRyeoeWVxCNdmf5Cvdd1smjStiFeq1c7UFAn+IOsnI6dyZoYxK59DNo0HiJSSUifUR3urBkVLiQBnqRf1MSZGNqGHo/tCFiOfAEZ5hd8ZuaBJbOc6KTY+TbRAoGBAJu8gK4wZP/v0WpXSIPiokFu4xwMxJf6qDUwiABoGxFov0Bs2csUPDVwd+rRG+mj4Pxt90tDaiFeuRrghJAQQ+IdmtiFUn+ZP6uSk81fXNlzfCg0J5p+3Y97xyxNtRVw5Y7Kt0f1VWp+lpTLc5t/OwEnzf9mbI+Zgy42dRqLjHI5AoGBALMAO40HZZCZwA8wlnyYdp7uherjf7EBPXbVjQHwa9T2rNYHA240ncNBE10qKeoTS7NtNQI+8tyHkU9+XqMB/i4noTnj0WeGeTDFuoeEE5fUKMeHVV5F1MQDAzihw0IiiC0UOaXWXtP1qW2IBlxjDeYVzQH6Y9cI/p82ngbxTyR8";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkh5cxJplwt5mHTaKUZoEQ+F+ocI6rJ9yS/r5FBab92fGPcm8+Z7FkSOg8z7+7W7wVCgVtHzEzk2xpTxyndnysTGSDOF8PYZiiBtOCYsS31Gz6UsCr01iIb2qmAIjkcu1tcAugcsqNiz6JN/o/r7swarFTAFCSL/+lhlOVuUvDubImz0XJRdWSjpjJhVg2J0el4iffcQ4XmbF9J2gfIyr71hzMetYVIBw6jJSKolHjwUOtq08bS9ykBMr2Ba1eSWzTHYDIHO9dtYvq9wYFD/bH4UmKUgXd7R/6E5GA1kGuSTqT2A/sdt4HOgX5SvrUoeiygN9VKrcfFl5JqCsP7lg9wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/notify_url.jsp";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
    public static String return_url = "http://localhost:8080/orderComplete";
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
