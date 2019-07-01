package cn.panjin.shenxianbms.tool.web;

import lombok.Data;

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
public class WebResult<T> {
    /*响应码*/
    private String code;
    /*响应信息*/
    private String msg;
    /*返回数据*/
    private T data;
}
