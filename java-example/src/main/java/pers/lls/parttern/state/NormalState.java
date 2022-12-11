package pers.lls.parttern.state;

/**
 * @program: my-parttern-practice
 * @description:
 * @author: lils
 * @create: 2019-08-13 11:24
 */
public class NormalState implements State {
    @Override
    public void observe() {
        System.out.println("normal state");
    }
}
