package hibernate_many_to_many_bi_project.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Product 
{
	@Id
	private int productid;
	private String productname;
	private String productPrice;
	@ManyToMany
	@JoinTable(name="product_customer",	
	joinColumns=@JoinColumn(name="product_Id"),	
	inverseJoinColumns = @JoinColumn(name="customer_Id"))
	private List<Customer> customers;
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", productPrice=" + productPrice
				+ "]";
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
