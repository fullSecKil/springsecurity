package com.example.sericefeign.feigninterface;

import org.springframework.stereotype.Component;

/**
 * @author dusk
 * @since 2020/6/21 23:37
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry" + name;
    }
}
