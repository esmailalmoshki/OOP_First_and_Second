import java.util.ArrayList;

public abstract class Player {

    private String name;
    private double bet;

    public boolean HasWon() {
        return hasWon;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    private boolean hasWon;


    public ArrayList<PlayingCard> cards  = new ArrayList<>();

    public abstract void joinGame(PlayingGround playingGround);

    public abstract void allocateBet(float betSum);

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBet() {
        return bet;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }
    public ArrayList<PlayingCard> getPlayingCards() {
        return cards;
    }

    public void setPlayingCards(ArrayList<PlayingCard> playingCards) {
        this.cards = playingCards;
    }
    public boolean hasMoreThan(int max){
        if (this.getPlayingCards() == null) return false;
        ArrayList<PlayingCard> cards = this.getPlayingCards();
        int count = 0;
        for (PlayingCard card :cards ){
            count += card.numeric.value;
        }
            return count > max;


    }

    public boolean hasAce(){
        boolean hasAce = false;
        for(PlayingCard card: cards){
            if (card.numeric == Numerics.Ace) {
                hasAce = true;
                break;
            }
        }
        return hasAce;
    }
    public String getStatus(){
        if(hasWon){
            return "Winner";
        }
        return "Player has lost";
    }
    public int handCount(){
        ArrayList<PlayingCard> cards = getPlayingCards();
        int count = 0;
        for(PlayingCard card : cards){
            count += card.numeric.value;
        }
        return count ;
    }

    public abstract void takeCard(PlayingCard card) ;

    public String toString(){
        return this.name;
    }





}
