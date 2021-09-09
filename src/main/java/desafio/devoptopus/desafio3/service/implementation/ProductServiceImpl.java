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
        if (result) {
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
                    product.forEach(p -> p.setDiscount(Util.calDiscount(p.getPrice())));
                }
                listProduct.addAll(product);
            }
        }
        if (listProduct.isEmpty()) {
            throw new NotFoundException("not found products");
        }
        return listProduct;
    }

    private Long tryParseLong(String str) {
        Long longValue = null;
        try {
            longValue = Long.parseLong(str);
            System.out.println("busqueda por id, voy a evolucionar a un log");
        } catch (Exception e) {
            System.out.println("busqueda por string, voy a evolucionar a un log");
        }
        return longValue;
    }
}