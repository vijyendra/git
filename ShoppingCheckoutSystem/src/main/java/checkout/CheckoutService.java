/**
 * 
 */
package checkout;

import model.Cart;


/**
 * @author vijay
 *
 */
public interface CheckoutService {

	public Cart checkout (Cart cart);
	
	public Cart purgeCart(Cart cart);
	
}
