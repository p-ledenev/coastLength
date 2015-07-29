import java.util.*;

/**
 * Created by ledenev.p on 29.07.2015.
 */
public class LandSquare extends Square {

    public LandSquare() {
        super(1);
    }

    @Override
    protected int coastLength() {
        return 0;
    }

    @Override
    public void addTo(Stack<Square> stack) {
    }
}
