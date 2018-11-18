package com.RCDancer.service.impl;

import com.RCDancer.dao.UserDetailMapper;
import com.RCDancer.model.UserDetail;
import com.RCDancer.service.UserDetailService;
import com.RCDancer.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by zhixuan chen on 2018/11/18.
 */
@Service
@Transactional
public class UserDetailServiceImpl extends AbstractService<UserDetail> implements UserDetailService {
    @Resource
    private UserDetailMapper userDetailMapper;

}
