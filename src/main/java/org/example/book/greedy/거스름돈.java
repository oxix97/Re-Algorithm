package org.example.book.greedy;


public class 거스름돈 {
    public static void main(String[] args) {
        int n = 1260;
        int count = 0;
        int[] coin_types = {500, 100, 50, 10};

        for (int coin : coin_types) {
            count += n / coin;
            n %= coin;
        }
        System.out.println(count);
    }
}

