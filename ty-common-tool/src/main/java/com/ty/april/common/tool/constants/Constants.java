package com.ty.april.common.tool.constants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: wenqing
 * @date: 2019/4/8 10:20 AM
 * @description:
 */
public final class Constants {
    private Constants() {
    }
    /**
     * 是否有效
     */
    public interface Flag {
        // 有效
        String VALID = "1";
        // 无效
        String UNVALID = "0";
    }

}

