import java.util.ArrayList;
import java.util.Scanner;

public class SamenessFactor {
	
	public static ArrayList<ArrayList<Character>> step1(ArrayList<Character> a, ArrayList<Character> b)
	{
		for(int i = 0; i < a.size() && i < b.size(); i ++)
		{
			if(a.get(i).equals(b.get(i)))
			{
				a.remove(i);
				b.remove(i);
				i--;
			}
		}
		ArrayList<ArrayList<Character>> product = new ArrayList<ArrayList<Character>>();
		product.add(a);
		product.add(b);
		return product;
	}
	
	public static ArrayList<ArrayList<Character>> step2(ArrayList<Character> a, ArrayList<Character> b)
	{
		for(int i = 0; i < a.size() && i < b.size(); i ++)
		{
			if(!checkStep1(a,b))
			{
				if(i + 1 < b.size() && a.get(i).equals(b.get(i + 1)))
				{
					b.remove(i);
					i--;
				}
			}
			if(!checkStep1(a,b))
			{
				if(i + 1 < a.size() && b.get(i).equals(a.get(i + 1)))
				{
					a.remove(i);
					i--;
				}
			}
		}
		ArrayList<ArrayList<Character>> product = new ArrayList<ArrayList<Character>>();
		product.add(a);
		product.add(b);
		return product;
	}
	
	public static boolean checkStep1(ArrayList<Character> a, ArrayList<Character> b)
	{		
		for(int i = 0; i < a.size() && i < b.size(); i ++)
		{
			if(a.get(i).equals(b.get(i)))
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkStep2(ArrayList<Character> a, ArrayList<Character> b)
	{
		for(int i = 0; i < a.size() && i < b.size(); i ++)
		{
			if(i + 1 < b.size() && a.get(i).equals(b.get(i + 1)))
			{
				return true;
			}
			if(i + 1 < a.size() && b.get(i).equals(a.get(i + 1)))
			{
				return true;
			}
		}
		return false;
	}
	
	public static int getASF(ArrayList<Character> a, ArrayList<Character> b)
	{
		int temp = 0;
		if(a.size() > b.size())
		{
			for(int i = 0; i < a.size(); i++)
			{
				if(i < b.size())
					temp = temp + ((int)a.get(i) - (int)b.get(i));
				else
					temp = temp + 1;
			}

		}
		else
		{
			for(int i = 0; i < b.size(); i++)
			{
				if(i < a.size())
					temp = temp + ((int)a.get(i) - (int)b.get(i));
				else
				{
					temp = temp + 1;
				}

			}
		}
		return temp;
	}
	
	public static void main(String[] args)
	{
		while (true)
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a string");
			String input = scan.nextLine();
			int ASF = 0;
			String part1 = input.substring(0, input.indexOf(" "));
			String part2 = input.substring(input.indexOf(" ") + 1, input.length());
			ArrayList<Character> letters1 = new ArrayList<Character>();
			ArrayList<Character> letters2 = new ArrayList<Character>();
			for(int i = 0; i < part1.length(); i++)
			{
				letters1.add(part1.charAt(i));
			}
			
			for(int i = 0; i < part2.length(); i++)
			{
				letters2.add(part2.charAt(i));
			}
			
			while(checkStep1(letters1, letters2) || checkStep2(letters1, letters2))
			{
				ArrayList<ArrayList<Character>> packaged = new ArrayList<ArrayList<Character>>();
				packaged = step1(letters1, letters2);
				letters1 = packaged.get(0);
				letters2 = packaged.get(1);
				
				ArrayList<ArrayList<Character>> packaged2 = new ArrayList<ArrayList<Character>>();
				packaged2 = step2(letters1, letters2);
				letters1 = packaged2.get(0);
				letters2 = packaged2.get(1);
			}
			System.out.println(getASF(letters1, letters2));
		}
	}
}
