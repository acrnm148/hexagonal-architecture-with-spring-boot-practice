package com.mycom.myboard.adapter.aspect;

import com.mycom.myboard.common.annotation.RedisCachedKeyParam;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class RedisCacheParameterMethodInfo {
    List<IndexInfo> indexInfoList = new LinkedList<>();

    public void addInfo(RedisCachedKeyParam keyParam, Integer index ) {
        indexInfoList.add(new IndexInfo(keyParam, index));
    }

    @Data
    @AllArgsConstructor
    public class IndexInfo {
        RedisCachedKeyParam annotation;
        Integer index;

    }
}