package utils;

import java.util.Random;

public class RandomEmailGenerator {
    public static String randomEmail(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random rnd = new Random();
        String emailRandom;
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (sb.length() < 5){
        int index = (int) (rnd.nextFloat() * chars.length());
        sb.append(chars.charAt(index));
        }
        emailRandom = sb.toString().toLowerCase();
        return emailRandom;
    }


public static void main(String arg[]){
        String email = RandomEmailGenerator.randomEmail();
        System.out.println(email);

}};