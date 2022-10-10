package pers.lls.parttern.factoryabstract.factory;

import pers.lls.parttern.factoryabstract.player.BadPlayer;
import pers.lls.parttern.factoryabstract.cd.CD;
import pers.lls.parttern.factoryabstract.cd.ChineseCD;
import pers.lls.parttern.factoryabstract.player.Player;

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
