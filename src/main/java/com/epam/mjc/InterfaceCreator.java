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
        return x -> {
            for (String s : x) {
                if (s.charAt(0) < 65 || s.charAt(0) > 90) {
                    return false;
                }
            }
            return true;
        };
    }


    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> list = new ArrayList<>();
            list.addAll(x);
            for (Integer e : list) {
                if (e % 2 == 0) {
                    x.add(e);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> copyValues = new ArrayList<>();
            for (String str : values) {
                if (str.trim().substring(0, 1).equals(str.trim().substring(0, 1).toUpperCase())
                        && str.charAt(str.length() - 1) == ('.')
                        && str.trim().split(" ").length > 3) {
                    copyValues.add(str);
                }
            }

            return copyValues;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x ->{
            HashMap<String, Integer> map = new HashMap<>();
            for(String str : x){
                map.put(str,str.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }
}
