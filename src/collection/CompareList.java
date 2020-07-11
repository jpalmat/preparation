package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class CompareList {
    public static void main(String[] args) {
        ArrayList<Person> listOne = new ArrayList<Person>(Arrays.asList(new Person("Jimmy", 30), new Person("Maryam", 33)));
        ArrayList<Person> listTwo = new ArrayList<Person>(Arrays.asList(new Person("Jimmy", 30), new Person("Maryam", 31)));
        System.out.println(listOne.equals(listTwo));
        //remove all elements of second list
//        listOne.removeAll(listTwo);
//        System.out.println(listOne);
        //find common elements
        listOne.retainAll(listTwo);
        System.out.println(listOne);

    }
}
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}