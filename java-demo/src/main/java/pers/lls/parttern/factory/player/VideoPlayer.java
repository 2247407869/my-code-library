package pers.lls.parttern.factory.player;

import java.io.File;

//具体产品，定义个性化善变的部分，可以有一至多个
public class VideoPlayer implements Player {
    @Override
    public void play(File file){
        System.out.println("播放视频!!");
    }
}
