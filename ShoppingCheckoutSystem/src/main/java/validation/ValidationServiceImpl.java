package validation;

import model.Cart;
import model.ErrorMessagesEnum;
import model.ValidationResponse;
import model.ValidationStatusEnum;

public class ValidationServiceImpl implements ValidationService{
	
	ValidationResponse resp;

    public ValidationResponse validate( Object obj) {
    	
    	if(obj == null){
    		resp = new ValidationResponse();
    		resp.setValidationStatus(ValidationStatusEnum.FAIL.getValidationStatusDescription()); 
    		resp.addValidationErrors(ErrorMessagesEnum.EMPTY_OBJECT.getErrorDescription(), "Object is Empty!");
    		return resp;
    	}
    	
    	if (obj instanceof Cart)
    		resp = this.cartHasValidProducts((Cart)obj);
    	
    	return resp;  
    }
	
    private ValidationResponse cartHasValidProducts(Cart cart) {
		ValidationResponse resp = new ValidationResponse();
		
		try{
			
			if(cart == null || cart.getCartId() == 0 )
			{	
				resp.addValidationErrors(ErrorMessagesEnum.EMPTY_CART.getErrorDescription(), "Cart is Empty!");
				resp.setValidationStatus(ValidationStatusEnum.FAIL.getValidationStatusDescription()); 
				return resp;
			}else if ( cart.getCartId() != 0 && cart.getPurchasedProducts().isEmpty()){
				resp.addValidationErrors(String.valueOf(cart.getCartId()), "Cart is Empty!");
				resp.setValidationStatus(ValidationStatusEnum.FAIL.getValidationStatusDescription()); 
				return resp;
			}
	    	for(String productId : cart.getPurchasedProducts().keySet()){		
	    		//check if cart products are valid 
	    		//assuming productIds exists and are valid
	    		//resp.addValidationErrors(String.valueOf(cart.getCartId()) , "Product :"+productId +" not found.");
	    		 
	    	}
	    	resp.setValidationStatus(ValidationStatusEnum.SUCCESS.getValidationStatusDescription());  
	        
	    }catch (NumberFormatException | NullPointerException ex ){
	    	
	    	StringBuffer sb = new StringBuffer();
	    	for(int i = 0; i < ex.getStackTrace().length -1; i++){
	    		sb.append(ex.getStackTrace()[0].toString());
	    		sb.append("\n");
	    	}	    	
	    	resp.addValidationErrors(String.valueOf(cart.getCartId()), ex.getMessage()+" ::::::: "+sb.toString());
	    }
		
		return resp;	    
	}	
}
