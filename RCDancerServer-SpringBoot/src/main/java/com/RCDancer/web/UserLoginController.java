package com.RCDancer.web;

import com.RCDancer.core.Result;
import com.RCDancer.core.ResultGenerator;
import com.RCDancer.model.UserLogin;
import com.RCDancer.service.UserLoginService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by zhixuan chen on 2018/11/18.
*/
@RestController
@RequestMapping("/user/login")
public class UserLoginController {
    @Resource
    private UserLoginService userLoginService;

    @PostMapping
    public Result add(@RequestBody UserLogin userLogin) {
        userLoginService.save(userLogin);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Object id) {
        userLoginService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody UserLogin userLogin) {
        userLoginService.update(userLogin);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Object id) {
        UserLogin userLogin = userLoginService.findById(id);
        return ResultGenerator.genSuccessResult(userLogin);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserLogin> list = userLoginService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
