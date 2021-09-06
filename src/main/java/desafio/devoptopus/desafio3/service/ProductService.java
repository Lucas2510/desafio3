package desafio.devoptopus.desafio3.service;

import desafio.devoptopus.desafio3.document.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    List<Product> findProducts(String search);

}
