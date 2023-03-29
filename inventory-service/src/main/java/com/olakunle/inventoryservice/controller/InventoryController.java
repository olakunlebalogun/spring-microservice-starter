package com.olakunle.inventoryservice.controller;


import com.olakunle.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/inventory")
@RestController
public class InventoryController {
    private final InventoryService inventoryService;

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public void getInventory() {
//
//    }

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock (@PathVariable("sku-code") String skuCode) {
        return inventoryService.isInStock(skuCode);
    }
}
