package com.leyou.common.msg.auth;


import com.leyou.common.constant.CommonConstants;
import com.leyou.common.msg.BaseResponse;

public class HotelTokenErrorResponse extends BaseResponse {
    public HotelTokenErrorResponse(String message) {
        super(CommonConstants.EX_HOTEL_INVALID_CODE, message);
    }
}
