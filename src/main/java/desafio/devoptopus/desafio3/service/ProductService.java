package desafio.devoptopus.desafio3.service;

import org.springframework.http.ResponseEntity;

public interface ProductService {

    ResponseEntity<Object> findProducts(String search);

}
