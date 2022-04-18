package pers.lls.demo;

import lombok.Data;

/**
 *
 */
public class Main2 {

    public static void main(String[] args) {
        Animal animal = getAnimal();

        System.out.println(getb(animal));
    }

    private static Animal getAnimal() {
        Peaple peaple = new Peaple();
        peaple.setBrain("GOOD");
        return peaple;
    }

    public static String getb(Animal animal){
        if (animal instanceof Peaple){
            return ((Peaple) animal).getBrain();
        } else return null;
    }
}

@Data
class Animal {
    String foot;
}

@Data
class Peaple extends Animal {
    String brain;
}

