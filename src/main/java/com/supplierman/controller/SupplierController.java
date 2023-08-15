package com.supplierman.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplierman.dao.SupplierDao;
import com.supplierman.entity.Supplier;
import com.supplierman.exception.SupplierNameAlreadyExistException;
import com.supplierman.exception.SupplierNotFoundException;
import com.supplierman.service.SupplierService;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController
{
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@PostMapping(value = "/save-supplier")
	public ResponseEntity<Boolean> saveSupplier(@Valid @RequestBody Supplier supplier) 
	{
		boolean isAdded = supplierService.saveSupplier(supplier);	
		if(isAdded)
		{
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		}
		else
		{
			throw new SupplierNameAlreadyExistException("Supplier is Already Exist for : "+supplier.getSupId()); 
		}
			
	}
	
	@SuppressWarnings({ "unused" })
	@GetMapping(value = "/get-supplier-by-id/{supId}")
	public ResponseEntity<Supplier> getSupplierByID(@Valid @PathVariable int supId) 
	{

		Supplier supplier = null;
		Supplier supplier2 = supplierService.getSupplierById(supId);
		
		if(supplier2!=null)
		{
			return new ResponseEntity<Supplier>(supplier2, HttpStatus.OK);
		}
		else
		{
			throw new SupplierNotFoundException("Supplier Not Found for Id :"+supId);
		}
	}
	
	@PutMapping(value = "/update-supplier")
	public ResponseEntity<Boolean> updateSupplier(@RequestBody Supplier supplier) 
	{
		
		Supplier supplierId =supplierDao.getSupplierById(supplier.getSupId());
		boolean updated = true;
		if(supplierId!=null)
		{
			if(supplierService.updateSupplier(supplier))
			{
				return new ResponseEntity<Boolean>(updated, HttpStatus.CREATED);
			}
			else
			{
				throw new SupplierNameAlreadyExistException("Supplier Name Already Exist for Id :"+supplier.getSupId());
			}
		}
		else
		{
			throw new SupplierNotFoundException("Supplier Id ->"+supplier.getSupId()+" Not Exist for Update the Supplier.");
		}
		
	}
	
	
	@DeleteMapping(value = "/delete-supplier-by-id/{supId}")
	public ResponseEntity<String> deleteSupplierById(@Valid @PathVariable int supId) {

		Supplier supplier = null;
		supplier = supplierService.deleteSupplierById(supId);
		
		if(supplier!=null)
		{
			return new ResponseEntity<String>("Supplier is Deleted Which has Id :"+supId, HttpStatus.GONE);
		}
		else
		{
			throw new SupplierNotFoundException("Supplier Not Found for Id :"+supId);
		}
	}
	
}
