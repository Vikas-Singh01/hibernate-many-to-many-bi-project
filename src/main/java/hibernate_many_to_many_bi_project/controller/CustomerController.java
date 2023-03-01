package hibernate_many_to_many_bi_project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hibernate_many_to_many_bi_project.dto.Customer;
import hibernate_many_to_many_bi_project.dto.Product;
import hibernate_many_to_many_bi_project.service.CustomerService;



public class CustomerController {

	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		CustomerService customerService=new CustomerService();
		while(true)
		{
			System.out.println("1.Insert/n2.Update/n3.Delete/n4.Display/n5.Exit");
			System.out.println("Choose your choice");
			switch(scanner.nextInt())
			{
			case 1:
				{
					List<Product> products=new ArrayList();
					System.out.println("Enter no .of customers");
					int custSize=scanner.nextInt();
					List<Customer> customers=new ArrayList();
					for (int i=1;i<=custSize;i++) 
					{
						Customer customer=new Customer();
						System.out.println("Enter Customer id");
						customer.setCustomerId(scanner.nextInt());
						System.out.println("Enter Customer name");
						customer.setCustomerName(scanner.next());
						System.out.println("Enter Customer mob");
						customer.setCustomerMob(scanner.nextInt());
						customer.setProducts(products);
						customers.add(customer);
					}
					System.out.println("Enter no .of products");
					int productSize=scanner.nextInt();
					
					for (int i=1;i<=productSize;i++) 
					{
						Product product=new Product();
						System.out.println("Enter product id");
						product.setProductid(scanner.nextInt());
						System.out.println("Enter product name");
						product.setProductname(scanner.next());
						System.out.println("Enter product price");
						product.setProductPrice(scanner.next());
						product.setCustomers(customers);
						products.add(product);
					}
					customerService.InsertCustomerProduct(customers, products);
				}break;
			case 2:
				{
					
					System.out.println("Enter customer id to update");
					int customerId=scanner.nextInt();
					System.out.println("Enter mob no. to update");
					Customer customer =new Customer();
					customer.setCustomerMob(scanner.nextInt());
					System.out.println("Enter no. of products to update");
					int size=scanner.nextInt();
					List<Product> products=new ArrayList();
					for(int i=1;i<=size;i++)
					{
					Product product=new Product();
					System.out.println("Enter name of product to update");
					product.setProductname(scanner.next());
					products.add(product);
					}
					customerService.updateCustomerProduct(customerId, customer, products);
				}break;
			case 3:
					{
						System.out.println("Enter customerId to delete");
						int customerId=scanner.nextInt();
						customerService.deleteCustomerProduct(customerId);
					}break;
			case 4:
					{
						List<Customer> customers=customerService.displayCustomerProduct();
						for (Customer customer : customers) 
						{
							System.out.println(customer);
							List<Product> products=customer.getProducts();
							for (Product product : products) 
							{
								System.out.println(product);
							}
						}
					}break;
			}
		}
	}

}
