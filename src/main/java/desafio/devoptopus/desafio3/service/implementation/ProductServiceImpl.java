package desafio.devoptopus.desafio3.service.implementation;

import desafio.devoptopus.desafio3.configuration.PropertiesConfiguration;
import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.exception.CharacterError;
import desafio.devoptopus.desafio3.exception.NotFoundException;
import desafio.devoptopus.desafio3.repository.ProductRepository;
import desafio.devoptopus.desafio3.service.ProductService;
import desafio.devoptopus.desafio3.strategy.Discount;
import desafio.devoptopus.desafio3.strategy.OddDiscount;
import desafio.devoptopus.desafio3.strategy.PalindromeDiscount;
import desafio.devoptopus.desafio3.strategy.PrimeDiscount;
import desafio.devoptopus.desafio3.util.Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ProductServiceImpl implements ProductService {
    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PropertiesConfiguration proConf;

    public List<Product> findProducts(String search) {
        List<Product> listProduct = new ArrayList<>();
        Pattern pat = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher mat = pat.matcher(search);
        boolean result = mat.matches();
        Long id = tryParseLong(search);
        Discount chainDiscount = chainDiscount(search);

        boolean isPalindrome = Util.isPalindrome(search);
        if (!result) {
            log.error("Solo se pueden poner letras y numeros");

            throw new CharacterError("No special character can be used.");
        } else {
            log.info("Se ingresaron letras y numeros");
            if (id != null) {
                Product product = productRepository.findById(id);
                if (product != null) {
                    listProduct.add(product);
                }

            } else {
                List<Product> product = productRepository.findByRegex(search);
                if (isPalindrome) {
                    product.forEach(p -> p.setDiscount(p.getPrice() - p.getPrice() * proConf.getPalindromeDiscount()));
                }
                listProduct.addAll(product);
            }
        }
        if (listProduct.isEmpty()) {
            log.error("No se encontraron productos");
            throw new NotFoundException("not found products");
        }
        listProduct
                .stream()
                .forEach(product -> {
                    chainDiscount.applyDiscount(product);
                });

        return listProduct;
    }

    private Long tryParseLong(String str) {
        Long longValue = null;
        try {
            longValue = Long.parseLong(str);
            log.info("Se busco por ID");
        } catch (Exception e) {
            log.info("Se busco por Marca y Descripcion");
        }
        return longValue;
    }

    private Discount chainDiscount(String search) {
        Discount palindrome = new PalindromeDiscount(search, 0.5);


        Discount prime = new PrimeDiscount(0.15);
        palindrome.setNextDiscount(prime);

        Discount odd = new OddDiscount(0.1);
        prime.setNextDiscount(odd);

        return palindrome;
    }
}