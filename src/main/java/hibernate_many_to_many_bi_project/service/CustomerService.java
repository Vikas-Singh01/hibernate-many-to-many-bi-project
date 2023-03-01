package hibernate_many_to_many_bi_project.service;

import java.util.List;

import hibernate_many_to_many_bi_project.dao.CustomerDao;
import hibernate_many_to_many_bi_project.dto.Customer;
import hibernate_many_to_many_bi_project.dto.Product;

public class CustomerService 
{
	CustomerDao customerDao=new CustomerDao();

	public void InsertCustomerProduct(List<Customer> customers,List<Product> products)
	{
		customerDao.InsertCustomerProduct(customers, products);
	}
	public void updateCustomerProduct(int customerId,Customer customer,List<Product> products)
	{
		customerDao.updateCustomerProduct(customerId, customer, products);
	}
	public void deleteCustomerProduct(int customerId)
	{
		customerDao.deleteCustomerProduct(customerId);
	}
	
		public List<Customer> displayCustomerProduct()
	{
			return customerDao.displayCustomerProduct();
	}
}
