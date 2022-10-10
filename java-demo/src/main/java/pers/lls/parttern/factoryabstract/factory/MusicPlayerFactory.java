package pers.lls.parttern.factoryabstract.factory;

import pers.lls.parttern.factoryabstract.cd.CD;
import pers.lls.parttern.factoryabstract.player.GoodPlayer;
import pers.lls.parttern.factoryabstract.cd.JapanCD;
import pers.lls.parttern.factoryabstract.player.Player;

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
