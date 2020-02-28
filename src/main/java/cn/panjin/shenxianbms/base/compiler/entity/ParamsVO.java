package cn.panjin.shenxianbms.base.compiler.entity;

/**
 * <p>
 *
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/2/27 0027 10:51
 * @Version 1.0
 */
public class ParamsVO {
    //参数名称
    private String paramName;
    //参数类型
    private String paramType;
    //参数类型class
    private Class cl;
    //参数类型
    private String sql;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public Class getCl() {
        return cl;
    }

    public void setCl(Class cl) {
        this.cl = cl;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
