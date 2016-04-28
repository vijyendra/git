package price;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


import org.junit.Before;
import org.junit.Test;

public class PriceServiceImplTest {
	
	
	PriceService priceService = new PriceServiceImpl();

	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test
	public void getPricesTest() {
		
		Set<String> productIds = new HashSet<String>();
		productIds.add("1");
		productIds.add("2");
		Map<String, Double> productPrices = priceService.getPrices(productIds);
	
		assertNotNull("Product Prices", productPrices);
		assertEquals(productPrices.get("1"), 0.60,0);
		assertEquals(productPrices.get("2"), 0.25,0);
		
	}
	
}
