package cn.panjin.shenxianbms.application.multithreading.service.impl;

import cn.panjin.shenxianbms.application.multithreading.service.VolatileService;
import cn.panjin.shenxianbms.model.singleton.Singleton;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Volatile关键字学习
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/12/30 0030 19:23
 * @Version 1.0
 */
@Service
public class VolatileServiceImpl implements VolatileService {

    @Override
    public void volatileTest() {
        for (int i = 0; i < 10000; i++){
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            Singleton.getSingleton();
                        }
                    }
            ).start();

        }
    }
}
