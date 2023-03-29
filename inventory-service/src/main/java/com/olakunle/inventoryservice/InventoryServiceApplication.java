package com.olakunle.inventoryservice;

import com.olakunle.inventoryservice.entity.Inventory;
import com.olakunle.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner loadData (InventoryRepository inventoryRepository ) {
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("IPhone_13");
            inventory.setQuantity(10);

            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("IPhone_13_red");
            inventory1.setQuantity(0);

            inventoryRepository.saveAll(List.of(inventory, inventory1));
        };
    }
}
