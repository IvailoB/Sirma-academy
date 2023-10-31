package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedLightsaberDuels {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        ArrayDeque<Character> arr = new ArrayDeque<>();
        String result = "Legendary";

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (!arr.isEmpty() && arr.peek().equals('!')){
                if (arr.pop() != '!') {
                    result = "Not Legendary";
                }
            }

            if (c == '(' || c == '!' || c == '{') {
                arr.push(c);
            } else if (c == ')') {
                if (arr.pop() != '(') {
                    result = "Not Legendary";
                }
            } else if (c == '}') {
                if (arr.pop() != '{') {
                    result = "Not Legendary";
                }
            }
        }
        if (!arr.isEmpty()) {
            result = "Not Legendary";
        }
        System.out.println(result);
    }
}
