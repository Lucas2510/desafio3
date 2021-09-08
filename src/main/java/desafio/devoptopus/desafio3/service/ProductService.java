package desafio.devoptopus.desafio3.service;

import desafio.devoptopus.desafio3.document.Product;

import java.util.List;

public interface ProductService {

    List<Product> findProducts(String search);

}
