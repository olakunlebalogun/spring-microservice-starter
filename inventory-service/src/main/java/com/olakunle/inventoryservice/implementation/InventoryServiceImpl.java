package com.olakunle.inventoryservice.implementation;

import com.olakunle.inventoryservice.repository.InventoryRepository;
import com.olakunle.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional
    public boolean isInStock (String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
