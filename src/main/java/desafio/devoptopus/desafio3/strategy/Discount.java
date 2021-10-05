package desafio.devoptopus.desafio3.strategy;

import desafio.devoptopus.desafio3.document.Product;

public interface Discount {
    void applyDiscount (Product product);
    Discount setNextDiscount(Discount discount);
}
