package pers.lls.parttern.observer;

/**
 * @program: parttern-practice
 * @description:
 * @author: lils
 * @create: 2019-06-10 16:39
 */
public class ConcreteObserver implements Observer {
    private ConcreteSubject concreteSubject;

    public ConcreteObserver(ConcreteSubject concreteSubject){
        this.concreteSubject = concreteSubject;
        concreteSubject.registerObserver(this);
    }

    @Override
    public void update(String event) {
        System.out.println(this.toString()+event);
    }
}
