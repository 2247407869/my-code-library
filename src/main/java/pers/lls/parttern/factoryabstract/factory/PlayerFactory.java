package pers.lls.parttern.factoryabstract.factory;

import pers.lls.parttern.factoryabstract.cd.CD;
import pers.lls.parttern.factoryabstract.player.Player;

// 抽象工厂，封装工厂中公有的部分
public interface PlayerFactory {
    Player createPlayer();

    CD createCD();
}
