import java.util.*;
import java.lang.Math.*;
 
public class TheatreSquare
{
	public static void getMaxStones(double n, double m, double a)
	{
		double maxN = Math.ceil(n/a);
		double maxM = Math.ceil(m/a);
		double result = maxN * maxM;
		System.out.println(Math.round(result));
	}
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);
		int n = read.nextInt();
		int m = read.nextInt();
		int a = read.nextInt();
		getMaxStones(n,m,a);
	}
}