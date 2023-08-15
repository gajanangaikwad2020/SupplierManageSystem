package com.supplierman.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Supplier 
{
	@Id
	private int supId;
	
	@NotNull(message = "Supplier name is Required")
	private String supName;
	@NotNull(message = "Supplier Address is Required")
	private String supAddress;
	@Min(5)
	private String supContactNo;
	
	public Supplier() 
	{
		super();
	}

	public Supplier(int supId, @NotNull(message = "Supplier name is Required") String supName,
			@NotNull(message = "Supplier Address is Required") String supAddress, @Min(5) String supContactNo) {
		super();
		this.supId = supId;
		this.supName = supName;
		this.supAddress = supAddress;
		this.supContactNo = supContactNo;
	}

	public int getSupId() {
		return supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getSupAddress() {
		return supAddress;
	}

	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}

	public String getSupContactNo() {
		return supContactNo;
	}

	public void setSupContactNo(String supContactNo) {
		this.supContactNo = supContactNo;
	}

	@Override
	public String toString() {
		return "Supplier [supId=" + supId + ", supName=" + supName + ", supAddress=" + supAddress + ", supContactNo="
				+ supContactNo + "]";
	}

	
	

}

