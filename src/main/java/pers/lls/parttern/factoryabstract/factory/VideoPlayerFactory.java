package pers.lls.parttern.abstractfactory.factory;

import pers.lls.parttern.abstractfactory.player.BadPlayer;
import pers.lls.parttern.abstractfactory.cd.CD;
import pers.lls.parttern.abstractfactory.cd.ChineseCD;
import pers.lls.parttern.abstractfactory.player.Player;

//具体工厂，与具体产品相对应
public class VideoPlayerFactory implements PlayerFactory {
    @Override
    public Player createPlayer(){
        return new BadPlayer();
    }

    public CD createCD(){
        return new ChineseCD();
    }
}
