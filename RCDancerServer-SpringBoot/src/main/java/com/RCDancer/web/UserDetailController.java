package com.RCDancer.web;

import com.RCDancer.core.Result;
import com.RCDancer.core.ResultGenerator;
import com.RCDancer.model.UserDetail;
import com.RCDancer.service.UserDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by zhixuan chen on 2018/11/18.
*/
@RestController
@RequestMapping("/user/detail")
public class UserDetailController {
    @Resource
    private UserDetailService userDetailService;

    @PostMapping
    public Result add(@RequestBody UserDetail userDetail) {
        userDetailService.save(userDetail);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Object id) {
        userDetailService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody UserDetail userDetail) {
        userDetailService.update(userDetail);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Object id) {
        UserDetail userDetail = userDetailService.findById(id);
        return ResultGenerator.genSuccessResult(userDetail);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserDetail> list = userDetailService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
