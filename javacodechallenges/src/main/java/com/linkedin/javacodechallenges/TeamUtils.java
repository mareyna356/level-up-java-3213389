package com.linkedin.javacodechallenges;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class TeamUtils {

  public static void generateTeamsScores(List<Team> teams,
      int numberOfRounds) {
    Random random = new Random();
    teams.forEach(team -> {
      for (int i = 0; i < numberOfRounds; i++) {
        team.getScores().add(random.nextInt(11));
      }
    });
  }

  public static void revealResults(List<Team> teams) {
    if (teams.isEmpty() || teams.stream().allMatch(team -> team.getScores().isEmpty())) {
      System.out.println("The game hasn't started yet.");
      return;
    }

    //Sort the teams by score using the teams as keys.
    Map<Team, Integer> teamsAndScores = teams.stream()
        .collect(Collectors.toMap(team -> team, team -> team.sumTotalScore()));
    LinkedHashMap<Team, Integer> sortedTeams = teamsAndScores.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
            LinkedHashMap::new));

    //Print the winner(s).
    Set<Map.Entry<Team, Integer>> entrySet = sortedTeams.entrySet();
    Iterator<Map.Entry<Team, Integer>> it = entrySet.iterator();

    System.out.print("The winners are ");
    Map.Entry<Team, Integer> topEntry = it.next();
    Team topTeam = topEntry.getKey();
    System.out.print(topTeam.getPlayer1() + "-" + topTeam.getPlayer2());
    int topScore = topEntry.getValue().intValue();
    if (it.hasNext()) {
      topEntry = it.next();
      while (topEntry.getValue().intValue() == topScore) {
        topTeam = topEntry.getKey();
        System.out.print(", " + topTeam.getPlayer1() + "-" + topTeam.getPlayer2());
        if (it.hasNext())
          topEntry = it.next();
        else
          break;
      }
    }

    //Print the scoreboard.
    System.out.println(".\nScoreboard:");

    it = entrySet.iterator();
    it.forEachRemaining((entry) -> {
      Team team = entry.getKey();
      Integer resultScore = entry.getValue();
      System.out.println(team.getPlayer1() + "-" + team.getPlayer2() + ": " + resultScore + " points");
    });
  }
}