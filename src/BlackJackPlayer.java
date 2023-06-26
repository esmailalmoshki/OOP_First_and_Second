import java.util.ArrayList;

public class BlackJackPlayer extends Player {


    public BlackJackPlayer(String name) {
        super(name);
    }



    public void takeCard(PlayingCard card) {
        if (!(getPlayingCards() == null)){
            if (!hasMoreThan(21)) {
            ArrayList<PlayingCard> tempcards = new ArrayList<>(getPlayingCards());
            tempcards.add(card);
            this.setPlayingCards(tempcards);
            }
        else {
            ArrayList<PlayingCard> tempcards = new ArrayList<>(getPlayingCards());
                tempcards.add(card);
                this.setPlayingCards(tempcards);
            }
        }
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
