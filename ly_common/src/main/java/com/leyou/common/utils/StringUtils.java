package com.leyou.common.utils;


import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang3.StringUtils{
    private static Logger logger = LoggerFactory.getLogger(StringUtils.class);
    private static Pattern UNDER_LINE_PATTERN = Pattern.compile("_(\\w)");


    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }

    public static String lowerFirst(String str){
        if(org.apache.commons.lang3.StringUtils.isBlank(str)) {
            return "";
        } else {
            return str.substring(0,1).toLowerCase() + str.substring(1);
        }
    }

    public static String upperFirst(String str){
        if(org.apache.commons.lang3.StringUtils.isBlank(str)) {
            return "";
        } else {
            return str.substring(0,1).toUpperCase() + str.substring(1);
        }
    }

    /**
     * 替换掉HTML标签方法
     */
    public static String replaceHtml(String html) {
        if (isBlank(html)){
            return "";
        }
        String regEx = "<.+?>";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(html);
        String s = m.replaceAll("");
        return s;
    }

    /**
     * 缩略字符串（不区分中英文字符）
     * @param str 目标字符串
     * @param length 截取长度
     * @return
     */
    public static String abbr(String str, int length) {
        if (str == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int currentLength = 0;
            for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
                currentLength += String.valueOf(c).getBytes("GBK").length;
                if (currentLength <= length - 3) {
                    sb.append(c);
                } else {
                    sb.append("...");
                    break;
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(),e);
        }
        return "";
    }

    /**
     * 缩略字符串（替换html）
     * @param str 目标字符串
     * @param length 截取长度
     * @return
     */
    public static String rabbr(String str, int length) {
        return abbr(replaceHtml(str), length);
    }


    /**
     * 转换为Double类型
     */
    public static Double toDouble(Object val){
        if (val == null){
            return 0D;
        }
        try {
            return Double.valueOf(trim(val.toString()));
        } catch (Exception e) {
            return 0D;
        }
    }

    /**
     * 转换为Float类型
     */
    public static Float toFloat(Object val){
        return toDouble(val).floatValue();
    }

    /**
     * 转换为Long类型
     */
    public static Long toLong(Object val){
        return toDouble(val).longValue();
    }

    /**
     * 转换为Integer类型
     */
    public static Integer toInteger(Object val){
        return toLong(val).intValue();
    }

    /**
     * 将字符串首字母改为大写
     * @param str
     * @return
     */
    public static String toFirstCharUpperCase(String str){
        return str.replaceFirst(String.valueOf(str.charAt(0)),String.valueOf(str.charAt(0)).toUpperCase());

    }

    /**
     * 下划线转驼峰
     * */
    public static String underLineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = UNDER_LINE_PATTERN.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }


    /**
     * 驼峰转下划线
     * */
    public static String humpToUnderLine(String str) {
        if(StringUtils.isNotBlank(str)) {
            return str.replaceAll("[A-Z]", "_$0").toLowerCase();
        }
        return null;
    }

    /**
     * 把流转换字符串
     * @param is
     * @return
     */
    public static String inputStream2String(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }

}
