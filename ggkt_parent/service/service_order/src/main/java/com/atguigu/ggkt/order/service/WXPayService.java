package com.atguigu.ggkt.order.service;

import java.util.Map;

public interface WXPayService {
    Map createJsapi(String orderNo);

    Map queryPayStatus(String orderNo);
}