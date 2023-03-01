package hibernate_many_to_many_bi_project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hibernate_many_to_many_bi_project.dto.Customer;
import hibernate_many_to_many_bi_project.dto.Product;
import hibernate_many_to_many_bi_project.service.CustomerService;
import hibernate_many_to_many_bi_project.service.ProductService;

public class ProductController {

	public static void main(String[] args) 
	{
		
			Scanner scanner=new Scanner(System.in);
			ProductService productService=new ProductService();
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
						productService.InsertCustomerProduct(customers, products);
					}
				}
			}
		}

	}


