import java.util.Random;

/**
 * Created by jason_001 on 4/4/2018.
 */
public class test {
    public static String name = "probability";
    public static double sol1 = (double) 1 / 3960;
    public static double sol2 = (double) 1 / 3702;
    public static int count1;
    public static int count2;

    public static void main(String[] args) {
        for(int t = 0; t < 1000; t++) {
            int count = 0;
            for(int i = 0; i < 10000; i++) {
                int b = 0, a = 0, r = 0;
                for (int j = 0; j < 4; j++) {
                    Random ran = new Random();
                    int rand = ran.nextInt(11);
                    switch(name.substring(rand, rand+1)) {
                        case "b":
                            b++;
                            break;
                        case "a":
                            a++;
                            break;
                        case "r":
                            r++;
                            break;
                    }
                }
                if(b == 2 && a == 1 && r == 1) count++;
            }
            double prob = (double) count / 10000;
            if(Math.abs(prob - sol1) > Math.abs(prob - sol2)) count1++;
            else count2++;
        }
        System.out.println(count1 + " " + count2);
    }
}
