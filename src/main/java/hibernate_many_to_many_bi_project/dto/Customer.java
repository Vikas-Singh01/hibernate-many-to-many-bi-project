package hibernate_many_to_many_bi_project.dto;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Customer 
{
	@Id
	private int customerId;
	@Column(nullable = false,unique = true,name="cutomerName")
//	By nullable => we can make the column with not null.
//	By unique => we can avoid duplicates in this column
	private String customerName;
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerMob=" + customerMob
				+ "]";
	}
	private int customerMob;
	@ManyToMany(mappedBy = "customers")
	private List<Product> products;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerMob() {
		return customerMob;
	}
	public void setCustomerMob(int customerMob) {
		this.customerMob = customerMob;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
