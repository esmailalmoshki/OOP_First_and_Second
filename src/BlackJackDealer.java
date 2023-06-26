import java.lang.reflect.Array;
import java.util.ArrayList;

public class BlackJackDealer extends Dealer {

    BlackJackDealer(String name) {
        super(name);
    }

    private ArrayList<PlayingCard> playingCards = new ArrayList<>();


    @Override
    public void deal(ArrayList<Player> players) {
            for (int i = 0; i < 2; i++){
                for (Player player : players) {
                    //Dealer gives 2 cards for each player
                    ArrayList<PlayingCard> holder = new ArrayList<>(player.cards);
                    holder.add(deck.get(deck.size() - 1 ));
                    player.setPlayingCards(holder);
                    //Dealer removes the distributed card from the deck
                    deck.remove(deck.size() - 1 );
                }
                ArrayList<PlayingCard> holder2 = new ArrayList<>(this.playingCards);
                holder2.add(deck.get(deck.size()-1));
                playingCards = holder2;
                //Dealer removes his card from the deck
                deck.remove(deck.size() - 1);
            }
        while (this.hasInRange(0, 16)) {
            ArrayList<PlayingCard> cardHolder = new ArrayList<>(getPlayingCards());
            cardHolder.add(deck.get(deck.size() - 1));
            setPlayingCards(cardHolder);
            deck.remove(deck.size() - 1 );
        }

        for(Player player:players){
            if(!player.hasMoreThan(17)){

                player.takeCard(deck.get(deck.size() - 1 ));
                deck.remove(deck.size() - 1);
            }
        }

    }

    public void compare(ArrayList<Player> players){
        for(Player player:players){
            if (player.handCount()>this.handCount()){
                player.setStatus("Win");
                player.setHasWon(true);
                player.setBet(player.getBet()*2);
            } else if (player.handCount()==this.handCount()) {
                //TODO not mentioned in question;
                player.setStatus("Tie");
            }
            else {
                player.setStatus("Loss");
                player.setHasWon(false);
                player.setBet(0);
            }

        }
    }




    public ArrayList<PlayingCard> getPlayingCards() {
        return playingCards;
    }

    public void setPlayingCards(ArrayList<PlayingCard> playingCards) {
        this.playingCards = playingCards;
    }
    public boolean hasInRange(int start, int end){
        ArrayList<PlayingCard> cards = this.getPlayingCards();
        int count = 0;
        for(PlayingCard card : cards){
            count += card.numeric.value;
        }
        return (count >= start && count <=end);
    }
    public void takeCard(PlayingCard card){
        if(hasInRange(17,21)) {
            this.playingCards.add(card);
        }
        this.deck.remove(card);
    }
    public boolean hasAce(){
        boolean hasAce = false;
        for(PlayingCard card: playingCards){
            if (card.numeric == Numerics.Ace) {
                hasAce = true;
                break;
            }
        }
        return hasAce;
    }

}
