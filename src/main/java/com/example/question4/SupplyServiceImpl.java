package com.example.question4;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SupplyServiceImpl implements SupplyService {
    private static final ArrayList<Supply> SupplyRecord = new ArrayList<>();

    /**
     * Sets supply record of products along with product id, date and quantity.
     * Stores data in SupplyRecord
     */
    @Override
    public void setSupplyRecord(){
        SupplyRecord.add(new Supply("Product1",LocalDateTime.of(2021,03,16,8,53,48),10.0));
        SupplyRecord.add(new Supply("Product2",LocalDateTime.of(2021,03,16,8,53,48),5.0));
        SupplyRecord.add(new Supply("Product3",LocalDateTime.of(2021,03,16,8,53,48),30.0));
        SupplyRecord.add(new Supply("Product4",LocalDateTime.of(2021,03,16,8,53,48),20.0));
    }


    /**
     * Gets Quantity of Supply from SupplyRecord which matches with data searched by user.
     *
     * Using streams, filter the matching product id, if found compare timestamp,
     * if the timestamp entered by user is after the existing timestamp,
     * it returns the temp value, i.e quantity of products.
     *
     * @param productId Product id entered by user in SupplyInput
     * @param updateTimeStamp Time stamp entered by user in SupplyInput
     * @param quantity Quantity of products entered by user in SupplyInput
     * @return temp variable of type double which stores quantity of matching record in SupplyRecord.
     */
    public double getStatus(String productId, LocalDateTime updateTimeStamp, Double quantity){

         double temp=0;
         temp= SupplyRecord.stream().filter(i -> i.getProductId().equals(productId) && i.getUpdateTimeStamp().isBefore(updateTimeStamp))
                .mapToDouble(i -> i.getQuantity()).sum();
         if(temp!=0)
         {
             temp= temp+quantity;
             return temp;
         }
         else
         return temp;
    }
}
