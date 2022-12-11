package pers.lls.parttern.observerbuiltin;


import java.util.Observable;
import java.util.Observer;

/**
 * @program: parttern-practice
 * @description:
 * @author: lils
 * @create: 2019-06-10 16:39
 */
public class ConcreteObserver implements Observer {
    private Observable observable;

    public ConcreteObserver(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this.toString()+arg);
    }

    public void unregiter(){
        observable.deleteObserver(this);
    }
}
