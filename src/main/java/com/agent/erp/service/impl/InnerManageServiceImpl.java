package com.agent.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agent.erp.dao.InnerManageMapper;
import com.agent.erp.model.InnerManageVo;
import com.agent.erp.service.InnerManageService;

@Service
@Transactional
public class InnerManageServiceImpl implements InnerManageService {

	@Autowired
	private InnerManageMapper innerManageMapper;

	@Override
	public List<InnerManageVo> selectSt() {
		return innerManageMapper.selectSt();
	}

}
