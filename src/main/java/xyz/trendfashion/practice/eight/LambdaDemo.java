package xyz.trendfashion.practice.eight;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaDemo {
    private static List<String> stringList = Arrays.asList("Kobe", "Michael", "Michelle", "Huntington", "Peter", "Johnson", "Clinton");
    public static void main(String[] args) {
        sortOriginal();
        sortLambda();
        toLowerCaseLamda();
        addSuffix();
    }

    private static void sortOriginal() {
        List<Integer> integerList = Arrays.asList(-10, 11, 432, 1, 129129);
        Collections.sort(integerList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(integerList);
    }

    private static void sortLambda() {
//        Collections.sort(stringList, (str1, str2) -> str1.compareTo(str2));
        Collections.sort(stringList, Comparator.comparing(s -> s));
        System.out.println(stringList);
    }

    private static void toLowerCaseLamda() {
        List<String> lowerStringList = stringList.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(lowerStringList);
    }

    private static void addSuffix() {
        List<String> suffixedStringList = stringList.stream().map(s -> {return s += "suffix";}).collect(Collectors.toList());
        System.out.println(suffixedStringList);
    }
}
