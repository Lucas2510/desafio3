package desafio.devoptopus.desafio3;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Desafio3ApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void shouldFindById() {

		Long id = 5L;
		Product product = productRepository.findById(id);
		Assertions.assertEquals(5, product.getId());

	}

	@Test
	void shouldFindAllProducts(){

		List<Product> products =  productRepository.findAll();
		Assertions.assertNotNull(products);
		Assertions.assertNotEquals(0, products.size());
		Assertions.assertEquals(3000, products.size());


	}

}
