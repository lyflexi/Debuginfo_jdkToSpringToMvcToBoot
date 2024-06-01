package org.lyflexi.debug_springboot.actuator.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

/**
 * @Author: ly
 * @Date: 2024/1/30 10:21
 */
@Component
public class MyLaLaComponent {
    Counter counter = null;

    /**
     * 注入 meterRegistry 来保存和统计所有指标
     * @param meterRegistry
     */
    public MyLaLaComponent(MeterRegistry meterRegistry){
        //得到一个名叫 myhaha.hello 的计数器
        counter = meterRegistry.counter("lala.counter");
    }


    public void hello(){
        System.out.println("hello");
        counter.increment();
    }
}
