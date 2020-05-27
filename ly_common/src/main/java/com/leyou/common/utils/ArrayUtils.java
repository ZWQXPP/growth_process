package com.leyou.common.utils;

import java.util.List;

public class ArrayUtils {

    /**
     * @Title:
     * @Description:   获取第一条数据
     * @param datas
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2019/09/19 04:38:37
     */
    public static <T> T getFirst(List<T> datas) {
        if(datas != null && !datas.isEmpty()) {
            return datas.get(0);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   非空数据
     * @param datas
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2019/09/20 10:58:49
     */
    public static boolean isNotNullAndEmpty(List datas) {
        if(datas != null && !datas.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * @Title:
     * @Description:   空数据
     * @param datas
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2019/09/20 10:58:49
     */
    public static boolean isNullOrEmpty(List datas) {
        if(datas == null || datas.isEmpty()) {
            return true;
        }
        return false;
    }

}
