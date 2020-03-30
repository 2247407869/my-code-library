package pers.lls.parttern.factory;

import java.io.File;

//抽象产品，封装产品中公有的部分
public interface Player {
    void play(File file); // 播放
}
