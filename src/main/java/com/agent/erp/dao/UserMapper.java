package com.agent.erp.dao;

import org.apache.ibatis.annotations.Mapper;

import com.agent.erp.model.User;

@Mapper
public interface UserMapper {
    String insert(User record);

    String insertSelective(User record);
}