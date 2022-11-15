package com.sana.supplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sana.supplier.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {

 

}
