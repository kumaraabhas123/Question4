package com.example.question4;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents Supply class
 */
@Data
@AllArgsConstructor
public class Supply {
    String productId;
    LocalDateTime updateTimeStamp;
    Double quantity;
}
