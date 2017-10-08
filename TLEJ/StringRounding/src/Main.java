import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        String a = in.next();
        boolean b = true;
        int cnt = a.length()-1;
        String[] str = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 0);
        map.put("b", 1);
        map.put("c", 2);
        map.put("d", 3);
        map.put("e", 4);
        map.put("f", 5);
        map.put("g", 6);
        map.put("h", 7);
        map.put("i", 8);
        map.put("j", 9);
        map.put("k", 10);
        map.put("l", 11);
        map.put("m", 12);
        map.put("n", 13);
        map.put("o", 14);
        map.put("p", 15);
        map.put("q", 16);
        map.put("r", 17);
        map.put("s", 18);
        map.put("t", 19);
        map.put("u", 20);
        map.put("v", 21);
        map.put("w", 22);
        map.put("x", 23);
        map.put("y", 24);
        map.put("z", 25);
        while(b) {
            if(cnt > 0) {
                if (binarySearch(map.get(a.substring(cnt, cnt + 1)))) {
                    a = a.substring(0, cnt) + "a";
                    b = false;
                }
                else {
                    if(!(map.get(a.substring(cnt - 1, cnt)) == 25)) {
                        b = false;
                        a = a.substring(0, cnt - 1) + str[map.get(a.substring(cnt - 1, cnt)) + 1] + "a";
                        cnt--;
                    } else {
                        a = a.substring(0, cnt) + "a";
                        cnt--;
                    }
                }
            } else if (cnt == 0) {
                if(!binarySearch(map.get(a.substring(cnt, cnt + 1)))) {
                    a = "a";
                    cnt--;
                }
            } else {
                a += "a";
                b = false;
            }
        }
        System.out.println(a);
    }

    public static boolean binarySearch(int a) {
        if(a <= 12) return true;
        else return false;
    }
}
