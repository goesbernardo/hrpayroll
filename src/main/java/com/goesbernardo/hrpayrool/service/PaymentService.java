package com.goesbernardo.hrpayrool.service;

import com.goesbernardo.hrpayrool.domain.Payment;
import com.goesbernardo.hrpayrool.domain.Worker;
import com.goesbernardo.hrpayrool.feignclients.WorkFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkFeignClient workFeignClient;


    public Payment getPayment(long workerId , int days) {

        Worker worker = workFeignClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);

    }
}
