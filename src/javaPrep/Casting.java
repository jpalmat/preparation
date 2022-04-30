package javaPrep;

class ClaseA {
    public void metodo1() {
        System.out.println("CA-M1 ");
    }
}

class ClaseB extends ClaseA {
    public void metodo1() {
        System.out.println("CB-M1 ");
    }
    public void metodo2() {
        System.out.println("CB-M2 ");
    }
}
public class Casting {
    public static void main(String[] args) {
        ClaseA ca = new ClaseB();
        ClaseB cb = (ClaseB) ca;
        ClaseA ca2 = (ClaseA) cb;
        cb.metodo1();
        cb.metodo2();
        ca2.metodo1();
//        ca2.metodo2();
        ca = null;
//        ca2 = ca;
        ca2.metodo1();
    }
}