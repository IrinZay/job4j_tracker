package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0;
        int counter = 0;
        for (Pupil student : pupils) {
            for (Subject subject : student.subjects()) {
                rsl = rsl + subject.getScore();
                counter++;
            }
        }
        return rsl / counter;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil student : pupils) {
            double score = 0;
            for (Subject subject : student.subjects()) {
                score = score + subject.getScore();
            }
            score = score / student.subjects().size();
            rsl.add(new Label(student.name(), score));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        LinkedHashMap<String, Integer> subjectMap = new LinkedHashMap<>();
        for (Pupil student : pupils) {
            for (Subject subject : student.subjects()) {
                String name = subject.getName();
                subjectMap.put(name, subjectMap.getOrDefault(name, 0) + subject.getScore());
            }
        }
        for (Map.Entry<String, Integer> entry : subjectMap.entrySet()) {
            double score = (double) entry.getValue() / pupils.size();
            rsl.add(new Label(entry.getKey(), score));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil student : pupils) {
            double score = 0;
            for (Subject subject : student.subjects()) {
                score = score + subject.getScore();
            }
            rsl.add(new Label(student.name(), score));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        LinkedHashMap<String, Integer> subjectMap = new LinkedHashMap<>();
        for (Pupil student : pupils) {
            for (Subject subject : student.subjects()) {
                String name = subject.getName();
                subjectMap.put(name, subjectMap.getOrDefault(name, 0) + subject.getScore());
            }
        }
        for (Map.Entry<String, Integer> entry : subjectMap.entrySet()) {
            double score = (double) entry.getValue();
            rsl.add(new Label(entry.getKey(), score));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }
}
