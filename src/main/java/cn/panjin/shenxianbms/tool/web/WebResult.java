package cn.panjin.shenxianbms.tool.web;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 请求结果
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/1 0001 10:57
 * @Version 1.0
 */
@Data
public class WebResult<T> implements Serializable {
    /*响应码*/
    private Integer code = 200;
    /*响应信息*/
    private String msg = "请求成功";
    /*返回数据*/
    private T data;

    public WebResult(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
