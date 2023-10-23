package com.linkedin.javacodechallenges;

public class App {
    public static void main(String[] args) {
        Person marco = new Person("Marco", "Reyna Vargas", 24);
        Person mario = new Person("Mario", "Mario", 35);
        Person luigi = new Person("Luigi", "Mario", 35);

        marco.introduction();
        mario.introduction();
        luigi.introduction();
    }
}
