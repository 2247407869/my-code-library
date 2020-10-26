package pers.lls.parttern.factoryabstract.factory;

import pers.lls.parttern.factoryabstract.cd.CD;
import pers.lls.parttern.factoryabstract.player.Player;

// 抽象工厂，封装工厂中公有的部分
// 抽象工厂可以创建多个具体产品的示例
public interface PlayerFactory {
    Player createPlayer();

    CD createCD();
}
