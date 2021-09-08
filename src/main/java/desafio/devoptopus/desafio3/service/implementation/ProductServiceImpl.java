package desafio.devoptopus.desafio3.service.implementation;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.repository.ProductRepository;
import desafio.devoptopus.desafio3.service.ProductService;
import desafio.devoptopus.desafio3.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findProducts(String search) {
        List<Product> listProduct = new ArrayList<>();
        try {
            Long id = Long.parseLong(search);
            Product product = productRepository.findById(id);
            if (search.length() == 1) {
                if (Util.isPalindrome(0 + search)) {
                    product.setDiscount(product.getPrice() * 0.5);
                    listProduct.add(product);
                    return listProduct;
                }
            } else if (search.length() > 1) {
                if (Util.isPalindrome(search)) {
                    product.setDiscount(product.getPrice() * 0.5);
                    listProduct.add(product);
                    return listProduct;
                }
            }
            listProduct.add(product);
            return listProduct;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            List<Product> product = productRepository.findByRegex(search);
            if (search.length() < 3) {
                return listProduct;
            }
            if (Util.isPalindrome(search)) {
                product.stream().forEach(p -> p.setDiscount(p.getPrice() * 0.5));
                listProduct.addAll(product);
                return product;
            }
            listProduct.addAll(product);
            return listProduct;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listProduct;
    }
}