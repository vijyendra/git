package model;

import java.util.List;
import java.util.Map;

public class Cart {

    private Map<String,Integer>  purchasedProducts;
    
    private int cartId;
    
    private double cartTotal;
    
    private List<String> cartErrors;

	public Map<String, Integer> getPurchasedProducts() {
		return purchasedProducts;
	}

	public void setPurchasedProducts(Map<String, Integer> purchasedProducts) {
		this.purchasedProducts = purchasedProducts;
	}

	public double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<String> getCartErrors() {
		return cartErrors;
	}

	public void setCartErrors(List<String> list) {
		this.cartErrors = list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId != other.cartId)
			return false;
		return true;
	}
	
}
