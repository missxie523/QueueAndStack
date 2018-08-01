import java.util.Deque;
import java.util.LinkedList;

public class Min {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    public Min(){
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    public Integer pop(){
        if(stack.isEmpty()){
            return null;
        }
        int t = stack.pop();
        if(t == minStack.peek()){
            minStack.pop();
        }
        return t;
    }
    public void push(int ele){
        stack.push(ele);
        if(minStack.isEmpty() || ele <= minStack.peek()){
            minStack.push(ele);
        }
    }
    public Integer min(){
        if(minStack.isEmpty()){
            return null;
        }
        return minStack.peek();
    }
    public static void main(String[] args){
        Min sol = new Min();
        sol.stack = new LinkedList<>();
        sol.minStack = new LinkedList<>();
        sol.push(2);
        sol.push(3);
        sol.push(1);
        sol.push(6);
        sol.push(5);
        sol.push(7);
        sol.push(8);
        sol.push(9);
        System.out.println(sol.min());
    }
}
//Time: O(1)
//Space: O(1)