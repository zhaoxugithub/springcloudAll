package com.serendipity.cloudeurekaclientprovider.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

/**
 * ClassName HealthSerivce
 * Description TODO
 * Author 11931
 * Date 2023-08-02:11:12
 * Version 1.0
 **/
@Service
public class HealthStatusService implements HealthIndicator {

    private Boolean status = true;


    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health() {
        if (status) {
            return new Health.Builder().up().build();
        }
        return new Health.Builder().down().build();
    }

    @Override
    public String toString() {
        return "HealthStatusService{" + "status=" + status + '}';
    }
}
