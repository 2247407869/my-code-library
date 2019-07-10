package pers.lls.parttern.strategy;

/**
 * @program: parttern-practice
 * @description:
 * @author: lils
 * @create: 2019-06-10 11:30
 */
public class Main {
    public static void main(String[] args) {
        Character king = new King();
        SwordBehavior sword = new SwordBehavior();
        king.setWeapon(sword);
        //todo 怎么输出是谁使用了武器呢
        king.fight();
    }
}
