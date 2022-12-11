package pers.lls.parttern.factory.factory;

import pers.lls.parttern.factory.player.Player;

// 抽象工厂，封装工厂中公有的部分
public interface PlayerFactory {
    Player createPlayer();
}
