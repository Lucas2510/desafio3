package desafio.devoptopus.desafio3.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    @MockBean
    ProductService productService;

    @Autowired
    MockMvc mockMvc;


    ObjectMapper objectMapper;

    @BeforeEach
    void setup(){
        objectMapper = new ObjectMapper();
    }


    @Test
    void findProducts() throws Exception{
        Product product = new Product();
        List<Product> productList = new ArrayList<>();

        product.set_id("624as34a4");
        product.setId(1L);
        product.setBrand("asddsa");
        product.setDescription("dsa");
        product.setImage("image");
        product.setPrice(1234);
        product.setDiscount(0);


    }
}