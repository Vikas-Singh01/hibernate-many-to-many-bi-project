package hibernate_many_to_many_bi_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_many_to_many_bi_project.dto.Customer;
import hibernate_many_to_many_bi_project.dto.Product;

public class CustomerDao 
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
	@SuppressWarnings("unused")
	public void updateCustomerProduct(int customerId,Customer customer,List<Product> products)
	{
		Customer customer2 =entityManager.find(Customer.class, customerId);
		List<Product> products2=customer.getProducts();
		entityTransaction.begin();
		if(customer!=null)
		{
		for (Product product : products) 
		{
			if(products2!=null)
			{
			for (Product product2 : products2) 
			{
				product2.setProductname(product.getProductname());
				entityManager.merge(product2);
			}
			}
		}
		customer2.setCustomerName(customer.getCustomerName());
		entityManager.merge(customer2);
		entityTransaction.commit();
		}
		else
		{
			System.out.println("Enter correct customer ID");
		}
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
	public List<Customer> displayCustomerProduct()
	{
		String select="select c from Customer c";
		Query query=entityManager.createQuery(select);
		return query.getResultList();
	}
}
