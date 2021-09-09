package desafio.devoptopus.desafio3.repository;

import desafio.devoptopus.desafio3.document.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableMongoRepositories
public interface ProductRepository extends MongoRepository<Product, String> {

    Product findById(long id);

    @Query("{$or :[{ 'description' : { $regex: ?0 } }, { 'brand' : { $regex: ?0 } }]}")
    List<Product> findByRegex(String regexp);
}
