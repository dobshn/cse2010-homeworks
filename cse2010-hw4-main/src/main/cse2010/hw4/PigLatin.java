package cse2010.hw4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PigLatin {
    static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public static String toPigLatin(String input) {
        // base case: 첫 글자가 모음 -> 문자 뒤에 ya를 붙여서 return
        if (vowels.contains(input.charAt(0))) return input  + "ay";
        // recursive case: 첫 글자가 자음 -> 첫 글자를 맨 뒤로 보내고 toPigLatin의 인자로 전달
        else return toPigLatin(input.substring(1) + input.charAt(0));
    }

    public static void main(String[] args) {
        List<String> words = List.of("pig", "latin", "smile", "string", "eat");

        System.out.println(words.stream()
                .map(PigLatin::toPigLatin)
                .collect(Collectors.toList()));
    }
}
