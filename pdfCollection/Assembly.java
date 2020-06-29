import java.util.ArrayList;
import java.util.Scanner;
public class Assembly {
	
	public static String[] opcodes = {"LOAD", "STORE", "ADD", "SUB", "MULT", "DIV", "BE", "BG", "BL", "BU", "END", "READ", "PRINT", "DC"};
	public static ArrayList<String[]> cmds = new ArrayList<String[]>();
	public static ArrayList<String[]> vars = new ArrayList<String[]>();
	public static String[] acc = {"ACC", "0"};
	
	public static int getValfromVar(String var)
	{
		for(int i = 0; i < vars.size(); i++)
		{
			if(vars.get(i)[0].equals(var))
			{
				return Integer.parseInt(vars.get(i)[1]);
			}
		}
		return Integer.parseInt(var);
	}
	
	public static void updateVal(String var, int val)
	{
		boolean didSomething = false;
		for(int i = 0; i < vars.size(); i++)
		{
			if(vars.get(i)[0].equals(var))
			{
				vars.get(i)[1] = "" + val;
				didSomething = true;
			}
		}
		
		if(didSomething == false)
		{
			String[] tempVar = {var, "" + val};
			vars.add(tempVar);
		}
	}
	
	public static int findBranch(String label)
	{
		for(int i = 0; i < cmds.size(); i++)
		{
			if(cmds.get(i)[0].equals(label))
			{
				return i;
			}
		}
		return 0;
	}
	
	public static void main(String[] args)
	{
		vars.add(acc);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter ACSL Assembly");
		boolean done = false;
		
		while(done == false)
		{
			String[] temp = new String[3];
			String line = input.nextLine();
			if(line.equals("done"))
				done = true;
			if(done == false)
			{
				String[] words = line.split("\\s+");
				int opcodeIndex = -1;
				for(int i = 0; i < words.length; i++)
				{
					for(int j = 0; j < opcodes.length; j++)
					{
						if(words[i].equals(opcodes[j]))
						{
							temp[1] = words[i];
							opcodeIndex = i;
						}
					}
				}
				
				if(opcodeIndex == 1)
				{
					temp[0] = words[0];
					if(words.length == 3)
						temp[2] = words[2];
				}
				else if(words.length == 2)
					temp[2] = words[1];
				
				cmds.add(temp);
			}
		}
		
		
		for(int i = 0; i < cmds.size(); i++)
		{
			//System.out.println(cmds.get(i)[0] + " " + cmds.get(i)[1] + " " + cmds.get(i)[2]);
			if(cmds.get(i)[1].equals("DC"))
			{
				String[] newVar = {cmds.get(i)[0], cmds.get(i)[2]};
				vars.add(newVar);
			}
			else if(cmds.get(i)[1].equals("PRINT"))
			{
				System.out.println(getValfromVar(cmds.get(i)[2]));
			}
			else if(cmds.get(i)[1].equals("READ"))
			{
				System.out.println("Read in a value");
				String readLine = input.nextLine();
				updateVal(cmds.get(i)[2], Integer.parseInt(readLine));
			}
			else if(cmds.get(i)[1].equals("END"))
			{
				break;
			}
			else if(cmds.get(i)[1].equals("BU"))
			{
				i = findBranch(cmds.get(i)[2]) - 1;
			}
			else if(cmds.get(i)[1].equals("BL"))
			{
				if(getValfromVar("ACC") < 0)
					i = findBranch(cmds.get(i)[2]) - 1;
			}
			else if(cmds.get(i)[1].equals("BG"))
			{
				if(getValfromVar("ACC") > 0)
					i = findBranch(cmds.get(i)[2]) - 1;
			}
			else if(cmds.get(i)[1].equals("BE"))
			{
				if(getValfromVar("ACC") == 0)
					i = findBranch(cmds.get(i)[2]) - 1;
			}
			else if(cmds.get(i)[1].equals("DIV"))
			{
				updateVal("ACC", (int) getValfromVar("ACC") / getValfromVar(cmds.get(i)[2]));
			}
			else if(cmds.get(i)[1].equals("MULT"))
			{
				updateVal("ACC", getValfromVar("ACC") * getValfromVar(cmds.get(i)[2]));
			}
			else if(cmds.get(i)[1].equals("SUB"))
			{
				updateVal("ACC", getValfromVar("ACC") - getValfromVar(cmds.get(i)[2]));
			}
			else if(cmds.get(i)[1].equals("ADD"))
			{
				updateVal("ACC", getValfromVar("ACC") + getValfromVar(cmds.get(i)[2]));
			}
			else if(cmds.get(i)[1].equals("STORE"))
			{
				updateVal(cmds.get(i)[2], getValfromVar("ACC"));
			}
			else if(cmds.get(i)[1].equals("LOAD"))
			{
				updateVal("ACC", getValfromVar(cmds.get(i)[2]));
			}
		}
	}
}
