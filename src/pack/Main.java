/**
 * Vagner Machado QCID 23651127
 * Professor Tsaiyun Phillips
 * CSC 323-33
 * Project 4: Huffman Linked List
 * 			  Huffman Binary Tree
 */
package pack;
import java.io.*;

public class Main 
{
	public static void main(String[] args) 
	{
		System.out.println("\n*** Welcome to Vagner's Project 5 ***\n");
		File infile = new File(args[0]);
		File linkedListAndBinaryTree = new File(args[1]);
		File preOrder = new File(args[2]);
		File inOrder = new File(args[3]);
		File postOrder = new File(args[4]);

		HuffmanBinaryTree hbt = new HuffmanBinaryTree();
		hbt.constructHuffmanLList(infile, linkedListAndBinaryTree);
		TreeNode root = hbt.constructHuffmanBinTree(linkedListAndBinaryTree);
		FileWriter writer;
		try {
			writer = new FileWriter(inOrder);
			hbt.inOrderTraversal(root, writer);
			writer.close();	

			writer = new FileWriter(preOrder);
			hbt.preOrderTraversal(root, writer);
			writer.close();

			writer = new FileWriter(postOrder);
			hbt.postOrderTraversal(root, writer);
			writer.close();

		} catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("\n*** Issue Traversing Trees in Main Class ***\n");
		}		
			hbt.constructCode(root, "");		
			Interface act = new Interface(hbt);
	}	
}
