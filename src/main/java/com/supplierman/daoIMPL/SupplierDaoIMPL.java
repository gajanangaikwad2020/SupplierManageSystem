package com.supplierman.daoIMPL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.supplierman.dao.SupplierDao;
import com.supplierman.entity.Supplier;

@Repository
public class SupplierDaoIMPL implements SupplierDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveSupplier(Supplier supplier) 
	{ 
		boolean isAdded = false;
		try 
		{
			Session session = sessionFactory.openSession();
			Supplier dbSupplier = session.get(Supplier.class, supplier.getSupId());
			if (dbSupplier==null) 
			{
				Transaction transaction = session.beginTransaction();
				session.saveOrUpdate(supplier);
				transaction.commit();
				isAdded = true;
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public Supplier getSupplierById(int supId) 
	{
		Supplier supplier=new Supplier();
		try 
		{
			Session session = sessionFactory.openSession();
			supplier = session.get(Supplier.class, supId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return supplier;
	}

	@Override
	public boolean updateSupplier(Supplier supplier) 
	{
		boolean updated = false;
		try {
			Session session = sessionFactory.openSession();
			Supplier supplier2 = session.get(Supplier.class, supplier.getSupId());
			if(supplier2!=null) 
			{
				Session session2 = sessionFactory.openSession();
				Transaction transaction = session2.beginTransaction();
				session2.update(supplier);
				transaction.commit();
				updated=true;
			}
			else
				System.out.println("Suppplier id:"+supplier.getSupId()+" is not exist");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updated;
	}

	@Override
	public Supplier deleteSupplierById(int supId) 
	{
		Supplier supplier=null;
		try 
		{
			Session session = sessionFactory.openSession();
			supplier = session.get(Supplier.class, supId);
			Transaction transaction = session.beginTransaction();
			session.delete(supplier);
			transaction.commit();
			System.out.println("Supplier which has "+supId+ " Id is Deleted.");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return supplier;
		
	}



}
