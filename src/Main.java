import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Input
        int maxCandle = scanner.nextInt();
        scanner.nextLine();

        if (!isMaxCandleValid(maxCandle)) {
            return;
        }
        int[] candles = new int[maxCandle];
        for (int i = 0; i < candles.length; i++) {
            int candleHeight = scanner.nextInt();
            candles[i] = candleHeight;
        }

        if (!isCandlesAreValid(candles)) {
            return;
        }

        List<Integer> candleList = makeCandleListFrom(candles);
        int tallest = birthdayCakeCandlesImperativeSolution(candleList);
        System.out.println(tallest);

    }

    private static List<Integer> makeCandleListFrom(int[] candleArray) {
        List<Integer> candleList = new ArrayList<>();
        for (int candle : candleArray) {
            candleList.add(candle);
        }
        return candleList;
    }

    // Declarative
    public static int birthdayCakeCandles(List<Integer> candles) {
        return Collections.frequency(candles, Collections.max(candles));
    }

    // Imperative
    public static int birthdayCakeCandlesImperativeSolution(List<Integer> candleHeights) {
        int tallestCandleHeight = 0;
        int count = 0;

        for (int index = 0; index < candleHeights.size(); index++) {
            Integer candleHeight = candleHeights.get(index);
            if (candleHeight > tallestCandleHeight) {
                tallestCandleHeight = candleHeight;
                count = 1;
            } else if (candleHeight == tallestCandleHeight) {
                count += 1;
            }
        }
        return count;
    }

    private static Boolean isMaxCandleValid(int maxCandle) {
        return maxCandle >= 1 && maxCandle <= Math.pow(10, 5);
    }

    private static Boolean isCandlesAreValid(int[] candles) {
        for (int candle : candles) {
            return isCandleHeightValid(candle);
        }
        return false;
    }

    private static Boolean isCandleHeightValid(int candleHeight) {
        return candleHeight >= 1 && candleHeight <= Math.pow(10, 7);
    }
}
