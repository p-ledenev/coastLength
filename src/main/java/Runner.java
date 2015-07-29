import java.io.*;
import java.util.*;

/**
 * Created by ledenev.p on 27.07.2015.
 */
public class Runner {

    public static void main(String[] args) throws Throwable {

        Date dateStart = new Date();

        BufferedReader input;

        if (args.length > 0)
            input = new BufferedReader(new FileReader(args[0]));
        else
            input = new BufferedReader(new InputStreamReader(System.in));

        InitialReader reader = new InitialReader(input);
        Square root = reader.read();

        Date dateEnd = new Date();
        System.out.println("Time reading: " + (dateEnd.getTime() - dateStart.getTime()) / 1000. + " sec.");

        Stack<Square> stack = new Stack<Square>();
        stack.push(root);

        int coastLength = 0;
        while (!stack.empty()) {
            Square square = stack.pop();
            coastLength += square.computeCoastLength();

            for (Square item : square.getNeighbors()) {
                item.addTo(stack);
            }
            square.dropNeighbors();
        }

        dateEnd = new Date();
        System.out.println("Time execution: " + (dateEnd.getTime() - dateStart.getTime()) / 1000. + " sec.");

        System.out.println(coastLength);
    }
}
