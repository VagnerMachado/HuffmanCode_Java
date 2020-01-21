package pack;
import java.io.File;
import java.util.Scanner;

public class Interface 
{
	private String nameOrg;
	private String nameCompress;
	private String nameDeCompress;

	public Interface(HuffmanBinaryTree hbt)
	{
		interact(hbt);
	}
	
	private void interact(HuffmanBinaryTree hbt)
	{
		System.out.println("\n*** File Encoder and Decoder ***\n ");
		char yesNo = 'y';
		boolean valid;
		String answer = "";
		Scanner scan = new Scanner(System.in);
		while(yesNo == 'y' || yesNo == 'Y')
		{

			valid = false;
			while(!valid)
			{
				System.out.print("\nWould you like to encode a file? ( Y / N )  ");
				answer = scan.next();
				if(!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"))
				{
					System.out.println("\n**** Please enter a valid answer ****\n");
					valid = false;
				}
				else
				{
					valid = true;
					yesNo = answer.charAt(0);
				}
			}
			if(yesNo == 'n')
			{
				System.out.println("\n\n*** Good bye ***\n\n");
				return;
			}
			else
			{
				System.out.print("What is the name of the file?  ");
				nameOrg = scan.next();

				valid = false;
				File original = null;
				while(!valid)
				{
					original = new File(nameOrg);
					if(!original.exists())
					{
						System.out.println("\n*** Please enter a valid file name ***\n");
						System.out.print("What is the name of the file?  ");
						nameOrg = scan.next();
					}
					else
						valid = true;
				}
				nameCompress = nameOrg.substring(0,nameOrg.length() - 4) + "_Compress.txt";
				nameDeCompress = nameOrg.substring(0,nameOrg.length() - 4) + "_DeCompress.txt";

				hbt.encode(original, new File(nameCompress));
				hbt.decode(new File(nameCompress), new File(nameDeCompress));
				System.out.println("\n*** Finished encoding " + nameOrg + " ***\n");
			}
		}
	}

}
