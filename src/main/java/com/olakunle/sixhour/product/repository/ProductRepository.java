package com.olakunle.sixhour.product.repository;

import com.olakunle.sixhour.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
public interface ProductRepository extends JpaRepository<Product, Integer> {
=======
public interface ProductRepository extends MongoRepository<Product, String> {
>>>>>>> 2cb0402 (changes made on this branch)

}
