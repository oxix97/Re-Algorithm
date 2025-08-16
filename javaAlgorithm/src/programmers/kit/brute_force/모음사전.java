package programmers.kit.brute_force;

public class 모음사전 {
    String[] words = {"A","E","I","O","U"};
    int count = 0;
    int answer = 0;
    boolean find = false;
    public int solution(String word) {
        recursion("",word);

        return answer;
    }

    private void recursion(String word, String target){
        if(find){
            return;
        }
        if(word.equals(target)){
            answer = count;
            find = true;
            return;
        }
        if(word.length() >= 5){
            return;
        }

        for(String w : words){
            count += 1;
            recursion(word + w,target);
        }
    }
}
