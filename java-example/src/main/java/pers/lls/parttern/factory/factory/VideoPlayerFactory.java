package pers.lls.parttern.factory.factory;

import pers.lls.parttern.factory.player.Player;
import pers.lls.parttern.factory.player.VideoPlayer;

//具体工厂，与具体产品相对应
public class VideoPlayerFactory implements PlayerFactory {
    @Override
    public Player createPlayer(){
        return new VideoPlayer();
    }
}
