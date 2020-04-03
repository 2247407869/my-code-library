package pers.lls.parttern.factory.factory;

import pers.lls.parttern.factory.player.MusicPlayer;
import pers.lls.parttern.factory.player.Player;

//具体工厂，与具体产品相对应
public class MusicPlayerFactory implements PlayerFactory {
    @Override
    public Player createPlayer(){
        return new MusicPlayer();
    }
}
