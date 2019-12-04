package pers.lls.parttern.factory;

import java.io.File;

//主类，具体调用
public class Main {
    public static void main(String[] args){
        VideoPlayerFactory videoFactory = new VideoPlayerFactory();
        Player videoPlayer = videoFactory.createPlayer();
        File file = new File("csdn.mp4");
        videoPlayer.play(file);
        MusicPlayerFactory musicFactory = new MusicPlayerFactory();
        Player musicPlayer = musicFactory.createPlayer();
        File musicFile = new File("lsr.mp3");
        musicPlayer.play(musicFile );
    }
}


