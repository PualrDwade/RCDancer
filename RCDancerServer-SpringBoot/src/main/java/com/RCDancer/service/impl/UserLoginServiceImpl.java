package com.RCDancer.service.impl;

import com.RCDancer.dao.UserLoginMapper;
import com.RCDancer.model.UserLogin;
import com.RCDancer.service.UserLoginService;
import com.RCDancer.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by zhixuan chen on 2018/11/18.
 */
@Service
@Transactional
public class UserLoginServiceImpl extends AbstractService<UserLogin> implements UserLoginService {
    @Resource
    private UserLoginMapper userLoginMapper;

}
