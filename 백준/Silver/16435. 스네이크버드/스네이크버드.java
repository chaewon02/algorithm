
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        ArrayList<Integer> h = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            h.add(sc.nextInt());
        }
        h.sort(null);

        int height = l;
        for (int i = 0; i < h.size(); i++) {
            if(h.get(i)<=height) {
                height +=1;
            }
        }
        System.out.println(height);
    }
}
