package pers.lls.parttern.strategy;

/**
 * @program: parttern-practice
 * @description:
 * @author: lils
 * @create: 2019-06-10 10:33
 */
public class SwordBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("sword attack");
    }
}
