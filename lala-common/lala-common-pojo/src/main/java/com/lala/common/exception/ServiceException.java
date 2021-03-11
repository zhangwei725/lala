package com.lala.common.exception;


import com.lala.common.vo.ResponseCode;

public class ServiceException extends BaseException {

    public ServiceException(int status, String msg) {
        super(status, msg);
    }

    public ServiceException(ResponseCode responseCode) {
        super(responseCode);
    }
}
