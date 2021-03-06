package cn.panjin.shenxianbms.application.multithreading.dao;

import cn.panjin.shenxianbms.application.multithreading.entity.BmsOperationRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BmsOperationRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bms_operation_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bms_operation_record
     *
     * @mbggenerated
     */
    int insert(BmsOperationRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bms_operation_record
     *
     * @mbggenerated
     */
    BmsOperationRecord selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bms_operation_record
     *
     * @mbggenerated
     */
    List<BmsOperationRecord> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bms_operation_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BmsOperationRecord record);
}