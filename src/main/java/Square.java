import java.util.*;

/**
 * Created by ledenev.p on 27.07.2015.
 */
public abstract class Square {

    protected List<Square> neighbors;
    protected boolean isVisited;
    protected int edgeCoastLength;

    public void setNeighbors(List<Square> neighbors) {
        this.neighbors = neighbors;
    }

    public List<Square> getNeighbors() {
        return neighbors;
    }

    public static Square water() {
        return new WaterSquare();
    }

    public static Square land() {
        return new LandSquare();
    }

    protected Square(int edgeCoastLength) {
        neighbors = new ArrayList<Square>(4);
        isVisited = false;
        this.edgeCoastLength = edgeCoastLength;
    }

    public void addNeighbor(Square neighbor) {
        neighbors.add(neighbor);
    }

    public int computeCoastLength() {

        if (isVisited)
            return 0;

        visited();

        return coastLength();
    }

    public void visited() {
        this.isVisited = true;
    }

    protected abstract int coastLength();

    public abstract void addTo(Stack<Square> stack);

    public void removeNeighbor(Square item) {
        neighbors.remove(item);
    }

    public void dropNeighbors() {
        neighbors = new ArrayList<Square>();
    }
}
