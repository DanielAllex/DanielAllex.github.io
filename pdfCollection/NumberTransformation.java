import java.util.*;

public class NumberTransformation {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		long N;
		long sample1;
		long sample2;
		long sample3;
		long sample4;
		long sample5;
		long P1;
		long P2;
		long P3;
		long P4;
		long P5;
			
		System.out.println("Enter a positive integer");
		sample1 = scan.nextLong();
		System.out.println("Enter a position for the integer");
		P1 = scan.nextLong();
		System.out.println(getOutput(sample1,  P1));

		System.out.println("Enter a positive integer");
		sample2 = scan.nextLong();
		System.out.println("Enter a position for the integer");
		P2 = scan.nextLong();

		System.out.println(getOutput(sample2,  P2));

		
		System.out.println("Enter a positive integer");
		sample3 = scan.nextLong();
		System.out.println("Enter a position for the integer");
		P3 = scan.nextLong();

		System.out.println(getOutput(sample3,  P3));

		
		System.out.println("Enter a positive integer");
		sample4 = scan.nextLong();
		System.out.println("Enter a position for the integer");
		P4 = scan.nextLong();

		System.out.println(getOutput(sample4,  P4));

		
		System.out.println("Enter a positive integer");
		sample5 = scan.nextLong();
		System.out.println("Enter a position for the integer");
		P5 = scan.nextLong();
		
		System.out.println(getOutput(sample5,  P5));

			}
	
	public static String getOutput(long N, long P)
	{
		String copyN = "" + N;
		long[] arrayN = new long[copyN.length()];
		String newN = "";
		
		for(int i = 0; i < copyN.length(); i++)
		{
			arrayN[i] = Character.getNumericValue(copyN.charAt(i));
		}
		
		int newP = (int) (arrayN.length - P);
		
		for(int i = 0; i < arrayN.length; i++)
		{
			if(i < newP)
			{
				arrayN[i] = arrayN[i] + arrayN[newP];
			}
			else if(i > newP)
			{
				arrayN[i] = (long)Math.abs(arrayN[i] - arrayN[newP]);
			}
			
			if(arrayN[i] >= 10)
			{
				arrayN[i] = arrayN[i] - 10;
			}
			
			newN = newN + arrayN[i];
		}
		
		return newN;
		
	}
}