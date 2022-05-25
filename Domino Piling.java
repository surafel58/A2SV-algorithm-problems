import java.util.*;
public class DominoPiling
{
	public static int getMaxDomino(int M, int N)
	{
		int max = (M*N)/2;
		return max;
	}
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);
		int M = read.nextInt();
		int N = read.nextInt();
		System.out.println(getMaxDomino(M, N));
	}
}