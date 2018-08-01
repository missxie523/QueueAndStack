import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueByTwoStacks {
    Deque<Integer> in;
    Deque<Integer> out;
    public QueueByTwoStacks(){
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }
    private void shuffle(){
        if(out.isEmpty()){
            out.offerLast(in.pollLast());
        }
    }
    public Integer poll(){
        shuffle();
        if(out.isEmpty()){
            return null;
        }
        return out.pollLast();
    }
    public void offer(int ele){
        in.offerLast(ele);
    }
    public Integer peek(){
        shuffle();
        if(out.isEmpty()){
            return null;
        }
        return out.peekLast();
    }
    public int size(){
        return in.size() + out.size();
    }
    public boolean isEmpty(){
        return in.isEmpty() && out.isEmpty();
    }
    public static void main(String[] args){
        QueueByTwoStacks sol = new QueueByTwoStacks();
        sol.in = new LinkedList<>();
        sol.out = new LinkedList<>();
        sol.offer(2);
        sol.offer(3);
        sol.offer(1);
        sol.offer(6);
        sol.offer(5);
        sol.offer(7);
        sol.offer(8);
        sol.offer(9);
        System.out.println(sol.size());
        System.out.println(sol.peek());
        System.out.println(sol.poll());
        System.out.println(sol.poll());
        System.out.println(sol.poll());
        System.out.println(sol.isEmpty());
        System.out.println(sol.poll());
        System.out.println(sol.poll());
        System.out.println(sol.size());
        System.out.println(sol.poll());
        System.out.println(sol.poll());
        System.out.println(sol.poll());
        System.out.println(sol.poll());
        System.out.println(sol.poll());
        System.out.println(sol.isEmpty());
    }
}
/*
Time Complexity:
offer(): O(1)
poll(): O(1)
Shuffle    pop
O(n)       O(n)
---------------
      n
= O(2) = O(1)
offer, size, isEmpty (worst case): O(1)
poll, peek: amortized O(1); worst case: O(n)
Space Complexity: O(n)
 */