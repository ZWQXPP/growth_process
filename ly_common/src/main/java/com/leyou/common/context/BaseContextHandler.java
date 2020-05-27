package com.leyou.common.context;

import com.leyou.common.constant.CommonConstants;
import com.leyou.common.utils.StringUtils;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by ace on 2017/9/8.
 */
public class BaseContextHandler {
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static String getUserID() {
        Object value = get(CommonConstants.CONTEXT_KEY_USER_ID);
        return returnObjectValue(value);
    }

    public static String getUsername() {
        Object value = get(CommonConstants.CONTEXT_KEY_USERNAME);
        return returnObjectValue(value);
    }


    public static String getName() {
        Object value = get(CommonConstants.CONTEXT_KEY_USER_NAME);
        return StringUtils.getObjectValue(value);
    }

    public static String getToken() {
        Object value = get(CommonConstants.CONTEXT_KEY_USER_TOKEN);
        return StringUtils.getObjectValue(value);
    }

    public static String getTraceId() {
        Object value = get(CommonConstants.TRACE_ID);
        return StringUtils.getObjectValue(value);
    }

    public static void setToken(String token) {
        set(CommonConstants.CONTEXT_KEY_USER_TOKEN, token);
    }

    public static void setTraceId(String traceId) {
        set(CommonConstants.TRACE_ID, traceId);
    }

    public static void setName(String name) {
        set(CommonConstants.CONTEXT_KEY_USER_NAME, name);
    }

    public static void setUserID(String userID) {
        set(CommonConstants.CONTEXT_KEY_USER_ID, userID);
    }

    public static void setUsername(String username) {
        set(CommonConstants.CONTEXT_KEY_USERNAME, username);
    }

    private static String returnObjectValue(Object value) {
        return value == null ? null : value.toString();
    }

    public static void remove() {
        threadLocal.remove();
    }

    public static void setRoomId(String roomId) {
        set(CommonConstants.HOTEL_ROOM_ID, roomId);
    }

    public static void setHotelId(String hotelId) {
        set(CommonConstants.HOTEL_HOTEL_ID, hotelId);
    }

    public static void setBranchId(String branchId) {
        set(CommonConstants.HOTEL_BRANCH_ID, branchId);
    }

    public static String getRoomId() {
        Object value = get(CommonConstants.HOTEL_ROOM_ID);
        return returnObjectValue(value);
    }
    public static String getHotelId() {
        Object value = get(CommonConstants.HOTEL_HOTEL_ID);
        return returnObjectValue(value);
    }
    public static String getBranchId() {
        Object value = get(CommonConstants.HOTEL_BRANCH_ID);
        return returnObjectValue(value);
    }
}
