package com.example.sericefeign.feigninterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dusk
 * @since 2020/6/21 18:37
 */
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
    @GetMapping("/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
