package com.company;

import java.util.Scanner;

public class CountingWompRats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int h = Integer.parseInt(scanner.nextLine());

        int totalNumber = n;
        for (int i = 0; i < h-1; i++){
            n = n+m;
            totalNumber += n;
        }


        System.out.println(totalNumber);

    }
}
