import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> ropes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ropes.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(ropes);

        int max = Integer.MIN_VALUE;
        for (int i = 0, s = ropes.size(); i < ropes.size(); i++, s--) {
            if (max < ropes.get(i) * s) {
                max = ropes.get(i) * s;
            }
        }
        System.out.println(max);

    }
}