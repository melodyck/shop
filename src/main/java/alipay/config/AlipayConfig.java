package alipay.config;

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
	public static String app_id = "2021000116675181";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCtqUfGmoKqXvoEvCrA1l4o+rj9rUo08qGHj8JiimDpmxeoBHl3Yj4AvhLBIj/amNT+an3S178Z9apq3zz9q+8qHts8ImK0IZOkwc5HvsKUy410nShey3y3q64fu9BiXI2hz4Pa7i8Ll3uRvJGLEg1Fb+JY9SD5PKcPq2hUZIUbVBETz+Gai/UN2mvOcEt72y8uVSq31ddR4771peDHvuA4cbbTshj668Pk0ZhIB9IBL+JyIqah5Mb7T2Px6+tIk23he/6DMSWypYtllq4ijn+04iKgsUSi6PQjcX8aqImaCXnzjKhRafEauFkbQ89qkLkPcBpELnAOj6a5y1Ph2zTfAgMBAAECggEABiyQirUPlDMQPH7cHkMA0gAn94zjqII/z+wCgzJcQ7Hp42VVVDM/9RLM4+Tt1D2+xNTQaGCXQLsFNgt9xZ8JP7wdG0Q1siXHdAIX7WEQ1e1uuAimWMhvRLBr3mD1Bao4ttoD3BK/xW+7SvEjU4huxFs39uWwKGxJnDsB2I5CVThWya7pdLiVq3DyKnTkKBKe3RBRhF+3CsA0W7VHCYkWIArbwiMM0/e733Pqj5TQONPpXj7PiKNf2O8lic9t1Xhe+4jVrtFTpfOtOaOBQhhqQM+j1xW57/hCXwgaU9AQWN+8ig0DuQyMAxKzGjgmZPP/0w8YWkHQBV+d4Y+r9UEOMQKBgQDxczFS88fIUhuncIfMkK5xkFthipne614O40CwISozCPhmDBS2bRZQmDF8oUgEW/5BaGtfTzO7T+B8PRdkKSSf9fzjUlnIZDnEs/wvZSTLe34vOBbymz5qrtA0r7TxnhDrERqcEtF6lCstVQjmWmAeZXWehvyxNAGu6DjjblPG+wKBgQC4IFKe8+Q21rSzu2cABXVfYdsthd/2XyI+CPyCvr0levUNbd77YgsVx0PQjfyxjsP0vhrYoiN6Ys8Zs9hNc5JaWIJEwqOsfi3mMTGUUY4kmP16sLnZ3Tv4EGAY/CiIuA+yERR2X4b8nDpPDUoBVV2Q4QhkTDqBMg1H5S2hWiW0bQKBgFa+dNUBgiAE56yDMDadMB7apwnnGprM4pDksiPU9m05Zsx6wKI9lMvFsdm9s7rlNfZXxmOKd+Jusw7Pf+zbHy5c2MrulhT5dQunQg3g/5QfPNlIBG6KuaToQyL6kT5Q9HEPRwkVda7dNpnlt/nSNEAXYWdfxb8AGS62fWGwDGcrAoGBAIwPKkn3RBXi5LoDR6pgfJP9n/fU6jRC0Y1W0J2z8bVc/qMkfIXEYqJCXXd7SkjWTIETSuCXFV23Y8otX9AqpZ1Lzmv3kwFXShrcONaV4wY7yjVV0UnEXCWqby8SQNMfD/FnxKT2rXviawhPF4hEI1RdmUCSK76zEB8sWbVvGVdRAoGBALNLzcO/lJRfIxZABFCOKLukwsM+XPWxRkWb30FfhrCnTnVI4EK6Hx6jgRS2NGGWjGsXLjsO4LXXneU/rbdt6NmWxRcwRTIvBRPg1Lp+aFoXmh7xOXA2DbBt5vSa9V65aXRpwCdn9C5iiczA8h9HAv+NeQ6X8OFIgV8wQWGODKxl";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtC7HtD+rO4FK24O/thLXVEYxrh6lXNX+N00uql8NGcNplgltXW0T86+1TUyXrRAlFeVjDfOMCa56T5SCbXs4DoA4B3YiKsyFbkaAV/wY6Kym951rahZHhjd6peQHRp+y3Typ4Z7RXpkicw8Q5zFlZ0YOSjW8tEs6Vhdv90eorHP0SDyCdMWoK6oFNUHtC4Kknmdn4Oohg9XZ0zFM6WMZPnuacwvpnzsVspCLN61kATC0yupA1lH9YoAiuzLfihk/lFMlhLW4kHMRCiO8pmk/m55tRE+xrA54Z0qLPwLIgoJWDM8erabn9PNKLi9ZCVscqYGM8EUPkXzYuS+/oOSchQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "E:/alipayLogs/";


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

