package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

public class MyselfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule_ZY();
    }
}
