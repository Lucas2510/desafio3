package desafio.devoptopus.desafio3.repository;

import desafio.devoptopus.desafio3.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, Long> {
    //List<Product> findAllProducts(String Product);
}
