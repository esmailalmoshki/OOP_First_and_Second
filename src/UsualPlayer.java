public class UsualPlayer extends Player{
    public UsualPlayer(String name) {
        super(name);
    }

    @Override
    public void takeCard(PlayingCard card) {
        //TODO make regular take card implementation
    }

    @Override
    public void joinGame(PlayingGround playingGround) {
        playingGround.players.add(this);
    }

    @Override
    public void allocateBet(float betSum) {
        this.setBet(betSum);
    }

}
