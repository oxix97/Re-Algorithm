package programmers;

public class 문자열압축 {
    public static void main(String[] args) {
        int a1 = solution("abcabcdede");
        int a2 = solution("a");
        System.out.println(a1);
        System.out.println(a2);
    }

    public static int solution(String s) {
        //한자리 수 문자 대응
        if (s.length() == 1) return 1;

        int answer = 1000; // 최대 길이 -> 기본값

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0, i);    // 기준 문자
            int count = 1;
            for (int j = i; j <= s.length(); j += i) {
                int end = Math.min(j + i, s.length());  //최대 길이를 인덱스가 넘을 수 없음
                String compare = s.substring(j, end);   //비교 대상
                if (base.equals(compare)) { // 압축 가능한 문자
                    ++count;
                } else {
                    if (count >= 2) {   // 압축된 문자 개수 정산
                        sb.append(count);
                    }
                    sb.append(base);    // 문자열 추가
                    base = compare; //다음 문자열이 기준
                    count = 1;  //초기화
                }
            }
            sb.append(base);    //마지막 문자 추가
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
