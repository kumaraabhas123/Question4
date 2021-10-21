package com.example.question4;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SupplyInput {

    String productId;
    LocalDateTime updateTimeStamp;
    Double quantity;
}
