package cn.panjin.shenxianbms.base.compiler.entity;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/2/27 0027 10:55
 * @Version 1.0
 */
public class ParamsListVO {
    private List<ParamsVO> list;
    private String code;

    public List<ParamsVO> getList() {
        return list;
    }

    public void setList(List<ParamsVO> list) {
        this.list = list;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
