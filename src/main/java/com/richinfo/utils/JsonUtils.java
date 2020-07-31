package com.richinfo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * json工具类
 *
 * @author yexuce
 * @date 2019-05-14
 */
public class JsonUtils {

    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转JSON
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String obj2String(T obj) {
        if (null == obj) {
            return null;
        }

        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            logger.warn("对象转JSON错误", e);
            return null;
        }
    }

    /**
     * 将对象转JSON,并格式化输出
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String obj2StringPretty(T obj) {
        if (null == obj) {
            return null;
        }

        try {
            return obj instanceof String ? (String) obj : objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            logger.warn("对象转JSON错误", e);
            return null;
        }
    }

    public static <T> T string2Obj(String str, Class<T> clazz) {
        if (StringUtils.isEmpty(str) || null == clazz) {
            return null;
        }

        try {
            return clazz.equals(String.class) ? (T) str : objectMapper.readValue(str, clazz);
        } catch (Exception e) {
            logger.warn("JSON转对象错误", e);
            return null;
        }
    }
}
