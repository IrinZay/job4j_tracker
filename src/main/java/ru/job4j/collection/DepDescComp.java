package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    /**
     * Метод сравнивает номера департаментов {@link Departments}
     * и выстраивает их в орбратном порядке по убыванию главного департамента.
     * Сперва сравниваются заглавные департаменты. Если они равны, сравниваются
     * следующие в но уже в возрастающем порядке
     * @param o1 номер первого департамента.
     * @param o2 номер второго департамента.
     * @return - возвращает 0, если номера равны, -1 если первый департамент
     * меньше, 1, если первый департамент больше
     */
    @Override
    public int compare(String o1, String o2) {
        String left = o1.split("/")[0];
        String right = o2.split("/")[0];
        int rsl = right.compareTo(left);
        return rsl != 0 ? rsl : o1.compareTo(o2);
    }
}