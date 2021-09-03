package desafio.devoptopus.desafio3.service.implement;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.repository.ProductRepository;
import desafio.devoptopus.desafio3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplement implements ProductService {
    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<Object> findProducts(String search){
        try{
            Long id = Long.parseLong(search);
            return new ResponseEntity<>(productRepository.findById(id), HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return new ResponseEntity<>(productRepository.findByRegex(search), HttpStatus.OK);
    }
}
