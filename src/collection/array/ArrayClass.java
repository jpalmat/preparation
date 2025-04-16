package collection.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ArrayClass {
    public static void main(String[] args) {
        // String[] alphabet = new String[]{"A", "B", "C"};
        // System.out.println(arrayContains(alphabet));

        Test t = new Test(1, "John", "Doe");
        Test t1 = new Test(2, "Jimmy", "Palma");

        List<Test> jobs = new ArrayList<>(Arrays.asList(t, t1));
        System.out.println(jobs);

        // jobs.removeIf(job -> job.getId() == 1);
        // System.out.println(jobs);

        Test t1_updated = new Test(2, "Jimmyyyyyy", "Palmaaaaa");

        jobs.stream().filter(job -> job.getId() == t1_updated.getId()).findFirst().map(job -> {
            job.setName(t1_updated.getName());
            job.setLastname(t1_updated.getLastname());
            return true;
        });

        System.out.println(jobs);
    }

    public static boolean arrayContains(String[] arr){
        Optional<String> a = Arrays.stream(arr).filter(x-> x.equals("A")).findFirst();
        return a.isPresent();
    }
}

class Test {
    private int id;
    private String name;
    private String lastname;


    public Test(int id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
    
}
