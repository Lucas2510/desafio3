package desafio.devoptopus.desafio3.strategy;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.util.Util;

public class PrimeDiscount extends DiscountCheck{
    private double discount;

    public PrimeDiscount(double discount){
        this.discount =discount;
    }

    @Override
    public void applyDiscount(Product product) {
        boolean isPrime = Util.isPrime(product.getId());
        if(isPrime){
            product.setDiscount(product.getPrice()*(1-discount));
        }else{
            this.nextDiscount(product);
        }
    }
}
