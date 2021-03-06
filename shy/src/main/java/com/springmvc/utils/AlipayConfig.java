package com.springmvc.utils;

public class AlipayConfig {
	// 应用ID，您的APPID，收款账号既是您的APPID对应的支付宝账号
	public static String app_id = "2016092500597038";
	// 商户私钥
	public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgE9adCoucy3KpBtmwotDbtGOpNhzeuaQ3fbEOvlAJC1jApw3nhEOUTMAlsD4GXr6DZOtlb6qLHIAOKoNKtZnI43YpjJWouB7ldxiI9NUKNoVDsBk/gpvq/j9zmADrvqmCKOQae1nt8EiMMDAavTeVhlCF04tRPhOC45UThFgwX4ZsfdHqf4VxOVFztxJ1xDrTnvcJ9LJiUTgkU2Ht7f60nNig93jca206FGkB//blCKwx6lR1vY6XIu0MoWHQa8A53tKORyCgvcn6+RP/0jO194LoraU0RQBMyAbE/EfgoHwDv0VNo02+VNZdwl85G9c1LPwtenkX+aIBsgByop1hAgMBAAECggEARYeYZmnYLmioCwbwsyplMajuyOa6L3vO+lNb/p1nQiZtjHCDN5ZZjCayJyygJEAu2/+Px2VzXC0q6fxJPsAWZg12m6F2t+wRb3YFcCd4CZGY3Me2j8F5W97HTLwvWjZchi6gtWfyrcj6mfmsS1D4vbezbg1urAEclHOpouqPK6MCRAtc3oQhCkS/13Mve0oyb/jSjBFDwEZiBQ6jrm8+REC20VowZOr7y7SptVtF0qjkxcdnGK/TezvxGL5DfHLIE68XoFnOOEm5c3ah+Bq34UIxd9tHVbLOMoOhcWwopGO0lzaNgCtZwT9cCgSwvJIWt4HRq6XJvIpwsg/V4pEHYQKBgQDT3Lhf9xukfOH7DV/jRlYioQEHLEiQn+oihvy8P0rXVOwC/6t4KkNQ4Iqhb4c4tfGLQ1y5shTnBBHqg7jTFc8AS8E9wQmkI7R/jYsu2wAql0yaFW/CICeDAvN+CfV5lla2zcg4piDe+Z8uWLRrojVXHtRcuaIs+p1pWmJS3H1K/QKBgQDBbUbZTS/m8LpQxKt6Yct21ym0UrGC7Qd3W4nUa0m8vLUbCfNVCsNc17n4Z6xaagZ124EGMjHaZPj6JaEhsG36/kG9dLdkjDegP2tdNtYsMYREqcIqgvtexYrBIFjuVkOTAKlAgKa62GmiZUZnaQuz2w7sD68GLkQN8wwMv6+jNQKBgGjRQsb30s1Gm+dBbrdbDTKExaVu21fyRjxe3JumFLkEYt/47jS9dCCHdw73xsbf/WkRIsccvAqvkM2d7ctBdvCGikyrPMHgiGSy+rFr2GE6CcQR5wD8N5Ax3ZX2B2ToZG580Rp11r16cq7TZC/8SLeZoSdfEEWAmHCPLyYfwD1hAoGAWGUWIaxynbmZi9u0+eLDVvYRawT3dnvYE6XToS2+rvAWW9r6Rvz6Nu2nYWwPieo2NZowpqI9wi6u0bJspra4LCIR7QDv5pVlvmf9KsYqrluatL5Xq5HcSn1AYe3kdlcZ3o5Iyt+AUpcf/0UFHbEV1gXgFeU8+Tgfhbhy40iefZkCgYBiocG2NANu4stZIWPYJGdO7jtjq92KtH0stjABHvfEFJLGLfx8wr/Ex7/jPPcADQ5NrJHC13lvVOJi16Dsr2/H6UjrdeUG6A1e8wxhAqPZePS+en1CJ1g5QUze5FfHZcQYBX9oo5X6mefzMoOLSlzVCT2gT7Whbd6t/8SM0UohkA==";

	// 支付宝公钥
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtbxwXOtzWpVUtgPT6CY3bzcseF5xUz7Al7abqLD6suBGeg2GkOscorpHhtuNvA80M+mXhsCqDs7eH99ui8B4RM4hG4ycdEVCIyhtKhPB48cRKb6JXqOEUx66aXkoE4adVJCX2PHMLNIGn5riPaP6X3Y10hfGj++2EitH67c6GzW8277GlAXRYzgS4/++i+sg1Kj8r8IDeGq09IqBpQBydNjxAhV6Hjo2jh3/U8n8yj/XnThxTFdjU2KVkSkjgeEUEn2/zihE+KglTvsYRXaTaCMN2bTKSItmWfq9EZJx7WefjmNvQElJVkVROPxj4SmFGKZFsTjj0ysGdKm6CmS6kQIDAQAB";
	
	public static String notify_url = "http://localhost:8080/alipay/alipayNotifyNotice.action";
	
	public static String return_url = "http://localhost:8080/alipay/alipayReturnNotice.action";
	
	public static String sign_type = "RSA2";
	
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}
