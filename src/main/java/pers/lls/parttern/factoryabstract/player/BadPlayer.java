package pers.lls.parttern.factoryabstract.player;

import pers.lls.parttern.factoryabstract.cd.CD;

//具体产品，定义个性化善变的部分，可以有一至多个
public class BadPlayer implements Player {
    @Override
    public void play(CD cd){
        cd.play();
    }
}
