import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.javafx.collections.MappingChange;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Throws_exception on 2016/5/29.
 */
public class test {


    @Test
    public void test(){
        int a = 127;
        int b = 12;
        int c =  Integer.parseInt("1100000",2);
        System.out.println(c);
        System.out.println(a&b);
    }

    @Test
    public void JsonTest(){
        String str = "{\"key\":1,\"key2\":2}";
        JSONObject object = JSON.parseObject(str);
        for(Map.Entry<String, Object> entry : object.entrySet()){
            int val = Integer.parseInt(String.valueOf(entry.getValue()));
            System.out.println(entry.getKey()+"---"+((Integer)entry.getValue()+5));
        }
        System.out.println(object.getInteger("key"));
        System.out.println(object.getInteger("key2"));
        System.out.println(object.getInteger("key3"));
    }

}
