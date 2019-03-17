
public class Fibonacci{
	/*
	 * By: Max S.Juarez
	 * Group: Group 8
	 * Questions 4:
	 * cd eclipse-workspace/OperatingSystem/src/
	 * javac Fibonacci.java
	 * java Fibonacci 10 (n) -> 10 being the length of the sequence. 10 -> args
	 */

    private static boolean done = false;						//When  thread is done
    private static class FibonacciThread implements Runnable {	
    	
        private static int[] Sequence;							//empty array
        
        public FibonacciThread(int size) {
        	Sequence = new int[size];							//Sequence is the size pass from user
        	new Thread(this).start();							//Start Thread
        }

        public int fibon(int n) { 
            Sequence[0] = 0; 									//Fib (0) = 0
            Sequence[1] = 1; 									//Fib (1) = 1
            if (n <= 2) {
                return Sequence[2] = 1;							//Fib (2) = Fib (0) + Fib(1) = 1
            }
            for (int j = 2; j <= n; j++) { 						//Start at index [2] = [0]+[1] = 0+1 ..
               Sequence[j] = fibon(j - 2) + fibon(j - 1);		//Algorithm: F0 = 0 + 1 = 1 + 1 = 2 + 1 = 3 + 2 = ... 
            } 
            done = true;										//Fibonacchi algorithm is done
            return Sequence[n]; 								
        } 
         public void run() { 									//When new Thread(this).start(); => calls run() method
        	 while(!done) {										//When not done => do while loop, else terminate
        		 this.fibon(Sequence.length-1);
        	 }
         } 
         public void ArraytoString() {							//Prints out the sequence/array
             System.out.print(Sequence.length);
         	System.out.print("\n[");
 	        for (int x= 0; x<=Sequence.length-1;x++) {
 	        	if(x<Sequence.length-1) {
 		        	System.out.print(Sequence[x] + ", ");
 		        	}
 	        	else{
 			        	System.out.print(Sequence[x]);
 		        	}
 	        	}
         	System.out.print("]");
         }
    } 
    public static void main(String args[]) throws InterruptedException { 
        int n;										//User's integer
        if (args.length<2) {						//if String args[] == "one integer or one word, do this:"
	        try { 
	            n = Integer.parseInt(args[0]); 		//Parse args[] to an integer. Convert from string to integer
	        } catch (Exception e) { 				//if args is not an integer throw exception
	            throw new RuntimeException("\n\t\tError: Please pass in a number/integer!"); 
	        }
	        FibonacciThread thread = new FibonacciThread (n);		//make thread an object of FibonacciThread
	        thread.ArraytoString();					//print out the sequence after fibonacci
	        }
        }
}