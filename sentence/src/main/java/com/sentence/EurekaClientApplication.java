package com.sentence;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class EurekaClientApplication {
   @Bean
   @LoadBalanced
   public RestTemplate returnRestTemplate()
   {
	   return new RestTemplate();
   }
   
   @Bean
   public Executor executor() {
   	return Executors.newFixedThreadPool(6);
   }
	
   public static void main(String args[])
   {
	   SpringApplication.run(EurekaClientApplication.class, args);
   }
}
