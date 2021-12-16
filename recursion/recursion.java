class recursion
{
    public static void main(String[] args) 
    {
            //double a = power(0, -3);
            String s = "hello a";
            //System.out.println(a);
            //System.out.println(fib(5));
            //System.out.println(gcd(10, 125));
            //System.out.println(square(0));
            System.out.println(prime(227, 2));
            System.out.println(reverse(s));
            //5 rows, blank string to concat to, row to start at
            String a = printTriangle(5, 1);
            System.out.println(a);
            //System.out.println(numDigits(128));
            //hailstone(9);
        }
    
        public static double power(double x, int n)
        {
            if(n == 0)
            {
                return 1;
            }
            if(n < 0)
            {
                if(x <= 0)
                {
                    //throw new IllegalArgumentException("can't raise 0 to negative pow or 0");
                }
                return 1 / (x * power(x, Math.abs(n) - 1));
            }
            else
            {
                return x * power(x, n - 1);
            }
        }
    
        public static int fib(int n)
        {
            if(n == 1 || n == 2)
            {
                return 1;
            }
            return fib(n - 1) + fib(n - 2);
        }
    
        public static int gcd(int m, int n)
        {
            /*if(m == n)
            {
                return m;
            }
            else if(m > n)
            {
                return gcd(n, m - n);
            }
            else
            {
                return gcd(n, m);
            }*/
            if(n == 0)
            {
                return m;
            }
            return gcd(n, m % n);
    
    
        }
    
        public static int square(int n)
        {
            if(n < 0)
            {
                n = Math.abs(n);
            }
    
            if(n == 1)
            {
                return 1;
            }
    
            return (square(n - 1) + (2 * n) - 1);
        }
    
        public static boolean prime (int n, int i)
        {
            if(n <= 2)
            {
                return (n == 2) ? true : false;
            }
    
            if(n % i == 0)
            {
                return false;
            }
    
            if(n / 2 == i)
            {
                return true;
            }
            /*
            if(i * i > n)
            {
                return true;
            }
    
             */
    
            return prime(n, i + 1);
        }
    
        public static String reverse(String s)
        {
            if(s.isEmpty() || s.length() <= 1)
            {
                return s;
            }
            //generates the string out backwards
            //makes the last letter of the new string first and passes in the new substring into reverse without the first letter
            return reverse(s.substring(1)) + s.charAt(0);
        }

        public static void printn(int num)
        {
            if (num == 0)
            {
                return;
            }
            System.out.print("* ");
         
            printn(num - 1);
        }
         
        /*public static void printTriangle(int n, int i)
        {
            if (n == 0)
            {
                return;
            }

            printn(i);
            System.out.println();
         
            printTriangle(n - 1, i + 1);
        }*/

        public static String printTriangle(int n, int i)
        {
            String s = "";
            System.out.println(n);
            if (n == 0)
            {
                return "";
            }

            for(int j = i; j > 0; j--)
            {
                s += "*";
            }
            s += "\n";
            //System.out.println("\n" + s + "\n");
            
            return s + printTriangle(n - 1, i + 1);
        }   

        public static int numDigits(int n) 
        {
            if(n == 0)
            {
                return 0;
            }
            return 1 + numDigits(n / 10);
        }

        public static void hailstone(long n)
        {
            System.out.print(n + ", ");
            if(n == 2)
            {
                System.out.println("1");
                return;
            }
            else if(n % 2 == 0)
            {
                hailstone(n / 2);
            }
            else
            {
                hailstone((n * 3) + 1);
            }

        }
}