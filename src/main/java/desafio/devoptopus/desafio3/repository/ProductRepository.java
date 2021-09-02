package desafio.devoptopus.desafio3.repository;

import desafio.devoptopus.desafio3.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ProductRepository extends MongoRepository<Product, Serializable> {
    //List<Product> findAllProducts(String Product);
}
