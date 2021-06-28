package javaPrep;

public class Pointers {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona();
        p1.name = "Ji";
        p2.name = "Jimmy";

        System.out.println(p1.name);
        System.out.println(p2.name);

        p1 = p2;

        System.out.println(p1.name);
        System.out.println(p2.name);

        p2.name = "bla";

        System.out.println(p1.name);
        System.out.println(p2.name);
    }

}

class Persona {
    String name;
}