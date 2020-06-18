package com.leyou.common.msg.v2.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4105929438667495907L;

    private String machineName;

}
