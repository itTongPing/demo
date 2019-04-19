package json;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {



    public static void main(String[] args) {


        List list =  new ArrayList();

        Map map1 = new HashMap();

        map1.put("name", "张三");
        map1.put("age","40");



        Map map2 = new HashMap();
        map2.put("name", "李四");
        map2.put("age","35");

        list.add(map1);list.add(map2);

        String json = JSON.toJSONString(list);


        System.out.println(json);

    }
}
