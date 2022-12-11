package pers.lls.parttern.observer;

import java.util.ArrayList;

/**
 * @program: parttern-practice
 * @description:
 * @author: lils
 * @create: 2019-06-10 16:38
 */
public class ConcreteSubject implements Subject {
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private String event;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);

    }

    @Override
    public void removeObserver(Observer o) {

    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(event);
        }
    }

    public void getState(String event){
        this.event = event;
    }

    public void setState(String event){
        this.event = event;
        notifyObservers();
    }
}
