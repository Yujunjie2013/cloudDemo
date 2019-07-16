package com.taotao.service.eurekaservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.LinkedHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaServiceApplicationTests {

    @Test
    public void contextLoads() {
        String name = "展示";
        HashMap<String, Integer> map = new HashMap<>(null);
        map.put("aaa", 1);
        map.put("bbb", 32);
        map.get("aaa");
//        map.putIfAbsent("bbb",2);
//        map.putIfAbsent("bbb",3);
        Integer bbb = map.get("bbb");
        System.out.println("nei:" + bbb);
        int n = 20;
        int a = n >>> 2;
        int b = n >>> 4;
        int c = n >>> 8;
        int d = n >>> 16;
        int e = n >>> 1;
        System.out.println("值：" + a);
        System.out.println("b值：" + b);
        System.out.println("c值：" + c);
        System.out.println("d值：" + d);
        System.out.println("e值：" + e);
//        0001 0100
//        0001   1110
//        2*2*2*2*2
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        System.out.println("aaa哈希：" + hash("aaa"));
        int aaa = hash("aaa");
        int bb = hash("b");
        int cc = hash("cc");
        int dd = hash("d");
        int r = hash("l");
        int t = hash("t");
        int i = aaa & 15;
        System.out.println("--->" + aaa + "-i--->" + i);
        System.out.println("bb:" + bb);
        System.out.println("cc:" + cc);
        System.out.println("dd:" + dd);

        System.out.println("bb&:" + (bb & 15));
        System.out.println("cc&:" + (cc & 15));
        System.out.println("dd&:" + (dd & 15));
        System.out.println("r&:" + (r & 15) + "--->r:" + r);
        System.out.println("t&:" + (t & 15) + "----t:" + t);
        System.out.println("\n\n\n");
        for (int j = 20; j < 100; j++) {
            System.out.println(j & 19);
        }


        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("","");
        map.remove("");
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


}
