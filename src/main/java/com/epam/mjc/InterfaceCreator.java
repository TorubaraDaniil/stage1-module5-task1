package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return isTrue -> {
            for (String s:
                    isTrue) {
                char c = s.charAt(0);
                if (!Character.isUpperCase(c)) return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> list = new ArrayList<>();
            for (int number: x) {
                if (number % 2 == 0){
                    list.add(number);
                }
            }
            x.addAll(list);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < values.size(); i++) {
                String sentence = values.get(i);
                boolean c1 = Character.isUpperCase(sentence.charAt(0));
                int charIndex = sentence.lastIndexOf(".");
                boolean c2 =  charIndex != -1 && charIndex == sentence.length() - 1;
                boolean c3 = sentence.split(" ").length > 3;
                if(c1 && c2 && c3) {
                    result.add(sentence);
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> result = new HashMap<>();
            list.forEach(str -> {
                result.put(str, str.length());
            });
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>();
            result.addAll(list1);
            result.addAll(list2);
            return result;
        };
    }
}
