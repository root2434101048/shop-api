package com.fh.mapper;

import com.fh.model.BuyCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DemoMaper {

    @Select("select * from t_buy_car")
    List<BuyCar> queryList();

}
