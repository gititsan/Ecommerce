package com.sana.supplier.service;

import java.util.List;
import java.util.Optional;

import com.sana.supplier.model.Supplier;

public interface SupplierService {
	
	public List<Supplier> getListSuppliers();
	public void saveAndUpdate( Supplier supplier );
	public void deleteSupplier( String id );
	public Supplier getSupplierById( String id );

}
