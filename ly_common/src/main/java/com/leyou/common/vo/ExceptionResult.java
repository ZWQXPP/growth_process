package com.leyou.common.vo;

import com.leyou.common.exception.LyException;
import lombok.Data;
import org.joda.time.DateTime;

/**
 * @program: leyou_99
 * @description: 给前端返回异常对象
 **/
@Data
public class ExceptionResult {

    private Integer status;
    private String message;
    private String timeStampt;


    public ExceptionResult(LyException e) {
        this.status = e.getStatus();
        this.message = e.getMessage();
        this.timeStampt = DateTime.now().toString("yyyy-MM-dd hh:mm:ss");
    }
}
