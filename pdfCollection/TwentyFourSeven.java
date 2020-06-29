import java.util.ArrayList;

public class TwentyFourSeven {
	static int[][] grid = new int[7][7];
	static ArrayList<ArrayList<ArrayList<Integer>>> AdjList = new ArrayList<ArrayList<ArrayList<Integer>>>();
	// Node
			//Points (first = Node)
					//r, c
	
	static ArrayList<ArrayList<ArrayList<Integer>>> notFound;
	static ArrayList<Integer> openSpaces = new ArrayList<Integer>();

	public static int countNum(int x)
	{
		int count = 0;
		
		for(int r = 0; r < grid.length; r++)
		{
			for(int c = 0; c < grid[0].length; c++)
			{
				if(grid[r][c] == x)
				{
					count++;
				}
			}
		}
		return count;
	}
	
	public static int countRow(int r)
	{
		int count = 0;
		
		for(int c = 0; c < grid[0].length; c++)
		{
			if(grid[r][c] != 0)
			{
				count++;
			}
		}
		
		return count;
	}
	
	public static int countColumn(int c)
	{
		int count = 0;
		
		for(int r = 0; r < grid.length; r++)
		{
			if(grid[r][c] != 0)
			{
				count++;
			}
		}
		
		return count;
	}
	
	public static int sumRow(int r)
	{
		int sum = 0;
		
		for(int c = 0; c < grid[0].length; c++)
		{
			if(grid[r][c] != 0)
			{
				sum += grid[r][c];
			}
		}
		
		return sum;
	}
	
	public static int sumColumn(int c)
	{
		int sum = 0;
		
		for(int r = 0; r < grid.length; r++)
		{
			if(grid[r][c] != 0)
			{
				sum += grid[r][c];
			}
		}
		
		return sum;
	}
	
	public static void tryPath(int r, int c)
	{
		if(notFound.size() == 0)
		{
			return;
		}
		
		boolean found = false;
		
		for(int i = 0; i < notFound.size(); i++)
		{
			if(notFound.get(i).get(0).get(0) == r && notFound.get(i).get(0).get(1) == c )
			{
				notFound.remove(i);
				found = true;
				break;
			}
		}
		if(!found)
			return;
				
		for(int i = 0; i < AdjList.size(); i++)
		{
			if(AdjList.get(i).get(0).get(0) == r && AdjList.get(i).get(0).get(1) == c)
			{
				for(int j = 1; j < AdjList.get(i).size(); j++)
				{
					tryPath(AdjList.get(i).get(j).get(0), AdjList.get(i).get(j).get(1));
				}
			}
		}
	}
	
	public static boolean checkConnectedness()
	{
		//System.out.println("Checking connectedness...");
		AdjList = new ArrayList<ArrayList<ArrayList<Integer>>>();
		notFound = new ArrayList<ArrayList<ArrayList<Integer>>>();
		for(int r = 0; r < grid.length; r++)
		{
			for(int c = 0; c < grid[0].length; c++)
			{
				if(grid[r][c] != 0)
				{
					ArrayList<ArrayList<Integer>> points = new ArrayList<ArrayList<Integer>>();
					ArrayList<Integer> first = new ArrayList<Integer>();
					first.add(r);
					first.add(c);
					points.add(first);
					
					if(r + 1 < 7)
					{
						if(grid[r + 1][c] != 0)
						{
							ArrayList<Integer> newPoint = new ArrayList<Integer>();
							newPoint.add(r + 1);
							newPoint.add(c);
							points.add(newPoint);
						}
					}
					if(r - 1 > -1)
					{
						if(grid[r - 1][c] != 0)
						{
							ArrayList<Integer> newPoint = new ArrayList<Integer>();
							newPoint.add(r - 1);
							newPoint.add(c);
							points.add(newPoint);
						}
					}
					if(c + 1 < 7)
					{
						if(grid[r][c + 1] != 0)
						{
							ArrayList<Integer> newPoint = new ArrayList<Integer>();
							newPoint.add(r);
							newPoint.add(c + 1);
							points.add(newPoint);
						}
					}
					if(c - 1 > -1)
					{
						if(grid[r][c - 1] != 0)
						{
							ArrayList<Integer> newPoint = new ArrayList<Integer>();
							newPoint.add(r);
							newPoint.add(c - 1);
							points.add(newPoint);
						}
					}
					
					AdjList.add(points);

				}
			}
		}
		
		notFound = (ArrayList<ArrayList<ArrayList<Integer>>>)AdjList.clone();
		
		int firstColumn = 1;
		
		if(grid[0][0] != 0)
		{
			firstColumn = 0;
		}

		tryPath(0, firstColumn);
		return notFound.size() == 0;
	}
	
	public static boolean incompleteSquares()
	{
		for(int r = 0; r < grid.length; r++)
		{
			for(int c = 0; c < grid[0].length; c++)
			{
				if(grid[r][c] != 0)
				{
					int strikesTL = 0;
					int strikesTR = 0;
					int strikesBL = 0;
					int strikesBR = 0;

					if(r + 1 < 7)
					{
						if(grid[r + 1][c] != 0)
						{
							strikesBL++;
							strikesBR++;
						}
					}
					if(r - 1 > -1)
					{
						if(grid[r - 1][c] != 0)
						{
							strikesTL++;
							strikesTR++;
						}
					}
					if(c + 1 < 7)
					{
						if(grid[r][c + 1] != 0)
						{
							strikesTR++;
							strikesBR++;
						}
					}
					if(c - 1 > -1)
					{
						if(grid[r][c - 1] != 0)
						{
							strikesTL++;
							strikesBL++;
						}
					}
					if(r + 1 < 7 && c + 1 < 7)
					{
						if(grid[r + 1][c + 1] != 0)
						{
							strikesBR++;
						}
					}
					if(r + 1 < 7 && c - 1 > -1)
					{
						if(grid[r + 1][c - 1] != 0)
						{
							strikesBL++;
						}
					}
					if(r - 1 > -1 && c + 1 < 7)
					{
						if(grid[r - 1][c + 1] != 0)
						{
							strikesTR++;
						}
					}
					if(r - 1 > -1 && c - 1 > -1)
					{
						if(grid[r - 1][c - 1] != 0)
						{
							strikesTL++;
						}
					}
					
					if(strikesTL == 3 || strikesTR == 3 || strikesBL == 3 || strikesBR == 3)
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static boolean tryRand(int x, int r, int c)
	{
		if(countNum(x) > x)
		{
			return false;
		}
		else if(sumRow(r) > 20 || sumColumn(c) > 20)
		{
			return false;
		}
		else if(countRow(r) == 4 && sumRow(r) != 20)
		{
			return false;
		}
		else if(countColumn(c) == 4 && sumColumn(c) != 20)
		{
			return false;
		}
		else if(!incompleteSquares())
		{
			return false;
		}
		else
			return true;
	}
	
	public static boolean isDone()
	{
		for(int i = 1; i < 8; i++)
		{
			if(countNum(i) != i)
			{
				return false;
			}
		}
		
		for(int i = 0; i < grid.length; i++)
		{
			if (!(countRow(i) == 4 && countColumn(i) == 4 && sumRow(i) == 20 && sumColumn(i) == 20))
			{
				return false;
			}
		}
		
		if(!checkConnectedness() || !incompleteSquares())
		{
			return false;
		}
		
		return true;
	}
	
	public static boolean canContinue()
	{
		if(openSpaces.size() == 0)
		{
			return false;
		}
		
		for(int i = 0; i < grid.length; i++)
		{
			if(countRow(i) == 4 && sumRow(i) != 20 || countRow(i) != 4 && sumRow(i) == 20 || countColumn(i) == 4 && sumColumn(i) != 20 || countColumn(i) != 4 && sumColumn(i) == 20)
			{
				return false;
			}
			
			if (!(countRow(i) == 4 && countColumn(i) == 4 && sumRow(i) == 20 && sumColumn(i) == 20))
			{
				return true;
			}
		}
		
		for(int i = 1; i < 8; i++)
		{
			if(countNum(i) < i)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static void removeOptions()
	{
		for(int i = 0; i < grid.length; i++)
		{
			if (countRow(i) >= 4)
			{
				for(int j = 0; j < openSpaces.size(); j++)
				{
					if((int)openSpaces.get(j) / 10 == i)
					{
						openSpaces.remove(j);
						j--;
					}
				}
			}
			if(countColumn(i) >= 4)
			{
				for(int j = 0; j < openSpaces.size(); j++)
				{
					if(openSpaces.get(j) % 10 == i)
					{
						openSpaces.remove(j);
						j--;
					}
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		
		for(int r = 0; r < grid.length; r++)
		{
			for(int c = 0; c < grid[0].length; c++)
			{
				grid[r][c] = 0;
			}
		}
		
		//Set Values
		grid[0][1] = 4;
		grid[1][2] = 6;
		grid[1][3] = 3;
		grid[1][6] = 6;
		grid[2][5] = 5;
		grid[2][6] = 5;
		grid[3][3] = 4;
		grid[4][0] = 4;
		grid[4][1] = 7;
		grid[5][0] = 2;
		grid[5][3] = 7;
		grid[5][4] = 4;
		grid[6][5] = 1;
		
		for(int r = 0; r < grid.length; r++)
		{
			for(int c = 0; c < grid[0].length; c++)
			{
				if(grid[r][c] == 0)
				{
					openSpaces.add(r * 10 + c);
				}
			}
		}
		
		while(!isDone())
		{
			removeOptions();

			if(canContinue())
			{				
				int randSpot = (int) (Math.random() * openSpaces.size());
				int chosenNum = openSpaces.get(randSpot);
				int row = (int) chosenNum / 10;
				int column = chosenNum % 10;
				
				int rowMax = 7;
				int columnMax = 7;
				int rowMin = 1;
				int columnMin = 1;
				int randNum = 0;
				boolean success = false;
				boolean changed = false;
				ArrayList<Integer> options = new ArrayList<Integer>();

				if(countRow(row) == 1)
				{
					rowMin = 6 - sumRow(row);
					rowMax = 7;
					if(rowMin < 1)
					{
						rowMin = 1;
					}
				}
				
				if(countRow(row) == 2)
				{
					rowMin = 13 - sumRow(row);
					rowMax = 7;
					if(rowMin < 1)
					{
						rowMin = 1;
					}
				}
				
				if(countRow(row) == 3)
				{
					rowMax = 20 - sumRow(row);
					rowMin = 20 - sumRow(row);
					if(rowMin < 1 || rowMax < 1)
					{
						rowMin = 1;
						rowMax = 1;
					}
					if(rowMax > 7 || rowMin > 7)
					{
						rowMin = 7;
						rowMax = 7;
					}
				}
				
				if(countColumn(column) == 1)
				{
					columnMin = 6 - sumColumn(row);
					columnMax = 7;
					if(columnMin < 1)
					{
						columnMin = 1;
					}
				}
				
				if(countColumn(column) == 2)
				{
					columnMin = 13 - sumColumn(column);
					columnMax = 7;
					if(columnMin < 1)
					{
						columnMin = 1;
					}
				}
				
				if(countColumn(column) == 3)
				{
					columnMax = 20 - sumColumn(column);
					columnMin = 20 - sumColumn(column);
					if(columnMin < 1 || columnMax < 1)
					{
						columnMin = 1;
						columnMax = 1;
					}
					if(columnMax > 7 || columnMin > 7)
					{
						columnMin = 7;
						columnMax = 7;
					}
				}
				
				if(countColumn(column) == 3 && countRow(row) == 3 && sumColumn(column) != sumRow(row))
				{
					openSpaces.remove(randSpot);
					changed = true;
				}
				
				
				if(randNum != 0 && !changed)
				{
					grid[row][column] = randNum;
				}
				else
				{
					for(int i = (int)Math.max(rowMin, columnMin); i < (int)Math.min(rowMax, columnMax) + 1; i++)
					{
						options.add(i);
					}
					while(!success && options.size() > 0)
					{
						int randIndex = (int)(Math.random() * options.size());
						randNum = options.get(randIndex);
						grid[row][column] = randNum;
						if(tryRand(randNum, row, column))
						{
							success = true;
							openSpaces.remove(randSpot);
						}
						else
						{
							grid[row][column] = 0;
							options.remove(randIndex);
						}
					}
					if(options.size() == 0)
					{
						if(!changed)
							openSpaces.remove(randSpot);
					}
				}
				if(isDone())
				{
					System.out.println("Completed!");
					for(int r = 0; r < grid.length; r++)
					{
						System.out.println();
						for(int c = 0; c < grid[0].length; c++)
						{
							System.out.print(grid[r][c]);
						}
					}
					System.out.println();
				}
				else
				{
					for(int r = 0; r < grid.length; r++)
					{
						System.out.println();
						for(int c = 0; c < grid[0].length; c++)
						{
							System.out.print(grid[r][c]);
						}
					}
					System.out.println();
					System.out.println(openSpaces);
				}
			}
			else
			{
				System.out.println("Backing up grid");
				for(int r = 0; r < grid.length; r++)
				{
					for(int c = 0; c < grid[0].length; c++)
					{
						grid[r][c] = 0;
					}
				}
				
				//Set Values
				grid[0][1] = 4;
				grid[1][2] = 6;
				grid[1][3] = 3;
				grid[1][6] = 6;
				grid[2][5] = 5;
				grid[2][6] = 5;
				grid[3][3] = 4;
				grid[4][0] = 4;
				grid[4][1] = 7;
				grid[5][0] = 2;
				grid[5][3] = 7;
				grid[5][4] = 4;
				grid[6][5] = 1;
				
				openSpaces = new ArrayList<Integer>();
				
				for(int r = 0; r < grid.length; r++)
				{
					for(int c = 0; c < grid[0].length; c++)
					{
						if(grid[r][c] == 0)
						{
							openSpaces.add(r * 10 + c);
						}
					}
				}
			}
		}
	}
}
