
import java.util.concurrent.CancellationException;

public class PlayingCard {
    public PlayingCard(Numerics numeric, CardType cardType){
        this.cardType=cardType;
        this.numeric=numeric;
    }
    public Numerics numeric;

    public CardType cardType;

    @Override
    public String toString() {
        return numeric.toString() + " of " + cardType.toString();
    }
}
