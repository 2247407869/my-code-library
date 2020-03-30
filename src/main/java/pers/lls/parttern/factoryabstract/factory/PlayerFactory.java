package pers.lls.parttern.abstractfactory.factory;

import pers.lls.parttern.abstractfactory.cd.CD;
import pers.lls.parttern.abstractfactory.player.Player;

// 抽象工厂，封装工厂中公有的部分
public interface PlayerFactory {
    Player createPlayer();

    CD createCD();
}
