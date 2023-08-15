package com.supplierman.service;

import com.supplierman.entity.Supplier;

public interface SupplierService 
{
	public boolean saveSupplier(Supplier supplier);

	public Supplier getSupplierById(int supId);

	public boolean updateSupplier(Supplier supplier);

	public Supplier deleteSupplierById(int supId);
}
