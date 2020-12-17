package pers.lls.parttern.factoryabstract;

import pers.lls.parttern.factoryabstract.factory.MusicPlayerFactory;
import pers.lls.parttern.factoryabstract.factory.VideoPlayerFactory;
import pers.lls.parttern.factoryabstract.player.Player;

//主类，具体调用
public class Main {
    public static void main(String[] args){

        VideoPlayerFactory videoFactory = new VideoPlayerFactory();
        Player videoPlayer = videoFactory.createPlayer();
        videoPlayer.play(videoFactory.createCD());

        MusicPlayerFactory musicFactory = new MusicPlayerFactory();
        Player musicPlayer = musicFactory.createPlayer();
        musicPlayer.play(musicFactory.createCD());
    }
}


