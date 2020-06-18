package com.leyou.common.msg.auth;


import com.leyou.common.constant.CommonConstants;
import com.leyou.common.msg.BaseResponse;

/**
 * Created by ace on 2017/8/25.
 */
public class UserTokenErrorResponse extends BaseResponse {
    public UserTokenErrorResponse(String message) {
        super(CommonConstants.EX_USER_INVALID_CODE, message);
    }
}
