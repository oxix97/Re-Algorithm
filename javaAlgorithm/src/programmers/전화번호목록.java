package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 전화번호목록 {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (o1, o2) -> o1.length() - o2.length());
        Set<String> set = new HashSet<>();
        for (String phone : phone_book) {
            for (int i = 1; i <= phone.length(); i++) {
                if (set.contains(phone.substring(0, i)))
                    return false;
            }
            set.add(phone);
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] phone_books = {
                {"119", "97674223", "1195524421"},
                {"123", "456", "789"},
                {"1235", "123", "12", "567", "88"}
        };
        for (String[] phone_book : phone_books) {
            boolean answer = solution(phone_book);
            System.out.println(answer);
        }
    }
}
