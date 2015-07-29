import java.util.*;

/**
 * Created by ledenev.p on 29.07.2015.
 */
public class WaterSquare extends Square {

    public WaterSquare() {
        super(0);
    }

    @Override
    protected int coastLength() {

        int length = 0;
        for (Square item : neighbors)
            length += item.edgeCoastLength;

        return length;
    }

    @Override
    public void addTo(Stack<Square> stack) {

        if (!isVisited)
            stack.add(this);
    }
}
