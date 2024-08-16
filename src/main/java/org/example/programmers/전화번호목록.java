package org.example.programmers;

import java.util.Arrays;

public class 전화번호목록 {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (o1, o2) -> o1.length() - o2.length());
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = phone_book.length - 1; j > i; j--) {
                if (phone_book[j].startsWith(phone_book[i])) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] phone_books = {
                {"119", "97674223", "1195524421"},
                {"123", "456", "789"},
                {"12", "123", "1235", "567", "88"}
        };
        for (String[] phone_book : phone_books) {
            boolean answer = solution(phone_book);
            System.out.println(answer);
        }
    }
}
