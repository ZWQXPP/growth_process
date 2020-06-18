package com.leyou.common.msg.auth;

import com.yn.netcafe.common.constant.CommonConstants;
import com.yn.netcafe.common.msg.BaseResponse;

/**
 * Created by ace on 2017/8/25.
 */
public class UserTokenErrorResponse extends BaseResponse {
    public UserTokenErrorResponse(String message) {
        super(CommonConstants.EX_USER_INVALID_CODE, message);
    }
}
