import java.util.ArrayList;
import java.util.List;

public class Deck extends ArrayList<PlayingCard> {

    //TODO Personally I'd rather use singleton to ensure that deck is created the primitive format

    private Deck() {
        for (CardType cardType : CardType.values()) {
            for (Numerics numerics : Numerics.values()){
                this.add(new PlayingCard(numerics, cardType));
            }
        }
    }
    public static Deck getDeck(){
        return new Deck();
    }

}