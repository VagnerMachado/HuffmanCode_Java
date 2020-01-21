/**
 * Vagner Machado QCID 23651127
 * Professor Tsaiyun Phillips
 * CSC 323-33
 * Project 4: Huffman Linked List
 * 			  Huffman Binary Tree
 */

package pack;
import java.io.*;
import java.util.Scanner;

public class HuffmanBinaryTree 
{
	private LinkedList list;
	private TreeNode root;
	private String [] charCode;

	public HuffmanBinaryTree()
	{
		list = new LinkedList("DUMMY", 0);
		charCode = new String [256];
	}

	public void constructHuffmanLList(File infile, File outfile)
	{
		try 
		{
			Scanner scan = new Scanner(infile);
			FileWriter writer = new FileWriter(outfile);
			while(scan.hasNext())
			{
				String s = scan.next();
				int i = scan.nextInt();
				TreeNode newNode = new TreeNode();
				if(s.equals("@"))
					s = " ";
				if(s.equals("#"))
					s = "\n";
				newNode.chStr = s;
				newNode.prob = i;
				newNode.next = null;
				int place = list.findSpot(i);
				list.insertOneNode(place, newNode);
				writer.write(list.printList() + "\n");
			}
			writer.close();
			scan.close();
		} catch (IOException e) {
			System.out.println("\n*** Cannot Open files in HuffmanBinaryTree.constructHuffmanLList ***\n");
			e.printStackTrace();
		}
	}

	public TreeNode constructHuffmanBinTree(File outfile)
	{
		try
		{
			TreeNode node = null;
			FileWriter writer = new FileWriter(outfile,true);
			writer.write("\n\n");
			boolean done = false;
			while(!done) 
			{
				node = new TreeNode();
				int probs = list.listHead.next.prob + list.listHead.next.next.prob;
				String str = list.listHead.next.chStr + list.listHead.next.next.chStr;
				node.chStr = str;
				node.prob = probs;

				int place = list.findSpot(probs);
				list.insertOneNode(place, node);
				node.left = list.listHead.next;
				node.right =list.listHead.next.next;
				list.listHead.next = list.listHead.next.next.next;

				writer.write(list.printList() + "\n");
				if(list.listHead.next.next == null)
				{
					root = node;
					done = true;
				}
			}
			writer.close();
		} catch (IOException e)
		{
			System.out.println("\n*** Cannot Open files in HuffmanBinaryTree.constructHuffmanBinTree ***\n");
			e.printStackTrace();
		}
		return root;
	}

	public void inOrderTraversal(TreeNode node, FileWriter writer) throws IOException
	{
		if(node == null)
			return;	
		else 
		{
			inOrderTraversal(node.left, writer);
			writer.write(node.printNode() + "\n");
			inOrderTraversal(node.right, writer);		
		}
	}

	public void preOrderTraversal(TreeNode node, FileWriter writer) throws IOException
	{
		if(node == null)
			return;	
		else 
		{
			writer.write(node.printNode() + "\n");
			preOrderTraversal(node.left, writer);
			preOrderTraversal(node.right, writer);		
		}
	}

	public void postOrderTraversal(TreeNode node, FileWriter writer) throws IOException
	{
		if(node == null)
			return;	
		else 
		{
			postOrderTraversal(node.left, writer);
			postOrderTraversal(node.right, writer);	
			writer.write(node.printNode() + "\n");
		}
	}

	public boolean isLeaf(TreeNode node)
	{
		return node.left == null && node.right == null;
	}

	public void constructCode(TreeNode node, String str) //construct code table
	{
		if (isLeaf(node))
		{
			node.code = str;
			char index =  node.chStr.charAt(0);
			charCode[(int)index] = str;
		}
		else
		{
			constructCode(node.left, str.concat("0"));
			constructCode(node.right, str.concat("1"));
		}
	}
	public void encode(File infile, File outfile)
	{
		try {
			Scanner scan = new Scanner(infile);
			FileWriter writer = new FileWriter(outfile);
			String line = "";
			while (scan.hasNextLine())
			{
				line = scan.nextLine();
				int x = line.length();
				int i = 0;
				while (i < x)
				{
					char c = line.charAt(i);
					int index = (int) c;
					String code = charCode[index];

					writer.write(code);
					i++;
				}
				writer.write(charCode[10]);
				writer.write("\n");
			}
			writer.close();
			scan.close();
		} catch (IOException e) {
			System.out.println("Error opening Files in encode ");
			e.printStackTrace();
		}
	}
	public void decode(File infile, File outfile)
	{
		TreeNode spot = root;
		try {
			Scanner scan = new Scanner(infile);
			FileWriter writer = new FileWriter(outfile);
			String line = "";
			while (scan.hasNextLine())
			{
				line = scan.nextLine();
				int i = 0;
				int x = line.length();
				while (i < x)
				{
					if(isLeaf(spot))
					{
						writer.write(spot.chStr);
						spot = root;
					}
						char c = line.charAt(i);
						if (c == '0')
							spot = spot.left;
						else 
							if (c == '1')
								spot = spot.right;
							else
								throw new IOException("Error getting 0 and 1 in decode method, char retrieved was " + c);
					i++;
				}
			}
			
			writer.close();
			scan.close();
			if (!isLeaf(spot))
			{
				throw new IOException("Error: The compressed file is corrupted.");
			}
			
		} catch (IOException e) {
			System.out.println("Error opening Files in encode ");
			e.printStackTrace();
		}
	}
}
