package com.lala.common.exception;

import com.lala.common.vo.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sun.rmi.runtime.Log;

/**
 * 全局异常
 * 1> @RestControllerAdvice
 * 2>  @ExceptionHandler
 * 线上错误的排查
 */
@RestControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler
    public ResponseResult<Object> handler(Exception ex) {
        int status = 0;
        String message = null;
        if (ex instanceof ServiceException) {
            status = ((ServiceException) ex).getStatus();
            message = ex.getMessage();
        } else if (ex instanceof DaoException) {
            status = ((DaoException) ex).getStatus();
            message = ex.getMessage();
        } else {
            return ResponseResult.error();
        }
        return ResponseResult.error(status, message);
    }

}
