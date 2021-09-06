package desafio.devoptopus.desafio3.service.implementation;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.repository.ProductRepository;
import desafio.devoptopus.desafio3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findProducts(String search) {
        try {
            Long id = Long.parseLong(search);
            List<Product> listProduct = new ArrayList<Product>();
            Product product = productRepository.findById(id);
            listProduct.add(product);
            //return new ResponseEntity<Product>(listProduct, HttpStatus.OK);

            return listProduct;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (search.length() >= 3) {
            return productRepository.findByRegex(search);
        }
        List<Product> listProduct = new ArrayList<Product>();
        return listProduct;

    }
}
