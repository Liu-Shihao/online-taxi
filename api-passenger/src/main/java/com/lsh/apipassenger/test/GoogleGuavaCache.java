package com.lsh.apipassenger.test;

import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/4/29 12:14 上午
 * @desc ：谷歌缓存Guava  可以当本地缓存
 */
@RequestMapping("/cache")
@RestController
public class GoogleGuavaCache {

    @Autowired
    LoadingCache<String, Object> cache;

    @GetMapping("/test-set/{id}")
    public String set(@PathVariable("id")String id){
        cache.put(id,new Random().nextInt(100));
        return "set success";
    }

    @GetMapping("/test-get/{id}")
    public String get(@PathVariable("id")String id) throws ExecutionException {
        cache.get(id);
        return "get success:"+cache.get(id);
    }


}
