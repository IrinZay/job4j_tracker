package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("111@mail.ru", "Petr Petrov");
        map.put("222@mail.ru", "Ivan Ivanov");
        map.put("333@mail.ru", "Fedor Fedorov");
        map.put("444@mail.ru", "Igor Igorev");
        map.put("555@mail.ru", "Oleg Olegov");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }

    }
}
