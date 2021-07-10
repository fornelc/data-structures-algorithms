package com.algorithms.datastructures.arrays;

import java.util.*;

public class TournamentWinner {
    private static final int HOME_TEAM_WON = 1;

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        String currentWinner = "";
        Map<String, Integer> scores = new HashMap<>();
        scores.put(currentWinner, 0);

        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> competition = competitions.get(i);
            Integer result = results.get(i);

            String homeTeam = competition.get(0);
            String awayTeam = competition.get(1);

            String winner = (result == HOME_TEAM_WON) ? homeTeam : awayTeam;

            updateScores(winner, 3, scores);

            if (scores.get(winner) > scores.get(currentWinner)) {
                currentWinner = winner;
            }
        }

        return currentWinner;
    }

    private void updateScores(String winner, int i, Map<String, Integer> scores) {
        if (!scores.containsKey(winner)) {
            scores.put(winner, 0);
        }

        scores.put(winner, scores.get(winner) + i);
    }
}
