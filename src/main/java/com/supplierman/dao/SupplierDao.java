package com.supplierman.dao;

import com.supplierman.entity.Supplier;

public interface SupplierDao 
{

	public boolean saveSupplier(Supplier supplier);

	public Supplier getSupplierById(int supId);

	public boolean updateSupplier(Supplier supplier);

	public Supplier deleteSupplierById(int supId);

}
