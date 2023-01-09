package com.example.server.domain.util;

import java.util.LinkedHashMap;

public class OutportMapper {

    public static <T>LinkedHashMap<String, Object> toDto(T obj){
        LinkedHashMap<String, Object> listMap = new LinkedHashMap<>();

        listMap.put("status", "success");
        listMap.put("data", obj);
        listMap.put("message", "데이터 수정완료");

        return listMap;
    }
}
