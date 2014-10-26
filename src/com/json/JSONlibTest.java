package com.json;

import com.domain.Province;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by etund on 2014/9/21.
 */
@SuppressWarnings("all")
public class JSONlibTest {

           @Test
           public  void test1(){
                    Province p = new Province("山东省","250000");
                JSONObject jsonObj = JSONObject.fromObject(p);
                System.out.println(jsonObj.toString());
        }

    @Test
    public void test2(){
        List<Province> ps = new ArrayList<Province>();
        ps.add(new Province("安徽省","001"));
        ps.add(new Province("广东省","002"));
        ps.add(new Province("香港","003"));
        JSONArray jsonArr = JSONArray.fromObject(ps);
        System.out.println(jsonArr.toString());
    }

    @Test
    public void test3(){
        List<Province> ps = new ArrayList<Province>();
//        List<Province> ps = new ArrayList<Province>();
        ps.add(new Province("安徽省","001"));
        ps.add(new Province("广东省","002"));
        ps.add(new Province("香港","003"));

        JsonConfig cfg = new JsonConfig();
        cfg.setExcludes(new String[]{"zipcode"});

        JSONArray jsonArr = JSONArray.fromObject(ps,cfg);
        System.out.println(jsonArr.toString());
    }

}
