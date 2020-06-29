import java.util.Scanner;
import java.util.Arrays;

public class ACSL_Patolli {
	public static int corners[] = {7, 12, 17, 22, 27, 35, 40, 45, 50};
	public static int player[] = new int[3];
	public static int opponent[] = new int[3];
	public static int rolls[];
	public static int currentMarker = 0;
	
	public static boolean tryMove(int n)
	{
		for(int i = 0; i < 3; i++)
		{
			if(player[i] == n)
			{
				return false;
			}
		}
		
		for(int i = 0; i < 3; i++)
		{
			if(opponent[i] == n)
			{
				return false;
			}
		}
		
		return true; 
	}
	
	
 	public static boolean isPrime(int n)
 	{
		int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
		
		for(int i = 0; i < 15; i++)
		{
			if(n == primes[i])
			{
				return true;
			}
		}
		return false;
 	}
 	
 	public static boolean isSquare(int n)
 	{
 		int squares[] = {9, 16, 25, 36, 49};
 		
 		for(int i = 0; i < 5; i++)
 		{
 			if(n == squares[i])
 			{
 				return true;
 			}
 		}
 		return false;
 	}
 	
 	public static boolean passedCorner(int low, int up)
 	{
 		for(int i = 0; i < 9; i++)
 		{
 			if(low < corners[i] && up > corners[i])
 			{
 				return true;
 			}
 		}
 		
 		return false;
 	}
	
	public static void main(String[] args)
	{
	while(true)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter your input");
		int input;
		for(int i = 0; i < 3; i++)
		{
			input = scan.nextInt();
			opponent[i] = input;
		}
		
		for(int i = 0; i < 3; i++)
		{
			input = scan.nextInt();
			player[i] = input;
		}
		
		int numRolls = scan.nextInt();
		System.out.println(numRolls);
		
		rolls = new int[numRolls];
		for(int i = 0; i < numRolls; i++)
		{
			input = scan.nextInt();
			rolls[i] = input;
		}
		
		
		for(int i = 0; i < numRolls; i++)
		{
			
			for(int j = 0; j < 3; j++)
			{
				if(player[j] < player[currentMarker])
				{
					currentMarker = j;
				}
			}
			
			if(tryMove(player[currentMarker] + rolls[i]) && player[currentMarker] + rolls[i] < 52)
			{
				player[currentMarker] = player[currentMarker] + rolls[i];
			
				if(isPrime(player[currentMarker]))
				{
					for(int j = 0; j < 6; j++)
					{
						if(tryMove(player[currentMarker] + 1) && player[currentMarker] + 1 <= 52)
						{
							player[currentMarker] = player[currentMarker] + 1;
						}
					}
				}
				else if(isSquare(player[currentMarker]))
				{
					for(int j = 6; j > 0; j--)
					{
						if(tryMove(player[currentMarker] - 1) && player[currentMarker] - 1 >= 1)
						{
							player[currentMarker] = player[currentMarker] - 1;
						}
					}
				}
				else if(passedCorner(player[currentMarker] - rolls[i], player[currentMarker]))
				{
					for(int j = 0; j < rolls[i] + 1; j++)
					{
						if((tryMove(player[currentMarker] - j) || j == 0) && player[currentMarker] - j >= 1 && (player[currentMarker] - j) % rolls[i] == 0)
						{
							player[currentMarker] = player[currentMarker] - j;
							break;
						}
						else if(j == rolls[i])
						{
							player[currentMarker] = player[currentMarker] - rolls[i];
						}
					}
				}
				
				if(player[currentMarker] == 52)
				{
					player[currentMarker] = 53;
				}
			}
				for(int j = 0; j < 3; j++)
			{
				System.out.print("location: " + player[j] + " ");
			}
			System.out.println();
			System.out.println("roll: " + rolls[i]);
		}
		int count = 0;
		for(int i = 0; i < 3; i++)
		{
			if(player[i] == 53)
			{
				player[i] = 52;
				count++;
			}
		}
		
		if(count == 3)
		{
			System.out.println("GAME OVER");
		}
		else
		{
			Arrays.sort(player);
			for(int i = 0; i < 3; i++)
			{
				System.out.print(player[i] + " ");
			}
		}
	}
}
}
