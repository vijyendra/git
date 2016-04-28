package checkout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Cart;
import model.ValidationResponse;
import model.ValidationStatusEnum;

import price.PriceServiceImpl;
import validation.ValidationServiceImpl;

public class CheckoutServiceImpl implements CheckoutService{
	
	
	ValidationServiceImpl validationService = new ValidationServiceImpl();

	PriceServiceImpl priceService = new PriceServiceImpl();
	
    public Cart checkout( Cart cart) {
    	
    try{
    	ValidationResponse resp = validationService.validate(cart);
    	
    	
    	if (resp.getValidationStatus().equalsIgnoreCase(ValidationStatusEnum.FAIL.getValidationStatusDescription())){
    		
    		if(cart == null){
        		 cart = new Cart();
        	} 
    		
    		cart.setCartErrors(resp.getValidationErrorsById(cart.getCartId()));
    	}else {
    		cart = this.getCartTotal(cart);
    	}    	 	
        
    }catch (Exception ex ){
    	
    	List<String> errorMessages = new ArrayList<String>();
    	
    	StringBuffer sb = new StringBuffer();
    	for(int i = 0; i < ex.getStackTrace().length -1; i++){
    		sb.append(ex.getStackTrace()[0].toString());
    		sb.append("\n");
    	}
    	errorMessages.add(ex.getMessage()+" ::::::: "+sb.toString());
    	
    	cart.setCartErrors(errorMessages);
    }
    
	return cart;
 }

	private Cart getCartTotal(Cart cart) {
		
		HashMap<String, Double> productPrices = priceService.getPrices(cart.getPurchasedProducts().keySet());
		Map<String, Integer> purchasedProduct = cart.getPurchasedProducts();
		
		for (String productId : purchasedProduct.keySet()){
			Integer quantity = purchasedProduct.get(productId);
			Double unitPrice = productPrices.get(productId);
			Double cartTotal = cart.getCartTotal();
			cartTotal = cartTotal + getProdPriceForQuantity(quantity, unitPrice);
			cart.setCartTotal(cartTotal);
		}
		
		return cart;
		
	}

	public Double getProdPriceForQuantity(Integer quantity, Double unitPrice) {
		// TODO Auto-generated method stub
		 Double total = quantity * unitPrice;
		 total = new BigDecimal(total.toString()).setScale(2,RoundingMode.HALF_UP).doubleValue();     
		return total;
	}

	public Cart purgeCart(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setValidationService(ValidationServiceImpl validationService) {
		this.validationService = validationService;
	}

	public void setPriceService(PriceServiceImpl priceService) {
		this.priceService = priceService;
	}
    
    	
}
