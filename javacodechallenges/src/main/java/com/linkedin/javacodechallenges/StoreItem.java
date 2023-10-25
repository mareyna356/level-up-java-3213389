package com.linkedin.javacodechallenges;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StoreItem {
  String name;
  double retailPrice;
  double discount;

  private double discountedPrice() {
    return this.getRetailPrice() * (1 - this.getDiscount());
  }

  public static Optional<StoreItem> findLeastExpensive(Collection<StoreItem> items) {
    return items.stream()
        .min(Comparator.comparing(StoreItem::discountedPrice));
    //return items.stream()
    //    .min(Comparator.comparing((item) -> item.getRetailPrice() * (1 - item.getDiscount())));
  }

  @Override
  public String toString() {
    return "Name: " + name + ", " + "Retail price: " + retailPrice + ", " + "Discount " + discount;
  }
}