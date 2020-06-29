import java.util.*;

public class NumberTransformation {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		long N;
		long sample;
		long P;

		while(true)
		{
			System.out.println("Enter a positive integer");
			sample = scan.nextLong();
			System.out.println("Enter a position for the integer");
			P = scan.nextLong();
			System.out.println(getOutput(sample,  P));
		}
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