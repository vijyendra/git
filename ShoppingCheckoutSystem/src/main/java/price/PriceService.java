/**
 * 
 */
package price;

import java.util.Map;
import java.util.Set;


/**
 * @author vijay
 *
 */
public interface PriceService {

	public double getPrice (String productId);
	
	public Map<String, Double> getPrices (Set<String> productIds);
	
	public double setPrice (String productId);
	
}
