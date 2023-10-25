package com.linkedin.javacodechallenges;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Joke {
  private String id;
  private String joke;
  private int status;

  @Override
  public String toString() {
    return this.joke;
  }
}
