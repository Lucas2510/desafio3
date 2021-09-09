package desafio.devoptopus.desafio3.service.implementation;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.exception.NotFoundException;
import desafio.devoptopus.desafio3.repository.ProductRepository;
import desafio.devoptopus.desafio3.service.ProductService;
import desafio.devoptopus.desafio3.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findProducts(String search) {
        List<Product> listProduct = new ArrayList<>();
        Pattern pat = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher mat = pat.matcher(search);
        boolean result = mat.matches();
        Long id = tryParseLong(search);
        boolean isPalindrome = Util.isPalindrome(search);
        if (result = true) {
            if (id != null) {
                Product product = productRepository.findById(id);

                if (isPalindrome) {
                    product.setDiscount(Util.calDiscount(product.getPrice()));
                }
                if (product != null) {
                    listProduct.add(product);
                }

            } else {
                List<Product> product = productRepository.findByRegex(search);
                if (isPalindrome) {
                    product.stream().forEach(p -> p.setDiscount(Util.calDiscount(p.getPrice())));
                }
                listProduct.addAll(product);
            }
        }
        if (listProduct.size() == 0) {
            throw new NotFoundException("not found products");
        }
        return listProduct;
    }

    private Long tryParseLong(String str) {
        Long longValue = null;
        try {
            longValue = Long.parseLong(str);
        } catch (Exception e) {

        }
        return longValue;
    }
}