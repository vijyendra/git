package price;

import java.util.HashMap;
import java.util.Set;

public class PriceServiceImpl implements PriceService{

	
    public double getPrice(String productId) {
    	
    	//Use dao to either get productPrice from Cache or db
    	// For simplicity Here we will simply check on productId
    	if(productId.equalsIgnoreCase("1")){
    		return 0.60; // Apples
    	}else if(productId.equalsIgnoreCase("2")){
    		return 0.25;
    	}	
    	else return 0;
    }
    
    public HashMap<String, Double> getPrices(Set<String> productIds) {
    	
    	//Use dao to either get productPrice from Cache or db
    	// For simplicity Here we will simply check on productId
    	HashMap<String, Double> pricesMap  = new HashMap<String, Double>();
    	for(String productId : productIds){
    		
    		if(productId.equalsIgnoreCase("1")){
    			pricesMap.put(productId, 0.60);
        	}else if(productId.equalsIgnoreCase("2")){
        		pricesMap.put(productId, 0.25);
        	}	  		
    	}  	
    	return pricesMap;
    }

	public double setPrice(String productId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
