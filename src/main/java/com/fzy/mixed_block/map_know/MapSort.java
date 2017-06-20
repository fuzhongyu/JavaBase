package com.fzy.mixed_block.map_know;

import org.junit.Test;

import java.util.*;

/**
 * Map<Object,Integer> 类型，根据value排序
 *
 * Created by fuzhongyu on 2017/5/6.
 */
public class MapSort {

    @Test
    public void test(){
        Map<String,Integer> map=new HashMap<>();
        map.put("a",2);
        map.put("b",5);
        map.put("c",3);
        map.put("d",2);
        map.put("e",-1);
        System.out.println(Arrays.toString(sortMap(map).toArray()));
    }

    /**
     * Map排序
     * @param map
     * @return
     */
    public List<Map.Entry<String,Integer>> sortMap(Map<String,Integer> map){

        List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                //降序排列，若要写升序排列则可o2.getValue()-o1.getValue()
                return o1.getValue()-o2.getValue();
            }
        });

        return list;
    }

}
