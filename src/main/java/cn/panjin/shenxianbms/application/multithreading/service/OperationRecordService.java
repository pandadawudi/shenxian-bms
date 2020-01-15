package cn.panjin.shenxianbms.application.multithreading.service;

/**
 * <p>
 * 日志操作接口
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/1/15 0015 14:13
 * @Version 1.0
 */
public interface OperationRecordService {
    /**
     * 新增日志
     * @return
     */
    int addOperationRecord(Long objectId, Integer operationType, String operationContent);
}
