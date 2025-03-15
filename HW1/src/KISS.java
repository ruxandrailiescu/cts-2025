/*
import java.lang.*;public class KISS {
public static Long f(int n){
    if(n==1||n==0) return 1L;
    else if(n==2)  return 2L;
    else if(n==3)   return 6L;
    else if(n==4) return 24L;
    else if(n==5) return 120L;
    else if(n==6) return 720L;
    else{
    Long s= 1L;for(;;){ s*=n;if(n==1) return s;n--;}
    }

}
public static double p(double x, int n){
    if(n==0) return 1;
    else if (n==1) return x;
    else if (n==2) return x*x;
    else if (n==3) return x*x*x;
    else{
        double s=1;while(true){s*=x;n--;if(n==0) return s;}
    }

}
public static double app(double x, int stop) {
    double s= 0;
    int a =0;
    while(a<stop){s+=(p(x, a)/f(a));a++;}//Hint:Maclaurin
    return s;
}
}
*/

public class KISS {

    // used better naming and included spacing and indentation, together with using wrapper classes
    public static Double calculate(Double exponent) {
        return Math.pow(Math.E, exponent);
        // the previous function uses the Maclaurin series for e^x to approximate the value
        // that is overly complicated and unnecessary, and we can get the value directly from using the Math library
    }

}