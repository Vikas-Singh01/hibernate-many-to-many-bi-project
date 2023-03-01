package hibernate_many_to_many_bi_project.service;

import java.util.List;

import hibernate_many_to_many_bi_project.dao.ProductDao;
import hibernate_many_to_many_bi_project.dto.Customer;
import hibernate_many_to_many_bi_project.dto.Product;

public class ProductService 
{
		ProductDao productDao=new  ProductDao();
	public void InsertCustomerProduct(List<Customer> customers,List<Product> products)
	{
		productDao.InsertCustomerProduct(customers, products);
	}
}
