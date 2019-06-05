import java.util.Scanner; 
class Intersection {
  Scanner sc = new Scanner(System.in);
  double SHIFT = 1000;
  
  //method that calculates quadratic function (double x is used to find intersection point on Y-axis)
  
  double f (double a, double b, double c, double x) {
    return a*x*x+b*x+c;
  }
  
  //method that calculates the discriminanr
  
  double discr(double a,double b, double c) {
    return b*b - 4*a*c;
  }
  
  //method that is used to print rounded up to three decimals numbers
  
  double rnd (double d) {
    return Math.round(d*SHIFT)/SHIFT;}
  
  //method that is used to find bigger root
  
  double solve1(double a, double b, double c) {
    return (b*(-1) + Math.sqrt(discr(a,b,c)))/2*a;
  }
  
   //method that is used to find smaller root
  
  double solve2(double a, double b, double c) {
    return (b*(-1) - Math.sqrt(discr(a,b,c)))/2*a;
  }
  
  //method that calculates linear function (double x is used to find intersection point on Y-axis)
  
  double f2(double p, double q, double x) {
    return p*x + q;}
  
  //finds x root for linear function
  
  double discr2(double a, double b, double c, double p, double q) {
    return (b-p)*(b-p) - 4*a*(c-q);
  }
  
  //finds first x-point intersection
  double point1 (double a, double b, double c, double p, double q) {
    return ((b-p)*(-1) + Math.sqrt(discr2(a,b,c,p,q)))/2*a;
  }
  
  //finds second x-point intersection
  
  double point2 (double a, double b, double c, double p, double q) {
    return ((b-p)*(-1) - Math.sqrt(discr2(a,b,c,p,q)))/2*a;
  }
  
  //finds top x for quadratic function
  
  double topX (double a, double b) {
    return b*(-1)/2*a;
  }
  
  //find top y for quadratic function
  
  double topY (double a, double b, double c) { 
    return f(a,  b, c,  topX(a,b));
  }
  
  void run () {
    double a = sc.nextDouble();
    double b = sc.nextDouble();
    double c = sc.nextDouble();
    double p = sc.nextDouble();
    double q = sc.nextDouble();
    System.out.println("discriminant: "+rnd(discr(a,b,c)));
    if ((discr(a,b,c) > 0)||discr(a,b,c)==0) {
      System.out.println("root: "+rnd(solve1(a,b,c))); //rounds up to 3 decimals
      System.out.println("root: "+rnd(solve2(a,b,c))); //rounds up to 3 decimals
    }
    else { System.out.println("no roots");}
    
    System.out.println("top: ("+ rnd(topX(a,b)) + ", " + rnd(topY(a,b,c))+ ")");
    System.out.println("intersection point: (" + rnd(point1(a,b,c,p,q)) + ", " + rnd(f2(p,q,point1(a,b,c,p,q)))+ ")");
    System.out.println("intersection point: (" + rnd(point2(a,b,c,p,q)) + ", " + rnd(f2(p,q,point2(a,b,c,p,q)))+ ")");
  }
  public static void main (String[] args) {
    
    new Intersection().run();}
}