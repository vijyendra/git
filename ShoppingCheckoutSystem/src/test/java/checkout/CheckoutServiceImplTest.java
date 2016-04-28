package checkout;

import static org.junit.Assert.*;

import java.util.HashMap;

import model.Cart;
import model.ErrorMessagesEnum;

import org.junit.Before;
import org.junit.Test;

public class CheckoutServiceImplTest {
	
	
	CheckoutService checkoutService = new CheckoutServiceImpl();

	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test
	public void checkoutTestCleanCart() {
		
		Cart cart = new Cart();
		cart.setCartId(4);
		HashMap<String,Integer> purchasedProducts = new HashMap<String, Integer>();
		purchasedProducts.put("1", 3);
		purchasedProducts.put("2", 2);
		cart.setPurchasedProducts(purchasedProducts);
		
		Cart cart1  = checkoutService.checkout(cart);
				
		assertNotNull("Cart Total is not null",cart1.getCartTotal());
		assertNotEquals(cart1.getCartTotal(), 0);
		assertEquals(cart1.getCartTotal(), 2.30, 0);
		
		assertNull(cart1.getCartErrors());
		
	}
	
	@Test
	public void checkoutTestEmptyCart() {
		
		Cart cart = new Cart();
		cart.setCartId(3);
		HashMap<String,Integer> purchasedProducts = new HashMap<String, Integer>();
		cart.setPurchasedProducts(purchasedProducts);
		
		Cart cart1  = checkoutService.checkout(cart);
		
		assertTrue( ! cart1.getCartErrors().isEmpty() );
		assertEquals( cart1.getCartErrors().get(0), "Cart is Empty!");		
		assertNotNull("Cart Total is not null",cart1.getCartTotal());
		assertNotEquals(cart1.getCartTotal(), 0);
		assertEquals(cart1.getCartTotal(), 0, 0);
		
	}
	
	@Test
	public void checkoutTestNullCart() {
		
		Cart cart = new Cart();
		HashMap<String,Integer> purchasedProducts = new HashMap<String, Integer>();
		cart.setPurchasedProducts(purchasedProducts);
		
		Cart cart1  = checkoutService.checkout(null);
		
		assertTrue( ! cart1.getCartErrors().isEmpty() );
		assertEquals( cart1.getCartErrors().get(0), ErrorMessagesEnum.EMPTY_CART.getErrorDescription());
		assertNotNull("Cart Total is not null",cart1.getCartTotal());
		assertNotEquals(cart1.getCartTotal(), 0);
		assertEquals(cart1.getCartTotal(), 0, 0);
		
	}
	
}
