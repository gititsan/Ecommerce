package com.sana.supplier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.supplier.model.Supplier;
import com.sana.supplier.repository.SupplierRepository;
 

@Service
public class SupplierServiceImp implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	public List<Supplier> getListSuppliers() {

		return supplierRepository.findAll();
	}

	@Override
	public void saveAndUpdate(Supplier supplier) {
		supplierRepository.save(supplier);
		
	}

	@Override
	public void deleteSupplier(String id) {
		supplierRepository.deleteById(id);
		
	}

	@Override
	public Supplier getSupplierById(String id) {
		return supplierRepository.findById(id).get();
				
	}

}
