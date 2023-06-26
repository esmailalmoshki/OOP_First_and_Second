import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GameFactory blackJackFactory = new BlackJackFactory();
        Dealer dealer =  blackJackFactory.createDealer("Ais");
        Player player1 = blackJackFactory.createPlayer("Mo");
        player1.setBet(100);
        Player player2 = blackJackFactory.createPlayer("Ez");
        player2.setBet(70);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        BlackJackPlayingGround playingGround = new BlackJackPlayingGround(dealer,players);
        dealer.shuffle();
        dealer.deal(players);
        ((BlackJackDealer)dealer).compare(players);
        BlackJackDealer blackJackDealer;

        System.out.println("Dealer's hand : "+dealer.handCount());
        System.out.println("Dealer hand "+dealer.getPlayingCards());
        System.out.println("First player hand "+player1.getPlayingCards());
        System.out.println("Second player hand "+player2.getPlayingCards());
        System.out.println("First player Status: "+player1.getStatus()
                + " , his bet is : "+ player1.getBet());
        System.out.println("Second player Status: "+player2.getStatus()
                + " , his bet is : "+ player2.getBet());
        System.out.println(dealer.deck);


    }
}