package programmers.greedy;

import java.util.*;

public class 불량사용자 {
    String[] user;
    String[] ban;
    Set<Set<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        user = user_id;
        ban = banned_id;
        dfs(0, new HashSet<String>());
        return result.size();
    }

    private void dfs(int idx, Set<String> set){
        if(idx == ban.length){
            result.add(new HashSet<>(set));
            return;
        }

        for(String u : user){
            if(!set.contains(u) && isMatch(u,ban[idx])){
                set.add(u);
                dfs(idx + 1,set);
                set.remove(u);
            }
        }
    }

    private boolean isMatch(String user, String ban){
        if(user.length() != ban.length())
            return false;

        for(int i=0;i<user.length();i++){
            if(ban.charAt(i) == '*') continue;
            if(ban.charAt(i) != user.charAt(i)){
                return false;
            }
        }

        return true;
    }
}
