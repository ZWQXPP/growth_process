package com.leyou.common.msg.auth;

import com.yn.netcafe.common.constant.CommonConstants;
import com.yn.netcafe.common.msg.BaseResponse;

/**
 * Created by ace on 2017/8/23.
 */
public class ClientTokenErrorResponse extends BaseResponse {
    public ClientTokenErrorResponse(String message) {
        super(CommonConstants.EX_CLIENT_INVALID_CODE, message);
    }
}
