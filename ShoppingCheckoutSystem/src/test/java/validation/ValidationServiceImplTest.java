package validation;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import model.Cart;
import model.ErrorMessagesEnum;
import model.ValidationResponse;
import model.ValidationStatusEnum;

import org.junit.Before;
import org.junit.Test;

import validation.ValidationService;
import validation.ValidationServiceImpl;

public class ValidationServiceImplTest {
	
	
	ValidationService validationService = new ValidationServiceImpl();

	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test
	public void validateNullObject() {
		
		Set<String> productIds = new HashSet<String>();
		productIds.add("1");
		productIds.add("2");
		ValidationResponse validationResponse = validationService.validate(null);
	
		assertNotNull("validation Response is not null", validationResponse);

		assertEquals(validationResponse.getValidationStatus(), ValidationStatusEnum.FAIL.getValidationStatusDescription());
		assertEquals(validationResponse.getValidationErrors().get(ErrorMessagesEnum.EMPTY_OBJECT.getErrorDescription()).get(0), "Object is Empty!");
		
	}
	
	@Test
	public void validateEmptyObject() {
		
		Cart cart = new Cart();
		ValidationResponse validationResponse = validationService.validate(cart);
	
		assertNotNull("validation Response is not null", validationResponse);

		assertEquals(validationResponse.getValidationStatus(), ValidationStatusEnum.FAIL.getValidationStatusDescription());
		assertEquals(validationResponse.getValidationErrors().get(ErrorMessagesEnum.EMPTY_CART.getErrorDescription()).get(0), "Cart is Empty!");
		
	}
	
	@Test
	public void validatePopulatedCart() {
		
		Cart cart = new Cart();
		cart.setCartId(5);
		HashMap<String,Integer> purchasedProducts = new HashMap<String, Integer>();
		purchasedProducts.put("1", 3);
		purchasedProducts.put("2", 2);
		cart.setPurchasedProducts(purchasedProducts);
		ValidationResponse validationResponse = validationService.validate(cart);
	
		assertNotNull("validation Response is not null", validationResponse);

		assertEquals(validationResponse.getValidationStatus(), ValidationStatusEnum.SUCCESS.getValidationStatusDescription());
		
	}
	
	
}
