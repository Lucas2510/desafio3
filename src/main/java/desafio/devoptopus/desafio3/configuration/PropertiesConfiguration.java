package desafio.devoptopus.desafio3.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "discount")
public class PropertiesConfiguration {

    private double palindromeDiscount;
    private double primeDiscount;
    private double oddDiscount;

    public double getPalindromeDiscount() {
        return palindromeDiscount;
    }

    public void setPalindromeDiscount(double palindromeDiscount) {
        this.palindromeDiscount = palindromeDiscount;
    }

    public double getPrimeDiscount() {
        return primeDiscount;
    }

    public void setPrimeDiscount(double primeDiscount) {
        this.primeDiscount = primeDiscount;
    }

    public double getOddDiscount() {
        return oddDiscount;
    }

    public void setOddDiscount(double oddDiscount) {
        this.oddDiscount = oddDiscount;
    }
}