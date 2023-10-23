package com.linkedin.javacodechallenges;

import java.util.Random;
import java.util.Scanner;

public class DoubleOrNothing {

  private int points;
  private static int startPoints = 10;
  private String option;
  private Scanner sc;
  private Random random = new Random();
  private int chance;

  private void askInput() {
    System.out.println("Current points: " + this.points + "\nTake a chance to double your points? Y or N");
    this.option = this.sc.nextLine();
  }

  private void printLoss() {
    System.out.println("You lost! Your points are now 0.");
  }

  private void printGoodbye() {
    System.out.println("Thanks for playing. Goodbye!");
  }

  public void playGame() {
    sc = new Scanner(System.in);
    this.points = startPoints;

    askInput();
    while (this.option.equalsIgnoreCase("y")) {
      this.chance = this.random.nextInt(2);
      if (this.chance == 1)
        this.points *= 2;
      else
        this.points = 0;
      if (this.points == 0) {
        printLoss();
        break;
      }
      askInput();
    }
    printGoodbye();
    sc.close();
  }
}