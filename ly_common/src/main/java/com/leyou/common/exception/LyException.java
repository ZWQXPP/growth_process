package com.leyou.common.exception;

import com.leyou.common.enums.ExceptionEnum;
import lombok.Data;

/**
 * @program: leyou_99
 * @description:
 **/
@Data
public class LyException extends RuntimeException{

    //存放异常状态码
    private Integer status;

    public LyException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.status = exceptionEnum.getStatus();
    }

    public LyException(ExceptionEnum exceptionEnum, Throwable cause) {
        super(exceptionEnum.getMessage(), cause);
        this.status = exceptionEnum.getStatus();
    }
}
