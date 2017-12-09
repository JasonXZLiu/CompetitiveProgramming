import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Friend[] friends = new Friend[N+1];
        for (int i = 0; i <= N; i++) {
            friends[i] = new Friend();
            friends[i].invited = new ArrayList<>();
        }
        for (int i = 1; i <= N - 1; i++) {
            int a = Integer.parseInt(br.readLine());
            friends[a - 1].invitedNum++;
            friends[a - 1].invited.add(friends[i]);
        }
        int total = 1;
        for (int i = 1; i <= N - 1; i++) {
            int a = friends[i].invitedNum;
            total = total * (a + 2) / (a + 1);
            for(Friend f: friends[a].invited) {
                if(f.invitedNum != 0) {
                    total = total / ((friends[i].invitedNum + 2) / (f.invitedNum + 1));
                }
            }
        }
        System.out.println(total);
    }

    static class Friend {
        public int invitedNum;
        public ArrayList<Friend> invited;
    }
}