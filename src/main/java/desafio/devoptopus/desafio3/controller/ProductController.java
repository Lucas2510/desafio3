package desafio.devoptopus.desafio3.controller;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.repository.ProductRepository;
import desafio.devoptopus.desafio3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> findProducts(@RequestParam("search") String search) {
        return new ResponseEntity<>( productService.findProducts(search), HttpStatus.OK);
    }


    @Autowired
    ProductRepository productRepository;

    @GetMapping("/test")
    public Product asd(){
        return productRepository.findById(1);
    }

}
