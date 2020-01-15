package cn.panjin.shenxianbms.application.multithreading.controller;

import cn.panjin.shenxianbms.application.multithreading.service.BuyGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 购买商品Controller
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/1/15 0015 13:45
 * @Version 1.0
 */
@Controller
@RequestMapping("/goods/")
public class BuyGoodsController {

    @Autowired
    private BuyGoodsService buyGoodsService;

    /**
     * 购买商品
     */
    @RequestMapping(value = "buyGoods.do", method = RequestMethod.POST)
    @ResponseBody
    public void buyGoods(){
        buyGoodsService.multithreadingBuyGoods();
    }
}
