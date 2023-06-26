import java.util.ArrayList;

public class BlackJackPlayingGround extends PlayingGround {

    @Override
    public void play() {
        BlackJackFactory blackJackFactory = new BlackJackFactory();
        Dealer dealer = this.dealer;

        dealer.shuffle();
        dealer.deal(players);
        ((BlackJackDealer)dealer).compare(players);
    }

    public BlackJackPlayingGround(Dealer dealer, ArrayList<Player> players) {
        super(dealer,players);
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

   }
