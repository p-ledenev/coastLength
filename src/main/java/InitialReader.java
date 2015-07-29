import java.io.*;
import java.util.*;

/**
 * Created by ledenev.p on 27.07.2015.
 */
public class InitialReader {

    private List<String> lines;
    private int linesAmount;
    private int columnsAmount;

    public InitialReader(BufferedReader reader) throws Throwable {

        String[] params = reader.readLine().split(" ");
        linesAmount = Integer.parseInt(params[0]) + 2;
        columnsAmount = Integer.parseInt(params[1]) + 2;

        lines = new ArrayList<String>();

        lines.add(new String(new char[columnsAmount]).replace("\0", "0"));

        String line;
        while ((line = reader.readLine()) != null)
            lines.add("0" + line + "0");

        lines.add(new String(new char[columnsAmount]).replace("\0", "0"));
    }

    public Square read() throws Throwable {

        List<Square> result = new ArrayList<Square>(4004);
        List<Square> previous = new ArrayList<Square>(1002);

        for (int i = 0; i < linesAmount; i++) {

            List<Square> current = new ArrayList<Square>(1002);

            String line = lines.get(i);
            for (int j = 0; j < columnsAmount; j++) {

                Square square = createSquare(line.charAt(j));

                if (previous.size() > 0) {
                    Square item = previous.get(j);
                    item.addNeighbor(square);
                    square.addNeighbor(item);
                }

                if (j > 0) {
                    Square item = current.get(j - 1);
                    item.addNeighbor(square);
                    square.addNeighbor(item);
                }

                if ((j == 0 || j == columnsAmount - 1) && i != 0 && i != linesAmount - 1) {
                    result.add(square);
                }

                current.add(square);
            }

            if (i == 0 || i == linesAmount - 1)
                result.addAll(current);

            previous = current;
        }

        Square square = Square.water();
        square.setNeighbors(result);

        return square;
    }

    private Square createSquare(char c) {

        if (Integer.parseInt(Character.toString(c)) == 0)
            return Square.water();

        return Square.land();
    }
}
