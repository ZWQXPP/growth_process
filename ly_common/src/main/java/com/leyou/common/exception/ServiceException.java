package com.leyou.common.exception;


import com.leyou.common.constant.CommonConstants;


public class ServiceException extends BaseException {

    public ServiceException(String message) {
        super(message, CommonConstants.EX_OTHER_CODE);
    }

    public ServiceException(String message , int code) {
        super(message, code);
    }

}
