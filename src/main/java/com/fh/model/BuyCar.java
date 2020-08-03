package com.fh.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@TableName("t_buy_car")
public class BuyCar implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id		;//number(10)	主键ID

    private  String userName		;//varchar2(120)	购买人名称

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buyDate	;//	date	购买时间

    private  Integer isAllIn	;//	number	是否全款	1.是，2.否

    private  Integer carId		;//number	车辆主键ID

    public BuyCar() {
    }


    public BuyCar(Integer id, String userName, Date buyDate, Integer isAllIn, Integer carId) {
        this.id = id;
        this.userName = userName;
        this.buyDate = buyDate;
        this.isAllIn = isAllIn;
        this.carId = carId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Integer getIsAllIn() {
        return isAllIn;
    }

    public void setIsAllIn(Integer isAllIn) {
        this.isAllIn = isAllIn;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}
