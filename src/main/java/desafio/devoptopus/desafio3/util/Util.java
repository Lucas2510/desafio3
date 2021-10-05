package desafio.devoptopus.desafio3.util;

import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class Util {

    private Util(){

    }
    public static boolean isPalindrome(String originalString) {

        String tempString = originalString.replaceAll("\\s+", "").toLowerCase();

        if (tempString.length() < 3) {
            return false;
        }
        return IntStream.range(0, tempString.length() / 2)
                .noneMatch(i -> tempString.charAt(i) != tempString.charAt(tempString.length() - i - 1));

    }

    public static boolean isPalindromeNumber(long id) {
        String tempString = String.valueOf(id);
        if (tempString.length() < 3) {
            return false;
        }
        return IntStream.range(0, tempString.length() / 2)
                .noneMatch(i -> tempString.charAt(i) != tempString.charAt(tempString.length() - i - 1));

    }

    public static boolean isPrime(long id){

        if (id <= 1) {
            return false;
        }
        for (int i = 2; i < id; i++) {
            if (id % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isOdd(long id){
        if (id < 1) {
            return false;
        }
        if(id % 2 == 0){
            return false;
        }else{

            return true;

        }
    }
}
