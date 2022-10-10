package pers.lls.parttern.state;

/**
 * @program: my-parttern-practice
 * @description:
 * @author: lils
 * @create: 2019-08-13 11:09
 */
public class CandyMachine {
    private int number;
    private State state;

    public CandyMachine() {
        this.number = 2;
        this.state = new NormalState();
    }

    public void rotatingSwicth(){
        System.out.println("you rotating the swicth");
        number--;
        System.out.println("you get a candy");
        if(this.number == 0){
            this.state = new EmptyState();
        }else {
            this.state = new NormalState();
        }
        observe();

    }

    private void observe(){
        this.state.observe();
    }
}
