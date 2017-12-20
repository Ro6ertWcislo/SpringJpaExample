package com.springjpa.repo;

import com.springjpa.model.StoreTransaction;
import org.springframework.data.repository.CrudRepository;

public interface StoreTransactionRepository extends CrudRepository<StoreTransaction, Long> {
}
