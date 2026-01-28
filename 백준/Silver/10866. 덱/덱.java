

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

//55
// Deque
public class Main {
    static Deque<Integer> stack = new ArrayDeque<>();

    static void push_front(Deque<Integer> stack,int x){
        stack.addFirst(x);
    }
    static void push_back(Deque<Integer> stack,int x){
        stack.addLast(x);
    }
    static Integer pop_front(Deque<Integer> stack){
        if(stack.isEmpty()) return -1;
       return stack.removeFirst();
    }
    static Integer pop_back(Deque<Integer> stack){
        if(stack.isEmpty()) return -1;
        return stack.removeLast();
    }
    static Integer size(Deque<Integer> stack){
        return stack.size();
    }
    static Integer empty(Deque<Integer> stack){
        if(stack.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }
    static Integer front(Deque<Integer> stack){
        if(stack.isEmpty()) return -1;
        return stack.peekFirst();
    }
    static Integer back(Deque<Integer> stack){
        if(stack.isEmpty()) return -1;
        return stack.peekLast();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            String str = sc.nextLine();
            String[] strs = str.split(" ");

            if (strs[0].equals("push_front") && strs.length > 1) {
                //System.out.println("here push_front!!!");
                int x = Integer.parseInt(strs[1]);
                push_front(stack,x);
            }else if(strs[0].equals("push_back") && strs.length > 1) {
                //System.out.println("here push_back!!!");
                int x = Integer.parseInt(strs[1]);
                push_back(stack,x);
            }else if(strs[0].equals("pop_front")) {
                System.out.println(pop_front(stack));
            }else if(strs[0].equals("pop_back")) {
                System.out.println(pop_back(stack));
            }else if(strs[0].equals("size")) {
                System.out.println(size(stack));
            }else if(strs[0].equals("empty")) {
                System.out.println(empty(stack));
            }else if(strs[0].equals("front")) {
                System.out.println(front(stack));
            }else if(strs[0].equals("back")) {
                System.out.println(back(stack));
            }
        }

    }
}
