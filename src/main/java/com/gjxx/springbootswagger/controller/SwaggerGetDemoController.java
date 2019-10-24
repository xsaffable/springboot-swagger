package com.gjxx.springbootswagger.controller;

import com.gjxx.springbootswagger.entity.PersonPO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sxs
 * @description swagger demo
 * @date 2019/10/24 14:57
 */
@Api(tags = "swagger get请求测试接口", description = "描述信息")
@RestController
@RequestMapping("/swagger_demo_get")
public class SwaggerGetDemoController {

    @GetMapping("/test_get_one")
    @ApiOperation(value = "一个参数的get请求测试")
    @ApiImplicitParam(name = "name", value = "请求参数", required = true, dataType = "String", defaultValue = "张三")
    public String test(String name) {

        return name + " 测试成功";
    }

    @GetMapping("/test_get_one2")
    @ApiOperation(value = "一个参数(封装)的get请求测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String", defaultValue = "张三"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "int", defaultValue = "22"),
            @ApiImplicitParam(name = "createTime", value = "创建时间", required = true, dataType = "String", defaultValue = "2019-10-24 15:39:28")

    })
    public String test1(PersonPO person) {

        return person + " 测试成功";
    }

    @GetMapping("/test_get_more")
    @ApiOperation(value = "多个参数的get请求测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String", defaultValue = "张三"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "int", defaultValue = "22")
    })
    public String test2(String name, String age) {

        return name + " 测试成功，" + "年龄：" + age;
    }

}
