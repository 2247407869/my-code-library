package pers.lls.parttern.observerbuiltin;

import java.util.Observable;

/**
 * @program: parttern-practice
 * @description:
 * @author: lils
 * @create: 2019-06-10 16:38
 */
public class ConcreteSubject extends Observable {
    private String event;

    public void getEvent(String event){
        this.event = event;
        setChanged();
        notifyObservers(event);
    }
}
