package desafio.devoptopus.desafio3.controller;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController

@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Products", notes="This endpoint receives a parameter to search the database for " +
            "products that match the entered data, to return a list of products",nickname = "products")
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findProducts(@RequestParam("search") String search) {
        return new ResponseEntity<>(productService.findProducts(search), HttpStatus.OK);
    }

}
