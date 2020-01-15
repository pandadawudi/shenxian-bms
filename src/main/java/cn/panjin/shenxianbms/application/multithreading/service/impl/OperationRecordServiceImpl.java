package cn.panjin.shenxianbms.application.multithreading.service.impl;

import cn.panjin.shenxianbms.application.multithreading.dao.BmsOperationRecordMapper;
import cn.panjin.shenxianbms.application.multithreading.entity.BmsOperationRecord;
import cn.panjin.shenxianbms.application.multithreading.service.OperationRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 日志操作类
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/1/15 0015 14:13
 * @Version 1.0
 */
@Service
@Slf4j
public class OperationRecordServiceImpl implements OperationRecordService {

    @Resource
    private BmsOperationRecordMapper bmsOperationRecordMapper;

    /**
     * 新增日志
     * @return
     */
    @Override
    public int addOperationRecord(Long objectId, Integer operationType, String operationContent) {
        BmsOperationRecord bmsOperationRecord = new BmsOperationRecord();
        bmsOperationRecord.setObjectId(objectId);//操作对象ID
        bmsOperationRecord.setOperationType(operationType);
        bmsOperationRecord.setOperationContent(operationContent);
        bmsOperationRecord.setCreaterId(1L);
        bmsOperationRecord.setCreaterOrgId(1L);
        bmsOperationRecord.setCreateTime(new Date());
        return bmsOperationRecordMapper.insert(bmsOperationRecord);
    }
}
