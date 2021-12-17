package com.example.deepjava.stream;

import com.example.deepjava.stream.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.reducing;

public class StreamBasic {

    public void streamEx1() {
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = list.stream();
        stream.forEach( alphabet -> System.out.println(alphabet) );

    }

    public void streamEx2() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");

        Stream<String> stream = list.stream();
        stream.forEach( StreamBasic :: print );
        System.out.println();

        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach( StreamBasic :: print );

    }
    public static void print(String str) {
        System.out.println(str + " : " + Thread.currentThread().getName());
    }

    public void streamEx3() {
        List<Student> list = Arrays.asList(
                new Student("jisoo", "female", 27),
                new Student("iu", "female", 28),
                new Student("haein", "male", 29)
        );
        double avg = list.stream()
                .mapToInt(Student :: getAge)
                .average()
                .getAsDouble();
        System.out.println("평균나이 : " + avg);
    }

    // 프로그래머스 코딩문제 해시 - 위장 (좋아요 많은 풀이)
    public int streamEx4(String[][] clothes) {
        Stream<String[]> stream = Arrays.stream(clothes);
        System.out.println(stream.collect(groupingBy(p -> p[1], mapping(p -> p[0], counting()))).values());
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1)))
                .intValue() - 1;
    }

}
