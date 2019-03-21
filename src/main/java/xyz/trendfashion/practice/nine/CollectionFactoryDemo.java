package xyz.trendfashion.practice.nine;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public class CollectionFactoryDemo {
    public static void main(String[] args) {
        Set<String> stringSet = Set.of("You ", "'re ", "beautiful ", " !", "!! ");
        stringSet.forEach(System.out::print);
        System.out.println("-");

        Set<Integer> integerSet1 = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Set<Integer> integerSet2 = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = integerSet1.stream().reduce(Integer::sum).get();
        System.out.println(sum);
        // parallel
        sum = integerSet2.stream().parallel().reduce(Integer::sum).get();
        System.out.println(sum);
    }

    private static <T> Set<T> of (T... values) {
        Set<T> set = new LinkedHashSet<>();
        // Add
        Stream.of(values).forEach(value ->{
            set.add(value);
        });
        return set;
    }


}
