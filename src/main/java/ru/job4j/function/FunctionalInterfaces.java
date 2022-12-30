package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);
        int i = 1;
        for (String s : list) {
            biCon.accept(i++, s);
        }
        System.out.println(map);

        BiPredicate<Integer, String> biPred = (j, s) -> (j % 2 == 0 || s.length() == 4);
        for (Integer j : map.keySet()) {
            if (biPred.test(j, map.get(j))) {
                System.out.println("key: " + j + " value: " + map.get(j));
            }
        }
        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> strings = sup.get();
        for (String s : strings) {
            System.out.println(s);
        }

        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = (s) -> s.toUpperCase();
        for (String s : strings) {
            con.accept(func.apply(s));
        }
    }
}
