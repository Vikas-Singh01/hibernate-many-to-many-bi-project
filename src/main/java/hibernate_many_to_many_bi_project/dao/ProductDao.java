package hibernate_many_to_many_bi_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_many_to_many_bi_project.dto.Customer;
import hibernate_many_to_many_bi_project.dto.Product;

public class ProductDao 
{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void InsertCustomerProduct(List<Customer> customers,List<Product> products)
	{
		entityTransaction.begin();
		for (Product product : products) 
		{
			entityManager.persist(product);
		}
		for (Customer customer : customers) 
		{
			entityManager.persist(customer);
		}
		entityTransaction.commit();
	}
	public void deleteCustomerProduct(int customerId)
	{
		Customer customer=entityManager.find(Customer.class, customerId);
		List<Product> products=customer.getProducts();
		entityTransaction.begin();
		entityManager.remove(customer);
		for (Product product : products) 
		{
			entityManager.remove(product);
		}
		entityTransaction.commit();	
	}
}
