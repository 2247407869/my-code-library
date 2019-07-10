package pers.lls.parttern.observerbuiltin;

/**
 * @program: parttern-practice
 * @description:
 * @author: lils
 * @create: 2019-06-11 11:07
 */
public class Main {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        ConcreteObserver concreteObserver = new ConcreteObserver(concreteSubject);
        concreteSubject.getEvent("hello");
        concreteObserver.unregiter();
        concreteSubject.getEvent("heihei");
    }
}
