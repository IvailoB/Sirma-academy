package com.company;

import java.util.Scanner;

public class SithCodeCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretMessage = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < secretMessage.length(); i++){
            char c = secretMessage.charAt(i);

            if (Character.isLetter(c)){
                int decodeChar = c + n;
                sb.append((char)decodeChar);
            }else {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }
}
