package com.lala.order.exception;

import com.lala.common.exception.BaseException;
import com.lala.common.vo.ResponseCode;

public class OrderException extends BaseException {
    public OrderException(int status, String msg) {
        super(status, msg);
    }

    public OrderException(ResponseCode responseCode) {
        super(responseCode);
    }
}
