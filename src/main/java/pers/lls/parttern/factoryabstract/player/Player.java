package pers.lls.parttern.factoryabstract.player;

import pers.lls.parttern.factoryabstract.cd.CD;

//抽象产品，封装产品中公有的部分
public interface Player {
    void play(CD cd); // 播放
}
