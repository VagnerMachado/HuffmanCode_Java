/**
 * Vagner Machado QCID 23651127
 * Professor Tsaiyun Phillips
 * CSC 323-33
 * Project 4: Huffman Linked List
 * 			  Huffman Binary Tree
 */

package pack;

public class LinkedList 
{
	protected TreeNode listHead;

	public LinkedList()
	{
		listHead = new TreeNode();
	}
	public LinkedList(String str, int i)
	{
		listHead = new TreeNode(str, i);
	}

	public int findSpot(int x)
	{
		TreeNode trav = listHead;
		int spot = 0;
		while (x > trav.prob)
		{
			if(trav.next == null || trav.next.prob >= x)
				return spot;
			else
			{
				trav = trav.next;
				spot++;
			}
		}
		return spot;
	}

	public void insertOneNode(int spot, TreeNode newNode)
	{
		int place = 0;
		TreeNode trav = listHead;
		while (place < spot)
		{
			trav = trav.next;
			place++;	
		}
		newNode.next = trav.next;
		trav.next = newNode;
	}
	
	
	public String printList()
	{
		String res = "listHead -> ";
		TreeNode trav = listHead;
		while (trav != null)
		{
			String n = trav.next == null ? "NULL" : trav.next.chStr;
			res += "(" + trav.chStr + ", " + trav.prob + ", " + n + ") -> ";
			trav= trav.next;
		}
		res +=  "NULL";
		return res;
	}
}
