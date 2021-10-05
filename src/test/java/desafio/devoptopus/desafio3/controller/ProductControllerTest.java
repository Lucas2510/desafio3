package desafio.devoptopus.desafio3.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import desafio.devoptopus.desafio3.util.Util;

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
        product.setBrand("asddsa");
        product.setDescription("dsa");
        product.setImage("image");
        product.setPrice(1234);
        product.setDiscount(0);

        productList.add(product);

        when(productService.findProducts("asddsa")).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/products?search=asddsa").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productList))).andExpect(status().isOk());

        verify(productService).findProducts("asddsa");
        Assertions.assertTrue(Util.isPalindrome("asddsa"));
    }
    @Test
    void shouldFindProductsOdd() throws Exception {

        Product product = new Product();
        List<Product> productList = new ArrayList<>();

        product.set_id("624as34a4");
        product.setId(1);
        product.setBrand("asddsa");
        product.setDescription("dsa");
        product.setImage("image");
        product.setPrice(1234);
        product.setDiscount(0);

        productList.add(product);

        when(productService.findProducts("1")).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/products?search=1").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productList))).andExpect(status().isOk());

        verify(productService).findProducts("1");
        Assertions.assertTrue(Util.isOdd(1));
    }
    @Test
    void shouldFindProductsPalindromeNumber() throws Exception {

        Product product = new Product();
        List<Product> productList = new ArrayList<>();

        product.set_id("624as34a4");
        product.setId(121);
        product.setBrand("asddsa");
        product.setDescription("dsa");
        product.setImage("image");
        product.setPrice(1234);
        product.setDiscount(0);

        productList.add(product);

        when(productService.findProducts("121")).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/products?search=121").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productList))).andExpect(status().isOk());

        verify(productService).findProducts("121");
        Assertions.assertTrue(Util.isPalindromeNumber(121));
    }
    @Test
    void shouldFindProductsPrime() throws Exception {

        Product product = new Product();
        List<Product> productList = new ArrayList<>();

        product.set_id("624as34a4");
        product.setId(13);
        product.setBrand("asddsa");
        product.setDescription("dsa");
        product.setImage("image");
        product.setPrice(1234);
        product.setDiscount(0);

        productList.add(product);

        when(productService.findProducts("13")).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/products?search=13").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productList))).andExpect(status().isOk());

        verify(productService).findProducts("13");
        Assertions.assertTrue(Util.isPrime(13));
    }

    @Test
    void shouldFindProductsCommon() throws Exception {

        Product product = new Product();
        List<Product> productList = new ArrayList<>();

        product.set_id("624as34a4");
        product.setId(18);
        product.setBrand("asddsa");
        product.setDescription("dsa");
        product.setImage("image");
        product.setPrice(1234);
        product.setDiscount(0);

        productList.add(product);

        when(productService.findProducts("18")).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/products?search=18").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productList))).andExpect(status().isOk());

        verify(productService).findProducts("18");
        Assertions.assertFalse(Util.isPrime(18));
        Assertions.assertFalse(Util.isOdd(18));
        Assertions.assertFalse(Util.isPalindromeNumber(18));
    }
    @Test
    void shouldFindProducts2Char() throws Exception {

        Product product = new Product();
        List<Product> productList = new ArrayList<>();

        product.set_id("624as34a4");
        product.setId(18);
        product.setBrand("asddsa");
        product.setDescription("as");
        product.setImage("image");
        product.setPrice(1234);
        product.setDiscount(0);

        productList.add(product);

        when(productService.findProducts("as")).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/products?search=as").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productList))).andExpect(status().isOk());

        verify(productService).findProducts("as");
        Assertions.assertFalse(Util.isPalindrome("as"));
    }
    @Test
    void shouldFindProducts0ID() throws Exception {

        Product product = new Product();
        List<Product> productList = new ArrayList<>();

        product.set_id("624as34a4");
        product.setId(0);
        product.setBrand("asddsa");
        product.setDescription("dsa");
        product.setImage("image");
        product.setPrice(1234);
        product.setDiscount(0);

        productList.add(product);

        when(productService.findProducts("0")).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/products?search=0").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productList))).andExpect(status().isOk());

        verify(productService).findProducts("0");
        Assertions.assertFalse(Util.isPrime(0));
        Assertions.assertFalse(Util.isOdd(0));
        Assertions.assertFalse(Util.isPalindromeNumber(0));
    }
    }