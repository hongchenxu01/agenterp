package com.agent.erp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agent.erp.dao.UserMapper;
import com.agent.erp.model.User;
import com.agent.erp.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public String save(User record) {
		return userMapper.insert(record);
	}

}
