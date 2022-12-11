package pers.lls.parttern.strategy;

/**
 * @program: parttern-practice
 * @description:
 * @author: lils
 * @create: 2019-06-10 10:26
 */
public abstract class Character {

    private WeaponBehavior weapon;

    void fight(){
        weapon.useWeapon();
    }

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }

}
