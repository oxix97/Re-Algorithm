package programmers.kit.sort;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class H_Index {
    public static void main(String[] args) {
        int[] answer = new int[5];
        answer[3] = 15;
        int n  = IntStream.of(answer)
                .max()
                .getAsInt();
        System.out.println(n);

    }
}
