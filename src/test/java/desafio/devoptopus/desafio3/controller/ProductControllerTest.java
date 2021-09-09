package desafio.devoptopus.desafio3.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

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
    void shouldFindProducts() throws Exception {

        Product product = new Product();
        List<Product> productList = new ArrayList<>();

        product.set_id("624as34a4");
        product.setId(1L);
        product.setBrand("asd");
        product.setDescription("dsa");
        product.setImage("image");
        product.setPrice(1234);
        product.setDiscount(0);

        productList.add(product);

        when(productService.findProducts("asd")).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/products?search=asd").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productList))).andExpect(status().isOk());

        verify(productService).findProducts("asd");
    }

}