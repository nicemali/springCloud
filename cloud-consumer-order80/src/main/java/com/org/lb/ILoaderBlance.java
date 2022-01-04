package com.org.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface ILoaderBlance {

    ServiceInstance instance (List<ServiceInstance> ServiceInstances);
}
