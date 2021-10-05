package desafio.devoptopus.desafio3.strategy;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.util.Util;

public class OddDiscount extends DiscountCheck {


    private double discount;
    public OddDiscount(double discount){
        this.discount = discount;
    }

    @Override
    public void applyDiscount(Product product) {
        boolean isOdd = Util.isOdd(product.getId());
        if(isOdd){
            product.setDiscount(product.getPrice()*(1-discount));
        }else{
            this.nextDiscount(product);
        }
    }
}
