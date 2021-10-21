package com.example.question4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Represents controller class
 */
@RestController
public class SupplyController {

    @Autowired
    private SupplyServiceImpl service;

    /**
     * Get supply details along with productId, updateTimeStamp, Quantity and status.
     *
     * Check if the quantity is not equal to zero then return success status as "Updated"
     * and if quantity is equal to zero then return "Out of Sync Update".
     *
     * @param supplyInput Object of SupplyInput, stores data input by user
     * @return Supply product details and successfully updated or not along with Http Status.
     */
    @PostMapping("/updateSupply")
    public ResponseEntity<SupplyOutput> updateSupply(@RequestBody SupplyInput supplyInput){
        service.setSupplyRecord();
        double quantity = service.getStatus(supplyInput.getProductId(), supplyInput.getUpdateTimeStamp(), supplyInput.getQuantity());

        if(quantity!=0)
        {
            String status= "Updated";
            SupplyOutput supplyOutput= new SupplyOutput(supplyInput.getProductId(),supplyInput.getUpdateTimeStamp(), quantity, status);
            return new ResponseEntity<>(supplyOutput, HttpStatus.OK);
        }
        else {
            String status= "Out of Sync Update";
            SupplyOutput supplyOutput= new SupplyOutput(supplyInput.getProductId(),supplyInput.getUpdateTimeStamp(), supplyInput.getQuantity(), status);
            return new ResponseEntity<>(supplyOutput, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
