package com.springjpa.repo;

import com.springjpa.model.ProductTransaction;
import org.springframework.data.repository.CrudRepository;

public interface ProductTransactionRepository extends CrudRepository<ProductTransaction, Long> {
}
