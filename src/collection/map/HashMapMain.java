package collection.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {
    public static void main(String[] args) {
        Map<String, String> mapHashMap = new HashMap<>();
        mapHashMap.put("2", "2");
        mapHashMap.put("1", "1");
        System.out.println(mapHashMap.get("2"));
        System.out.println(mapHashMap.getOrDefault("3", "4"));
        mapHashMap.putIfAbsent("2", "3");
        System.out.println(mapHashMap.get("2"));
        //merge hashMaps
        Map<String, Employee> map1 = new HashMap<>();
        Map<String, Employee> map2 = new HashMap<>();

        Employee employee1 = new Employee(1L, "Henry");
        map1.put(employee1.getName(), employee1);
        Employee employee2 = new Employee(22L, "Annie");
        map1.put(employee2.getName(), employee2);
        Employee employee3 = new Employee(8L, "John");
        map1.put(employee3.getName(), employee3);

        Employee employee4 = new Employee(2L, "George");
        map2.put(employee4.getName(), employee4);
        Employee employee5 = new Employee(3L, "Henry");
        map2.put(employee5.getName(), employee5);

        System.out.println(map1);
        System.out.println(map2);

        System.out.println("merge");
        map2.forEach((key, value) -> map1.merge(key, value, (v1, v2) -> new Employee(v1.getId(),v2.getName())));
        System.out.println(map1);

    }
}
class Employee {
    private Long id;
    private String name;

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}