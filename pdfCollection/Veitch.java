import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Veitch {
	
	public static void main(String[] args)
	{
		while (true)
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a boolean expression with up to 4 variables");
			String input = scan.nextLine();
			String row1 = "";
			String row2 = "";
			String row3 = "";
			String row4 = "";
			
			int num1 = 0;
			int num2 = 0;
			int num3 = 0;
			int num4 = 0;
			
			ArrayList<String> temp = new ArrayList<>(Arrays.asList(input.split("\\+")));
			ArrayList<ArrayList<String>> added = new ArrayList<ArrayList<String>>();
			//Creating Arrays...
			int[][] masterArray = new int[4][4];
			
			
			int[][] varArr1 = new int[4][4];
			
			
			int[][] varArr2 = new int[4][4];

			int[][] varArr3 = new int[4][4];
			
			
			int[][] varArr4 = new int[4][4];
			
			
			int[][] A = new int[4][4];
			A[0][0] = 1;
			A[0][1] = 1;
			A[1][0] = 1;
			A[1][1] = 1;
			A[2][0] = 1;
			A[2][1] = 1;
			A[3][0] = 1;
			A[3][1] = 1;
			int[][] ANot = new int[4][4];
			ANot[0][2] = 1;
			ANot[0][3] = 1;
			ANot[1][2] = 1;
			ANot[1][3] = 1;
			ANot[2][2] = 1;
			ANot[2][3] = 1;
			ANot[3][2] = 1;
			ANot[3][3] = 1;
			int[][] B = new int[4][4];
			B[0][0] = 1;
			B[0][1] = 1;
			B[0][2] = 1;
			B[0][3] = 1;
			B[1][0] = 1;
			B[1][1] = 1;
			B[1][2] = 1;
			B[1][3] = 1;
			int[][] BNot = new int[4][4];
			BNot[2][0] = 1;
			BNot[2][1] = 1;
			BNot[2][2] = 1;
			BNot[2][3] = 1;
			BNot[3][0] = 1;
			BNot[3][1] = 1;
			BNot[3][2] = 1;
			BNot[3][3] = 1;
			int[][] C = new int[4][4];
			C[0][2] = 1;
			C[0][1] = 1;
			C[1][2] = 1;
			C[1][1] = 1;
			C[2][2] = 1;
			C[2][1] = 1;
			C[3][2] = 1;
			C[3][1] = 1;
			int[][] CNot = new int[4][4];
			CNot[0][0] = 1;
			CNot[0][3] = 1;
			CNot[1][0] = 1;
			CNot[1][3] = 1;
			CNot[2][0] = 1;
			CNot[2][3] = 1;
			CNot[3][0] = 1;
			CNot[3][3] = 1;
			int[][] D = new int[4][4];
			D[1][0] = 1;
			D[1][1] = 1;
			D[1][2] = 1;
			D[1][3] = 1;
			D[2][0] = 1;
			D[2][1] = 1;
			D[2][2] = 1;
			D[2][3] = 1;
			int[][] DNot = new int[4][4];
			DNot[0][0] = 1;
			DNot[0][1] = 1;
			DNot[0][2] = 1;
			DNot[0][3] = 1;
			DNot[3][0] = 1;
			DNot[3][1] = 1;
			DNot[3][2] = 1;
			DNot[3][3] = 1;

			
			for(int i = 0; i < temp.size(); i++)
			{
				ArrayList<String> a = new ArrayList<String>();

				added.add(a);
					
				for(int j = 0; j < temp.get(i).length(); j++)
				{
					if(temp.get(i).charAt(j) == '~')
						added.get(i).add("" + temp.get(i).charAt(j) + temp.get(i).charAt(j + 1));
					else if(j == 0 || temp.get(i).charAt(j - 1) != '~')
						added.get(i).add("" + temp.get(i).charAt(j));

				}
			}
			
			for(int i = 0; i < added.size(); i++)
			{
				int[][] tempArr = new int[4][4];
				
				for(int r = 0; r < tempArr.length; r++)
				{
					for(int c = 0; c < tempArr[r].length; c++)
					{
						tempArr[r][c] = 1;
					}
				}
				
				for(int j = 0; j < added.get(i).size(); j++)
				{
					if(added.get(i).get(j).equals("A"))
					{
						for(int r = 0; r < A.length; r++)
						{
							for(int c = 0; c < A[r].length; c++)
							{
								if(A[r][c] == 0)
								{
									tempArr[r][c] = 0;
								}
							}
						}
					}
					
					if(added.get(i).get(j).equals("~A"))
					{
						for(int r = 0; r < ANot.length; r++)
						{
							for(int c = 0; c < ANot[r].length; c++)
							{
								if(ANot[r][c] == 0)
								{
									tempArr[r][c] = 0;
								}
							}
						}
					}
					
					if(added.get(i).get(j).equals("B"))
					{
						for(int r = 0; r < B.length; r++)
						{
							for(int c = 0; c < B[r].length; c++)
							{
								if(B[r][c] == 0)
								{
									tempArr[r][c] = 0;
								}
							}
						}
					}
					
					if(added.get(i).get(j).equals("~B"))
					{
						for(int r = 0; r < BNot.length; r++)
						{
							for(int c = 0; c < BNot[r].length; c++)
							{
								if(BNot[r][c] == 0)
								{
									tempArr[r][c] = 0;
								}
							}
						}
					}
					
					if(added.get(i).get(j).equals("C"))
					{
						for(int r = 0; r < C.length; r++)
						{
							for(int c = 0; c < C[r].length; c++)
							{
								if(C[r][c] == 0)
								{
									tempArr[r][c] = 0;
								}
							}
						}
					}
					
					if(added.get(i).get(j).equals("~C"))
					{
						for(int r = 0; r < CNot.length; r++)
						{
							for(int c = 0; c < CNot[r].length; c++)
							{
								if(CNot[r][c] == 0)
								{
									tempArr[r][c] = 0;
								}
							}
						}
					}
					
					if(added.get(i).get(j).equals("D"))
					{
						for(int r = 0; r < D.length; r++)
						{
							for(int c = 0; c < D[r].length; c++)
							{
								if(D[r][c] == 0)
								{
									tempArr[r][c] = 0;
								}
							}
						}
					}
					
					if(added.get(i).get(j).equals("~D"))
					{
						for(int r = 0; r < DNot.length; r++)
						{
							for(int c = 0; c < DNot[r].length; c++)
							{
								if(DNot[r][c] == 0)
								{
									tempArr[r][c] = 0;
								}
							}
						}
					}
					
				}
				
			
				if(i == 0)
				{
					varArr1 = tempArr;
				}
				else if(i == 1)
				{
					varArr2 = tempArr;
				}
				else if(i == 2)
				{
					varArr3 = tempArr;
				}
				else if(i == 3)
				{
					varArr4 = tempArr;
				}
			}
			
			
			for(int r = 0; r < masterArray.length; r++)
			{
				for(int c = 0; c < masterArray[r].length; c++)
				{
					if(varArr1[r][c] == 1 || varArr2[r][c] == 1 || varArr3[r][c] == 1 || varArr4[r][c] == 1)
					{
						masterArray[r][c] = 1;
					}
				}
			}
			
			for(int r = 0; r < masterArray.length; r++)
			{
				for(int c = 0; c < masterArray[r].length; c++)
				{
					if(r == 0)
					{
						row1 += masterArray[r][c];
					}
					else if(r == 1)
					{
						row2 += masterArray[r][c];
					}
					else if(r == 2)
					{
						row3 += masterArray[r][c];
					}
					else if(r == 3)
					{
						row4 += masterArray[r][c];
					}
				}
			}
			
			if(row1 != "")
				num1 =  Integer.parseInt(row1, 2);
				
			if(row2 != "")
           	 	num2 =  Integer.parseInt(row2, 2);
          
           	if(row3 != "")
            	num3 =  Integer.parseInt(row3, 2);
            	
            if(row4 != "")
				num4 =  Integer.parseInt(row4, 2);
            
            //Find final string and convert answer to hex
           	System.out.println((Integer.toHexString(num1) + Integer.toHexString(num2) + Integer.toHexString(num3) + Integer.toHexString(num4)).toUpperCase());
			
			
		}
	}
}
