package cn.panjin.shenxianbms.base.compiler.service;

import cn.panjin.shenxianbms.base.compiler.entity.SpcSourceData;
import cn.panjin.shenxianbms.base.user.entity.BaseUser;
import cn.panjin.shenxianbms.tool.web.WebResult;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/2/26 0026 19:40
 * @Version 1.0
 */
public interface CompilerService {
    List<SpcSourceData> getSourceDataByStatus();
    WebResult compileSourceCode(String textareaData, String dataArr);
    WebResult calculationThisUser(String textareaData, String dataArr, Long userId);
}
