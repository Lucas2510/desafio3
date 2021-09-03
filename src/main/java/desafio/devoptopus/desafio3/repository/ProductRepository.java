package desafio.devoptopus.desafio3.repository;

import desafio.devoptopus.desafio3.document.Product;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

   /* @Query("{'id':?0}")
    Product findByIdLike(Long idSearch);*/

    Product findById(long id);

    //@Query("{ 'description' : { $regex: ?0 } }")
    @Query("{$or :[{ 'description' : { $regex: ?0 } }, { 'brand' : { $regex: ?0 } }]}")
    List<Product> findByRegex(String regexp);
}
