package com.supplierman.serviceIMPL;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplierman.dao.SupplierDao;
import com.supplierman.entity.Supplier;
import com.supplierman.service.SupplierService;

@Service
public class SupplierServiceIMPL implements SupplierService
{
	@Autowired
	private SupplierDao supplierDao;
	
//	@Autowired
//	private SupplierService supplierService;
	
	
	@Override
	public boolean saveSupplier(Supplier supplier) 
	{
		
		return supplierDao.saveSupplier(supplier);
	}

	@Override
	public Supplier getSupplierById(int supId) 
	{
		
		return supplierDao.getSupplierById(supId);
	}

	
	@Override
	public boolean updateSupplier(Supplier supplier) 
	{
		
		return supplierDao.updateSupplier(supplier);
	}

	@Override
	public Supplier deleteSupplierById(@Valid int supId) 
	{
	
		return supplierDao.deleteSupplierById(supId);
	}

}
