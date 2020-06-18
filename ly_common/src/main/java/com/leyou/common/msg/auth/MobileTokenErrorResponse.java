package com.leyou.common.msg.auth;


import com.leyou.common.constant.CommonConstants;
import com.leyou.common.msg.BaseResponse;

/**
 * Created by ace on 2017/8/23.
 */
public class MobileTokenErrorResponse extends BaseResponse {
    public MobileTokenErrorResponse(String message) {
        super(CommonConstants.EX_MOBILE_INVALID_CODE, message);
    }
}
