package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GalacticSenatorsVotes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] votes = scanner.nextLine().split(", ");

        Map<String, Integer> countVotes = new HashMap<>();

        for (var vote: votes) {
            countVotes.put(vote,countVotes.getOrDefault(vote,0)+1);
        }

        String finalVote = "";
        int majorityCountVote = 0;

        for (var vote : countVotes.entrySet()) {
            if (vote.getValue() > majorityCountVote){
                finalVote = vote.getKey();
                majorityCountVote = vote.getValue();
            }
        }

        for (var vote : countVotes.entrySet()) {
            if (vote.getValue() == majorityCountVote && !vote.getKey().equals("Abstain")
                    && !vote.getKey().equals(finalVote)) {
                finalVote = "Tie";
                break;
            }
        }

        System.out.println(finalVote);
    }
}
