# HuffmanCode_Java
Implementation of Huffman Code in Java    
Project 4 and 5 are contained in this repo

<pre>

<b>Project4:  Implementation of Huffman coding step 2, and step 3. The remaining steps will be in the future projects. (Project 4 will be implemented in Java, the remain steps will be in C++.)</b>
  
Step 2: Construct Huffman ordered linked list using insertion sort. 
	Step 3: Construct Huffman binary tree 
	After the tree construction, you are to traverse the Huffman binary tree in the order of:
			a) pre-order 
			b) in-order
			c) post-order
	
************************
Language: Java

Due Date:  Soft copy: 2/26/2019 Tuesday before midnight
	1 day late: -1 pt 2/27/2019 Wednesday before midnight
	After 2/27/2019 -12 pts for all students who did not submit soft copy on time 
 
Due Date:   Hard copy: 2/28/2019 Thursday in class, 
      -1 pt for late hard copy submission.
	      All projects without hard copy will receive 0 pts even you had submit soft copy on time. 
   
******************************
I. Input (argv[1]  Java):  A file contains a list of <char prob> pairs with the  following format. The input prob are integer, has been multiplied by 100, i.e., a prob equal to .40 will be given as 40, char should be treated as string. 
********************************
	char1  prob1  
	char2  prob2
	char3  prob3
:
:
charn  probn  

********************************
II. Outputs:  four output files. All need to be included in your Hard COPY
********************************
- outFile1 (argv[2]): for your debugging outputs. See output format below for detail.
- outFile2 (argv[3]): A text file contain the pre-order traversal of the Huffman binary tree
- outFile3 (argv[4]): A text file contain the in-order traversal of the Huffman binary tree
- outFile4 (argv[5]): A text file contain the post-order traversal of the Huffman binary tree









********************************
III. Data structure: You MUST have all the object classes as given below.
********************************
  - A treeNode class  // required
   
- chStr (string)
- prob (int)
- next (treeNode *)
- left (treeNode *)
- right (treeNode *)
- code (string) 
Methods:
-  constructor(s)
- printNode (T)
// given a node, T, print T’s chStr, T’s prob, T’s next chStr, T’s left’s chStr, T ‘s right’s chStr 
// print one treeNode per text line

-  linkedList class // required

- listHead (treeNode *)
- constructor (..)
- findSpot (…)  // Use the findSpot algorithm steps taught in class.
- insertOneNode (spot,  newNode)  
// inserting newNode between spot and spot.next.
			// only need two statements (was given in class)
- printList (…)
// print the list to outFIle1, from listHead to the end of the list in the following format:

listHead -->(“dummy”, 0, next’s chStr1)-->( chStr1, prob1, next’s chStr2)...... --> (chStrj, prob j, NULL)--> NULL

	For example: 
listHead -->(“dummy”, 0, “b”)-->( “b”, 5, “a”) -->( “a”, 7, “d”)............ --> (“x”, 45, NULL)--> NULL

- A HuffmanBinaryTree class    // required

	- Root (treeNode *)

    	-  Method:
- constructor(s)
- constructHuffmanLList (inFile, outFile)
- constructHuffmanBinTree (listHead)  
		- preOrderTraversal (Root, outFile) // algorithm is given below
		- inOrderTraversal (Root, outFile)
		- postOrderTraversal (Root, outFile)
		- isLeaf (node)// a given node is a leaf if both left and right are null.



******************************************
IV.  Main (….)
******************************************

Step 0: inFile <- open input  file from argv[1]
outFile1, outFile2, …, outFile5 <- open from argv[2], …, argv[6]
	
Step 1: constructHuffmanLList  (inFile, outFile1) // see below

Step 2:  constructHuffmanBinTree (listHead, outFile1) // see below

Step 3: preOrderTraversal (Root, outFile2)  // In recursion, algorithm is given below

step 4: inOrderTraversal (Root, outFile3) // In recursion

step 5: postOrderTraversal (Root, outFile4)// In recursion

step 6: close all files

******************************************
V.  constructHuffmanLList (inFile, outFile)
******************************************

Step 1:  listHead <- get a newNode as the dummy treeNode with (“dummy” ,0),  listHead to point to.  

Step 3: chr  <- get  from inFile
            Prob  <- get  from inFile
	newNode <- get a new listNode
        	newNode’s chStr <- chr
	newNode’s prob <- Prob
	newNode’s next <- null

Step 4: spot <- findSpot (listHead, newNode) // see algorithm below
           
step 5:  insertOneNode (spot, newNode) // insert newNode after spot

Step 6: printList (listHead, outFile) 
// print the list to outFile, from listHead to the end of the list 
// using the format given in the above.

Step 7: repeat step 3 – step 5 until the end of inFile .
	








******************************************
VI. constructHuffmanBinTree (listHead, outFile) 
******************************************
 Step 1: newNode <- create a treeNode
        newNode’s prob <- the sum of prob of the first and second node of the list // first is the node after dummy
        newNode’s chStr <- concatenate chStr of the first node and chStr of the second node in the list
        newNode’s left <- the first node of the list
        newNode’s right <- the second node of the list

Step 2: spot <- findSpot(listHead, newNode)  

          insertOneNode (spot, newNode)  // inserting newNode between spot and spot.next.
				// only need two statements.
         listHead’s next’s next  <- listHead’s next’s next’s next’s next//  listHead is pointed to dummy node, 
				//therefore,  listHead’s next’s next is the dummy’s next 

	printList (listHead, outFile) 

Step 3: repeat step 1 – step 2 until the list only has one node left which is the newNode

Step 4:  Root <- newNode

******************************************
VII.  preOrderTraveral (T, outFile)  // In recursion
******************************************
  
if (T is null)
     do nothing
else
      printNode (T) // output to outFile,  see printing format in treeNode in above
      preOrderTraveral (T’s left, outFile)
                  preOrderTraveral (T’s right, outFile)

******************************************
VIII. inOrderTraveral (Root, outFile)  // In recursion
******************************************

You should know how to write this method.


******************************************
VIIII. postOrderTraveral (Root, outFile)  // In recursion
******************************************

You should know how to write this method.



<b>Project 5: (Java code) This project is a continuation of your project 4, adding the final step, step 4 (construct Huffman code table).  Once you have a Huffman code table and Huffman binary tree, you will be able to do data encoding (data compression) and data de-coding (data de-compression). </b>

Summary of this project: (what you need to do in the project 5.)

1) After the completion of the Huffman coding steps:  2, 3, and 4, a code table is produced, as well as the Huffman binary tree.  Your program is ready for en-coding (data compression) and de-coding (data de-compression).

2)  You ask the user if he/she want to compress a file:
(‘Y’ for yes, ‘N’ for no.)
  if ‘N’, exit the program
  is ‘Y’, you ask the user for the name of a text file to be compressed.

3) Your program opens the text file and call Encode (…)  method to perform compression on the text file and outputs the result to a text file.  

4) The name of the compressed file is to be created during the run time of your program, using the original file name with an extension “ _Compressed.”  For example, if the name of the original text is “data”, then the name of the compressed file should be “data_Compressed”.   (This can be done simply using string concatenation.) 
  
5) Close the compressed file.

6) To make sure your encoding method works correctly, your program will open the compressed file (after it is closed) and call Decode(…)  method to perform the de-compression.  Your program outputs the de-compressed result to a text file.  (If your program works correctly, this file should be the same as the original file.) 

7) The name of the de-compressed file is created, using the original file name with an extension “_deCompressed”. For example, if the name of the original text is “data”, then the name of the de-compressed file should be “data_deCompressed”. 
   
8) Closed the de-compressed file.
   // after this step your directory should have three files: data, data_Compressed, and data_deCompressed.

9) Repeat 2) to 8) until user type “N” to exit the program.

10) You will be provided with three data files: data1, data2, data3,  for you to test your  encoding and de-coding of your program.
     
11) Include in your hard copies: 
(a) Print those four outfiles (with proper captions indicating which is what);
(b) Print data1, data1_compressed, data1_deCompresssed; data2, data2_compressed, data2_deCompresssed;  data3, data3_compressed, data3_deCompresssed 
(with proper captions indicating which is what. 

12) You are to re-use codes in project 4. Therefore, the specs below only provide those additional methods that you need for this project.


********************************
Language: Java

Due date (soft copy): 3/17/2019 Sunday before Midnight
	Early submission +1 deadline: 3/13/2019 Wednesday before Midnight
	-1 pt due: 3/18/2019 Monday before midnight
	After 3/18/2019,  -12 pts for all students who did not submit soft copy 

Due Date (hard copy):   3/19/2019 Tuesday in class, 
-1 pt for late hard copy submission after Thursday 3/21/2019 (in class).
All projects without hard copy after 3/21/2019 will receive 0 pts even you have submit soft copy on time and even if it works.

******************************
I. Input (args[0]  Java):  A file contains a list of <char prob> pairs with the  following format. The input prob are integer, has been multiplied by 100, i.e., a prob equal to .40 will be given as 40, char should be treated as string. 
********************************
	char1  prob1  
	char2  prob2
	char3  prob3
:
:
charn  probn  

********************************
II. Outputs:  four output files. need to be included in your Hard COPY
********************************
- outFile1 (args[1]): for your debugging outputs. See output format below for detail.
- outFile2 (args[2]): A text file contain the pre-order traversal of the Huffman binary tree
- outFile3 (args[3]): A text file contain the in-order traversal of the Huffman binary tree
- outFile4 (args[4]): A text file contain the post-order traversal of the Huffman binary tree

********************************
III. Data structure:
********************************
Re-use the data structures/classes from the specs of project4; 

1)  Add the following to the data structure/class. (You may add new data structure as needed.)

	string charCode [256] a 1D array of string to store the character codes. 
	constructCode (…) to construct Huffman code table
	Encode (…) to do compression 
	Decode (…) to do de-compression
	isLeaf ( T) to check if T is a leaf

2) modify printNode(T)  method to include T’s code, after T’s prob.
- printNode (T)
// print T’s chStr, T’s prob, T’s code, T’s next chStr, T’s left’s chStr, T ‘s right’s chStr 

******************************************
IV.  Main (….)
******************************************
Step 0: inFile <- open input  file from args
outFile1, outFile2, …, outFile4 <- open from args
	
Step 1: constructHuffmanLList  (inFile, outFile1) 
Step 2:  constructHuffmanBinTree (listHead, outFile1) 
Step 3:  constructCode (Root, “”) // “” is an empty string . See algorithm below.
Step 4: preOrderTraversal (Root, outFile2)  
step 5: inOrderTraversal (Root, outFile3) 
step 6: postOrderTraversal (Root, outFile4)

step 7:  userInterface ( ) // given below

step 8: close all files.

******************************
V. userInterface ( )
******************************
step 0:
nameOrg (string)
nameCompress (string)
nameDeCompress (string)
yesNo (char)

Step 1:  yesNo <- ask user if he/she want to encode a file

if yesNo == ‘N’  
exit the program
else
		nameOrg <- as the user for the name of the file to be compressed

step 2: nameCompress <- nameOrg + “_Compressed”
	nameDeCompress <- nameOrg + “_DeCompress”

Step 3: orgFile <- open nameOrg file for read
	compFile <- open nameCompress file for write
	deCompFile <- open nameCompress file for write

Step 4: Encode (orgFile, compFile)  //  see algorithm steps below
Step 5: close compFile
Step 6: re-open compFile
step 7: Decode (compFile, deCompFile) // see algorithm steps below
Step 7: close orgFile, compFile and deCompFile
step 8: repeat step 1 to step 7 until program exit


******************************************
VI.  constructCode (T, code) 
******************************************
if  isLeaf (T)
	    
 	T’s code <- code;
       Index <-cast T’s chStr  to integer
	charCode[index] <- code  
	else 
	      constructCode (T’s  left, code + “0”) //string concatenation
	      constructCode (T’s  right, code + “1”) //string concatenation

******************************************
VII. Encode (inFile, outFile)
******************************************
step 1: textLine<- read one text line from inFile

step 2: charIn <- get one character from textLine

step 3:  index <- cast charIn to integer  

step 4:  code <-  charCode[index]

step 5: write code to outFile  

step 6: repeat step 2 to step 5 until end of textLine

step 7: repeat step 1 to step 6 until eof inFile 

******************************************
VIII. Decode (inFile, outFile)
******************************************
step 1: Spot <- Root

step 2: if Spot is a leaf
	write  Spot’s chr to outFile
	spot <- Root

step 3: oneBit <- read a character from inFile  // should be either ‘0’ or ‘1’
        
step 4: if oneBit == ‘0’
              	 Spot <- Spot’s left
	else
              if oneBit == ‘1’
 Spot <- Spot’s right
	  else
		output error message: “Error! The compress file contains invalid character!”
		exit the method.

step 5: repeat step 2 to step 5 until  eof  inFile

step 6: if eof inFile but Spot is not a leaf, output error message: “Error:  The compress file is corrupted!”
	



</pre>
