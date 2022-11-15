
package com.sana.userOrder.model;


import javax.persistence.*;

@Entity
public class UserOrder {



    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int UserOrderId;

  /*  @OneToOne
    @JoinColumn(name = "ID")
    private User user;*/

    
    private String billingAddress;

    
    private String shippingAddress;
    
    
    private String pay_type;

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public int getUserOrderId() {
		return UserOrderId;
	}

	public void setUserOrderId(int userOrderId) {
		UserOrderId = userOrderId;
	}

	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

   
} // The End of Class;





