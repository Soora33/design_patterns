package com.sora;

import com.sora.factory.AliPayFactory;
import com.sora.factory.PayFactory;
import com.sora.factory.WechatPayFactory;
import com.sora.my_interface.Pay;

/**
 * @Classname ${NAME}
 * @Description ${Description}
 * @Date 2024/09/10 13:50
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        // 支付参数
        String param = "ali";

        PayFactory factory = null;
        if ("wechat".equals(param)) {
            factory = new WechatPayFactory();
        } else if ("ali".equals(param)) {
            factory = new AliPayFactory();
        }

        Pay payType = factory.getPayType();
        payType.pay();
    }
}