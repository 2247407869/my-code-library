package pers.lls.parttern.state;

import pers.lls.parttern.state.State;

/**
 * @program: my-parttern-practice
 * @description:
 * @author: lils
 * @create: 2019-08-13 11:15
 */
public class EmptyState implements State {

    @Override
    public void observe() {
        System.out.println("machine is empty");
    }
}
