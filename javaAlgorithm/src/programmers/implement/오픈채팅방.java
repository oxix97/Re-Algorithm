package programmers.implement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        Map<String,String> map = new HashMap<>();
        List<Record> result = new ArrayList<>();

        for(String str : record){
            String[] s = str.split(" ");
            String cmd = s[0];
            String user = s[1];

            if(cmd.equals("Enter")){
                map.put(user,s[2]);
                result.add(new Record(cmd,user));
            }else if(cmd.equals("Change")){
                map.put(user,s[2]);
            }else{
                result.add(new Record(cmd,user));
            }
        }

        return result.stream()
                .map(it->{
                    String nickname = map.get(it.user);
                    if(it.cmd.equals("Enter")){
                        return nickname + "님이 들어왔습니다.";
                    }
                    return nickname + "님이 나갔습니다.";
                })
                .toArray(String[]::new);
    }

    class Record{
        String cmd;
        String user;

        public Record(String cmd, String user){
            this.cmd = cmd;
            this.user = user;
        }
    }
}
