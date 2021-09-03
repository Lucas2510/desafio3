package desafio.devoptopus.desafio3.controller;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.repository.ProductRepository;
import desafio.devoptopus.desafio3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    /*@GetMapping("/product")
    public List<Product> findProducts(){
      return productRepository.findAll();
    }*/

    @GetMapping("/asd")
    public ResponseEntity<Object> findProducts(@RequestParam("buscar") String buscar){
        return productService.findProducts(buscar);
        //return productRepository.findByDescriptionLike(buscar);
    }
}
