package com.agent.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.agent.erp.model.InnerManageVo;

@Mapper
public interface InnerManageMapper {

    List<InnerManageVo> selectSt();
}