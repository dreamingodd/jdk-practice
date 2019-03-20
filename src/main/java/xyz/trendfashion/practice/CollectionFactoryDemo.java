package xyz.trendfashion.practice;

import java.util.Set;

public class CollectionFactoryDemo {
    public static void main(String[] args) {
        Set<String> stringSet = Set.of("You ", "'re ", "beautiful ", " !", "!! ");
        stringSet.forEach(System.out::print);
        System.out.println("-");

        Set<Integer> integerSet = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = integerSet.stream().reduce(Integer::sum).get();
        System.out.println(sum);
        // parallel
        sum = integerSet.stream().parallel().reduce(Integer::sum).get();
        System.out.println(sum);
    }


}
