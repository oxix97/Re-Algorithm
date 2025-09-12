package programmers.brute_force;

import java.util.ArrayList;
import java.util.List;

public class 외벽점검 {
    List<int[]> perm;
    public int solution(int n, int[] weak, int[] dist) {
        boolean[] visit = new boolean[dist.length];
        int[] w = new int[weak.length * 2];
        for(int i=0;i<weak.length;i++){
            w[i] = weak[i];
            w[i + weak.length] = weak[i] + n;
        }
        for(int i=1;i<=dist.length;i++){
            perm = new ArrayList<>();
            int[] output = new int[i];
            createPermutation(dist,visit,output,0,i);

            for(int[] p : perm){
                for(int j=0;j<weak.length;j++){
                    boolean check = true;
                    int current = 0;
                    int pos = w[j] + p[current];
                    for(int k=j;k<j + weak.length;k++){
                        if(w[k] > pos){
                            current += 1;
                            if(current >= p.length){
                                check = false;
                                break;
                            }
                            pos = w[k] + p[current];
                        }
                    }

                    if(check){
                        return i;
                    }
                }
            }
        }

        return -1;
    }

    void createPermutation(int[] dist, boolean[] visit, int[] output, int dept, int cnt){
        if(dept == cnt){
            perm.add(output.clone());
            return;
        }

        for(int i=0;i<dist.length;i++){
            if(!visit[i]){
                visit[i] = true;
                output[dept] = dist[i];
                createPermutation(dist,visit,output,dept + 1, cnt);
                visit[i] = false;
            }
        }
    }
}
