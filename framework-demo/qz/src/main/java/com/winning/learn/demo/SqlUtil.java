package com.winning.learn.demo;

import cn.hutool.core.util.StrUtil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhengjunhua
 * @version 1.0
 * @date 2020/11/18
 **/
public class SqlUtil {

    private static final Map<TimeCondition, Map<String, String>> sqlMap = new ConcurrentHashMap<>();

    public static Map<String, String> buildSelectSql(String fileName, String beginTime, String endTime) {
        TimeCondition time = new TimeCondition(beginTime, endTime);
        if (!sqlMap.containsKey(time)) {
            sqlMap.clear();
            Map<String, String> map = sqlInit(fileName);
            map.forEach((k, v) -> {
                map.put(k, StrUtil.format(v, beginTime, endTime));
            });
            sqlMap.put(time, map);
        }
        return sqlMap.get(time);
    }

    private static Map<String, String> sqlInit(String fileName) {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        String path1 = ClassLoader.getSystemClassLoader().getResource(fileName).getPath();
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path1), "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String[] split = builder.toString().split(";");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < split.length - 1; i++) {
            if ((i & 1) == 0) {
                map.put(split[i], split[i+1] + ";");
            }
        }
        return map;
    }

    private static class TimeCondition{
        String beginTime;
        String endTime;

        public TimeCondition() {
        }

        public TimeCondition(String beginTime, String endTime) {
            this.beginTime = beginTime;
            this.endTime = endTime;
        }

        @Override
        public int hashCode() {
            return Objects.hash(beginTime, endTime);
        }
    }

}
