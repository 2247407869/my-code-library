package pers.lls.parttern.factory;

//具体工厂，与具体产品相对应
public class MusicPlayerFactory implements PlayerFactory {
    @Override
    public Player createPlayer(){
        return new MusicPlayer();
    }
}
