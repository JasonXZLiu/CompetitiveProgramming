import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jason_001 on 12/22/2017.
 */
public class MicrowaveButtons {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String time = new String(br.readLine()); String[] boop = time.split(":");
        int[] doop = new int[6];
        String allowed = new String(br.readLine()); boolean[] loop = new boolean[10];
        int MIN = Integer.MAX_VALUE; int count = 0; int numTime;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 2; j++) {
                doop[count] = Integer.parseInt(boop[i].substring(j, j+1));
                count++;
            }
        }
        numTime = 3600*(doop[0]*10 + doop[1]) + 60 * (doop[2] * 10 + doop[3]) + (doop[4] * 10) + doop[5];
        for(int i = 0; i < allowed.length(); i++) {
            loop[Integer.parseInt(allowed.substring(i, i+1))] = true;
        }
        String ans = "";
        for(Integer i = 0; i < 10; i++) {
            if(loop[i]) {
                for(Integer j = 0; j < 10; j++) {
                    if(loop[j]) {
                        for(Integer k = 0; k < 10; k++) {
                            if(loop[k]) {
                                for(Integer l = 0; l < 10; l++) {
                                    if(loop[l]) {
                                        for(Integer m = 0; m < 10; m++) {
                                            if(loop[m]) {
                                                for(Integer n = 0; n < 10; n++) {
                                                    if(loop[n]) {
                                                        int A = 3600*(i*10 + j) + 60 * (l * 10 + k) + (m * 10) + n;
                                                        if(MIN > Math.abs(numTime - A)) {
                                                            MIN = Math.abs(numTime - A);
                                                            ans = i.toString() + j.toString() + ":" + l.toString() + k.toString() + ":" + m.toString() + n.toString();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
