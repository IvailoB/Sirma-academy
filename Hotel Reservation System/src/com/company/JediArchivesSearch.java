package com.company;

import java.util.Scanner;

public class JediArchivesSearch {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] archives = scanner.nextLine().split(", ");
        String record = scanner.nextLine();

        int first = -1;

        int last = -1;
        for (int i = 0; i < archives.length; i++) {
            if (archives[i].contains(record)){
                if (first == -1){
                    first = i;
                }

                last = i;
            }

        }

        if (last == -1){
            System.out.println("Record not found");
        }else {
            System.out.printf("First Occurrence: %d\nLast Occurrence: %d", first, last);
        }

    }
}
