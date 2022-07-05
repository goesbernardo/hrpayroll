package com.goesbernardo.hrpayrool.service;

import com.goesbernardo.hrpayrool.domain.Payment;
import com.goesbernardo.hrpayrool.domain.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String url;

    public Payment getPayment(long workerId , int days) {

        Map<String, String> uriMap = new HashMap<>();
        uriMap.put("id","" +  workerId);
        Worker worker = restTemplate.getForObject(url + "/workers/{id}", Worker.class, uriMap);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);

    }
}
