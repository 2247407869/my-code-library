package pers.lls.parttern.abstractfactory.factory;

import pers.lls.parttern.abstractfactory.cd.CD;
import pers.lls.parttern.abstractfactory.player.GoodPlayer;
import pers.lls.parttern.abstractfactory.cd.JapanCD;
import pers.lls.parttern.abstractfactory.player.Player;

//具体工厂，与具体产品相对应
public class MusicPlayerFactory implements PlayerFactory {
    @Override
    public Player createPlayer(){
        return new GoodPlayer();
    }

    @Override
    public CD createCD() {
        return new JapanCD();
    }


}
