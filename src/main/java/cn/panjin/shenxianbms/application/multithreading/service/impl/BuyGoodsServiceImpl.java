package cn.panjin.shenxianbms.application.multithreading.service.impl;

import cn.panjin.shenxianbms.application.multithreading.dao.BmsGoodsMapper;
import cn.panjin.shenxianbms.application.multithreading.entity.BmsGoods;
import cn.panjin.shenxianbms.application.multithreading.service.BuyGoodsService;
import cn.panjin.shenxianbms.application.multithreading.service.OperationRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 商品操作实现类
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/1/15 0015 13:49
 * @Version 1.0
 */
@Service
@Slf4j
public class BuyGoodsServiceImpl implements BuyGoodsService {

    @Resource
    private BmsGoodsMapper bmsGoodsMapper;

    @Resource
    private OperationRecordService operationRecordService;

    /**
     * 设置多个线程抢购商品
     */
    @Override
    public void multithreadingBuyGoods() {
        for (int i = 0; i < 5; i++){
            new Thread(){
                public void run(){
                    long threadId = Thread.currentThread().getId();
                    busGoods(123456789L, threadId);
                }
            }.start();

        }
    }

    /**
     * 购买商品逻辑方法
     * @param id 商品ID
     */
    @Transactional
    public synchronized void busGoods(Long id, Long userId){
        BmsGoods bmsGoods = bmsGoodsMapper.selectByPrimaryKey(id);
        if(bmsGoods == null){
            operationRecordService.addOperationRecord(bmsGoods.getId(), 91
                    , userId + "购买商品时，商品不存在，无法购买");
            return;
        }
        if(bmsGoods.getPersonId() != null){
            operationRecordService.addOperationRecord(bmsGoods.getId(), 92
                    , userId + "购买商品时，商品已被购买");
            return;
        }
        int count = updateGoods(bmsGoods, userId);
        if(count == 1){
            operationRecordService.addOperationRecord(bmsGoods.getId(), 93
                    , "商品已被" + userId + "购买，购买成功");
        }else {
            operationRecordService.addOperationRecord(bmsGoods.getId(), 94
                    , "商品被" + userId + "购买，购买失败");
        }

    }

    /**
     * 更新商品所属人
     * @return
     */
    private int updateGoods(BmsGoods bmsGoods, Long userId){
        bmsGoods.setPersonId(userId);
        return bmsGoodsMapper.updateByPrimaryKey(bmsGoods);
    }
}
