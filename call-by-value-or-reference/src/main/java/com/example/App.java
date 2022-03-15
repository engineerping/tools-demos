package com.example;

import java.util.*;

/**
 *结论: Java的传参本质上是值传递,
 *      对于引用类型而言,传递的值为引用类型变量的内存地址.
 */
public class App {
    public static void main( String[] args ) {
        int i = 1000;
        Integer inValue = 2000;
        Integer inValue2 = 3000;

        //singleValue
        App app = new App();
        app.tripleValue(i);
        System.out.println(i);
        app.tripleValue(inValue);
        System.out.println(inValue);

        //HashSet
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(i);
        integerSet.add(inValue);
        integerSet.add(inValue2);
        app.tripleValues(integerSet);
        System.out.println(app.tripleValues(integerSet));

        //ArrayList
        List<Integer> integerList = new ArrayList<>();
        integerList.add(0, i);
        integerList.add(1, inValue);
        integerList.add(2, inValue2);
        app.tripleReferenceValues(integerList);
        System.out.println(integerList);

        Person person = new Person();
        person.aroundAge();
        System.out.println(person.getAge());

    }

    private void tripleValue(Integer it) {
        it = 3 * it;
    }

    private Collection<Integer> tripleValues(Collection<Integer> values) {
        for (Integer it : values) { //注意这里的it 是局部变量,给并不是values的元素的引用
            it = 3 * it;
        }
        return values;
    }
    private void tripleReferenceValues(List<Integer> values) {
        for (int i = 0; i < values.size(); i++) {
            values.set(i, values.get(i) * 3);
        }
    }

}


