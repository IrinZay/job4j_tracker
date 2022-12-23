package ru.job4j.collection;

import java.util.*;

public class Departments {
    /**
     * Метод принимает список названий департаментови возвращает список
     * с заполненными пробелами. k1/sk1, k2/sk2 - k1, k1/sk1, k2, k2/sk1
     * @param deps - список департаментов
     * @return - список с заполненными пробелами
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = value.split("/")[0];
            for (String el : value.split("/")) {
                if (el.toLowerCase().startsWith("s")) {
                    start = start + "/" + el;
                }
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * Метод сортирует номера департаментов по возрастанию.
     * @param orgs - список департаментов
     */
    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    /**
     * Метод сортирует департаменты по убыванию
     * заглавного департамента.
     * @param orgs - список департаментов
     */
    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
