package com.linkedin.javacodechallenges;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

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

  public static Optional<StoreItem> findLeastExpensive(Collection<StoreItem> items) {
    return items.stream().min(new StoreItemPriceComparator());
  }

  @Override
  public String toString() {
    return "Name: " + name + ", " + "Retail price: " + retailPrice + ", " + "Discount " + discount;
  }
}

class StoreItemPriceComparator implements Comparator<StoreItem> {

  @Override
  public int compare(StoreItem item1, StoreItem item2) {
    double item1Total = item1.getRetailPrice() * (1 - item1.getDiscount());
    double item2Total = item2.getRetailPrice() * (1 - item2.getDiscount());
    return Double.compare(item1Total, item2Total);
  }
}