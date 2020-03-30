package pers.lls.parttern.abstractfactory;

import pers.lls.parttern.abstractfactory.factory.MusicPlayerFactory;
import pers.lls.parttern.abstractfactory.factory.VideoPlayerFactory;
import pers.lls.parttern.abstractfactory.player.Player;

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


