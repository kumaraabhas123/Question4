package com.example.question4;

import java.time.LocalDateTime;

/**
 * This is interface class
 */
public interface SupplyService {

    void setSupplyRecord();
    double getStatus(String productId, LocalDateTime updateTimeStamp, Double quantity);
}
