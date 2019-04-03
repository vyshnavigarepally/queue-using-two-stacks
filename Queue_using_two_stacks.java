import java.util.*;

class Queue_using_two_stacks<E> {
    
    Stack<E> stack1;
    Stack<E> stack2;
    
    public Queue_using_two_stacks() {
        this.stack1 = new Stack<E>();
        this.stack2 = new Stack<E>();
    }
   public void push(E x) {
        stack1.push(x);
    }
   public void pop() {
       if(stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
       stack2.pop();
    }
   public Object peek() {
        
        Object peek;
        if(stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
   return stack2.peek();
    }
    
    public static void main(String[] args) {
    	Queue_using_two_stacks<Integer> queue = new Queue_using_two_stacks<Integer>();
        
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
            for(int i = 0; i < q; i++) {
            int queryType = scanner.nextInt();
            
            if(queryType == 1) {
                int x = scanner.nextInt();
                queue.push(x);
            }
            
            else if(queryType == 2) {
                queue.pop();
            }
             else { 
                System.out.println( queue.peek() );
            }
        }
        scanner.close();
    }
}