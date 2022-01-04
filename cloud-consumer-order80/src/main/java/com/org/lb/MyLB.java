package com.org.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyLB implements  ILoaderBlance{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!atomicInteger.compareAndSet(current,next));
        log.info("****next: "+ next);

        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> ServiceInstances) {
        int index = getAndIncrement() % ServiceInstances.size();
        ServiceInstance server = ServiceInstances.get(index);
        if(server != null){
            return server;
        }else{
            return  null;
        }
    }
}
