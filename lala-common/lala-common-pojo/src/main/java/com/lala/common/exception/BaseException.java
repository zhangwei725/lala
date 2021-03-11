package com.lala.common.exception;

import com.lala.common.vo.ResponseCode;
import lombok.Data;

@Data
public class BaseException extends RuntimeException {
    /**
     * 错误的状态码
     */
    private int status;

    public BaseException(int status, String msg) {
        super(msg);
        this.status = status;
    }

    public BaseException(ResponseCode responseCode) {
        this(responseCode.getStatus(), responseCode.getMsg());
    }
}
