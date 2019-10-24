package com.gjxx.springbootswagger.controller;

import com.gjxx.springbootswagger.entity.PersonPO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sxs
 * @description swagger demo
 * @date 2019/10/24 11:25
 */
@Api(tags = "swagger post请求测试接口", description = "描述信息")
@RestController
@RequestMapping("/swagger_demo_post")
public class SwaggerPostDemoController {

    @PostMapping("/test_post_one")
    @ApiOperation(value = "一个参数的post请求测试")
    @ApiImplicitParam(name = "person", value = "请求参数", required = true, dataType = "PersonPO")
    public String test(@RequestBody PersonPO person) {

        return person + " 测试成功";
    }

    @PostMapping("/test_post_more-{twoPara}")
    @ApiOperation(value = "多个参数的post请求测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "person", value = "请求参数", required = true, dataType = "PersonPO"),
            @ApiImplicitParam(name = "twoPara", value = "第二个参数", required = true, dataType = "String", defaultValue = "two")
    })
    public String test2(@RequestBody PersonPO person, @PathVariable("twoPara") String twoPara) {

        return person + " 测试成功 " + twoPara;
    }

}
