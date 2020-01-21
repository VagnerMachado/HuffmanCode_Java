/**
 * Vagner Machado QCID 23651127
 * Professor Tsaiyun Phillips
 * CSC 323-33
 * Project 4: Huffman Linked List
 * 			  Huffman Binary Tree
 */
package pack;

public class TreeNode 
{
	protected String chStr;
	protected int prob;
	protected TreeNode next;
	protected TreeNode left;
	protected TreeNode right;
	protected String code;

	public TreeNode()
	{
		chStr = "NULL";
		prob = 0;
		next = right = left = null;
		code = "";
	}

	public TreeNode(String str, int i) 
	{
		chStr = str;
		prob = i;
		next = right = left = null;
		code = "";
	}

	public String printNode()
	{
		String n, l, r = "";
		n = next == null ? "NULL" : next.chStr;
		l = left == null ? "NULL" : left.chStr;
		r = right == null ? "NULL" : right.chStr;
		return  "TreeNode [chStr = " + chStr + ", prob = " + prob + ", code = " + code + ", next chStr = " + n + ", left chStr = " + l + ", right chStr = " + r
				+  "]";
	}

}
