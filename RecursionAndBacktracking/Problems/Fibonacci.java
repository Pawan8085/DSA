package RecursionAndBacktracking.Problems;

public class Fibonacci {
    
    int fib(int n){
        // base case
        if(n <= 1) return n;
        // sum of previous two numbers
        return fib(n-1) + fib(n-2);
    }
}
