package com.wallfacers.data.platform.common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Collection;
import java.util.List;

/**
 * 模型类转换工具类
 *
 * @author wallfacers
 */
public abstract class AbstractCopyUtils {

    public static final Gson GSON = new Gson();

    public static <T, R> R copy(T t, Class<R> r) {
        return GSON.fromJson(GSON.toJson(t), r);
    }

    public static <T, R> Collection<R> copyCollection(Collection<T> list, Class<R> r) {
        return GSON.fromJson(GSON.toJson(list), TypeToken.getParameterized(Collection.class, r).getType());
    }

    public static <T, R> List<R> copyList(List<T> list, Class<R> r) {
        return GSON.fromJson(GSON.toJson(list), TypeToken.getParameterized(List.class, r).getType());
    }

}