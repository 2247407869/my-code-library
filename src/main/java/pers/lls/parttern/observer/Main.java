package pers.lls.parttern.observer;

/**
 * @program: pattern-practice
 * @description:
 * @author: lils
 * @create: 2019-06-11 11:07
 */
public class Main {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        ConcreteObserver concreteObserver = new ConcreteObserver(concreteSubject);
        concreteSubject.setState("hello");
    }
}
