import java.util.ArrayList;

public abstract class PlayingGround {
    public ArrayList<Player> players;
    public Dealer dealer;

    public abstract void play();

    public PlayingGround(Dealer dealer, ArrayList<Player> players) {
        this.dealer = dealer;
        this.players = players;
    }


}
