package javaPrep;

public class Inheritance {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Animal animal = new Perro();

        perro.ladrar();
    }
}
class Animal {
    public void dormir(){

    }
    public void comer(){

    }
}

class Perro extends  Animal {
    public void ladrar(){

    }
}