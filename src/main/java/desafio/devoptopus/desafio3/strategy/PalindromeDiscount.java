package desafio.devoptopus.desafio3.strategy;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.util.Util;


public class PalindromeDiscount extends DiscountCheck {
    private boolean isPalindrome;
    private double discount;
    public PalindromeDiscount(String search,double discount){
        isPalindrome = Util.isPalindrome(search);
        this.discount = discount;
    }


    @Override
    public void applyDiscount(Product product) {
        if(isPalindrome){
            product.setDiscount(product.getPrice()*(1-discount));
        }else{
            this.nextDiscount(product);
        }
    }

}

