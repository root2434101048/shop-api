package com.fh.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fh.mapper.DemoMaper;
import com.fh.model.BuyCar;
import com.fh.service.DemoService;
import com.fh.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMaper demoMaper;

    @Override
    public List<BuyCar> queryList() {
        //判断redis缓存中是否有数据
        String listRedis = RedisUtil.get("buyCarList");
        //如果为空
        //ArrayList<BuyCar> suyCar = new ArrayList<>();
        if (!StringUtils.isNotBlank(listRedis)){
            //就从数据库中取数据
             List<BuyCar> buyCarListOB = demoMaper.queryList();
            //将对象转为Spring类型的json字符串
            //String jsonString = JSONObject.toJSON(buyCarListOB).toString();
            String jsonString = JSONObject.toJSONString(buyCarListOB);
            //调用工具类 往缓存中放一份数据
            RedisUtil.set("buyCarList",jsonString);
            return buyCarListOB;

        }else {
            //将json字符串转为List集合
            List<BuyCar> buyCarList = JSONObject.parseArray(listRedis, BuyCar.class);
            return buyCarList;
        }
    }


}
