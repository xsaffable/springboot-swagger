package com.gjxx.springbootswagger.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Sxs
 * @description swagger demo中测试方法的传入参数
 * @date 2019/10/24 11:27
 */
@Data
@ApiModel(value = "PersonPO", description = "请求参数封装对象")
public class PersonPO {

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名", example = "李四")
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄", example = "23")
    private int age;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", example = "2019-10-24 15:50:11")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
