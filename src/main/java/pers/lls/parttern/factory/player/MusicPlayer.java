package pers.lls.parttern.factory;

import java.io.File;

//具体产品，定义个性化善变的部分
public class MusicPlayer implements Player {
    @Override
    public void play(File file){
        System.out.println("播放音乐!!");
    }
}
