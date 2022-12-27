package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator = (o1, o2) ->
                Integer.compare(o1.getSize(), o2.getSize());
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator<Attachment> compareName  = (left, right) ->
                left.getName().compareTo(right.getName());
        attachments.sort(compareName);
        System.out.println(attachments);
        Comparator<String> cmpSize  = (left, right) ->
                Integer.compare(left.length(), right.length());
        Comparator<String> cmpText = (left, right) ->
                left.compareTo(right);
        Comparator<String> cmpDescSize = (left, right) ->
                Integer.compare(right.length(), left.length());
    }
}
