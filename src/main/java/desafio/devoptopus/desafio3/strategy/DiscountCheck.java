package desafio.devoptopus.desafio3.strategy;

import desafio.devoptopus.desafio3.document.Product;

public abstract class DiscountCheck implements Discount{
    private Discount nextDiscount ;
    public abstract void applyDiscount(Product product);

    public Discount setNextDiscount(Discount discountCheck){
        this.nextDiscount = discountCheck;
        return discountCheck;
    }
    protected void nextDiscount(Product product){
        if(nextDiscount != null) {
            nextDiscount.applyDiscount(product);
        }
    }
}
