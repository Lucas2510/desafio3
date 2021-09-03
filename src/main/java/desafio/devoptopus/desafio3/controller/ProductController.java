package desafio.devoptopus.desafio3.controller;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public Product findById(@PathVariable long id){
        return productService.findById(id);
    }

    @GetMapping("/product")
    public List<Product> findByDescBrand(@RequestParam("search") String search){
        return productService.findByRegex(search);
    }

}
