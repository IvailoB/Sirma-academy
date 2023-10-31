package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StarfighterFormation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> formation = new ArrayList<>();
        String[] initialFormation = scanner.nextLine().split(", ");

        for (var fighter : initialFormation) {
            formation.add(Integer.parseInt(fighter));
        }

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("end")) {
                break;
            }

            String[] data = line.split(" ");
            String command = data[0];

            switch (command) {
                case "destroy":
                    int removeIndex = Integer.parseInt(data[1]);
                    if (removeIndex >= 0 && removeIndex < formation.size()) {
                        formation.remove(formation.get(removeIndex));
                        System.out.println(formation);
                    }
                    break;
                case "swap":
                    int index1 = Integer.parseInt(data[1]);
                    int index2 = Integer.parseInt(data[2]);
                    if (index1 >= 0 && index1 <= formation.size()
                            && index2 >= 0 && index2 <= formation.size()
                            && index1 != index2) {
                        Integer fighter1 = formation.get(index1);
                        formation.set(index1, formation.get(index2));
                        formation.set(index2, fighter1);
                        System.out.println(formation);
                    }
                    break;
                case "add":
                    int addIndex = Integer.parseInt(data[1]);
                    formation.add(addIndex);
                    System.out.println(formation);

                    break;
                case "insert":
                    int fighterToInsert = Integer.parseInt(data[1]);
                    int insertIndex = Integer.parseInt(data[2]);
                    if (insertIndex >= 0 && insertIndex <= formation.size()) {
                        formation.add(insertIndex, fighterToInsert);
                        System.out.println(formation);
                    }
                    break;
                case "center":
                    int center = formation.size() / 2;
                    if (formation.size() % 2 == 0) {
                        System.out.println(formation.get(center - 1) + " " + formation.get(center));
                    } else {
                        System.out.println(formation.get(center));
                    }
                    break;
            }

        }


    }
}
