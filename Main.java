/* You do not need to import anything for this assignment.  

Your repl should contain four files:
1. Main.java - your runner file
2. TreeNode.java
3. LinkedBST.java ** This is your Binary Search Tree
4. KeyboardReader.java

This assignment is VERY similar to AnimalList.  You should spend some time looking at your AnimalList class before you start.

Good luck!
*/

import java.util.Scanner;
import java.util.List;
class Main {
  public static LinkedBST theGivingTree = new LinkedBST();
  public static LinkedBST gtree = new LinkedBST();
  public static void main(String[] args) {
    RunnerMenu();
    //TestCase();
    
    //TC1();
    //TC2();
    //TC3();
    //TC4();
    //TC5();
    //TC6();
    //TC7();
    //TC8();
    //TC9();
  }
  public static void RunnerMenu(){
    boolean flag = true;
    Scanner reader = new Scanner(System.in);
    //Client functionality
    System.out.println("[CLIENT FUNCTIONALITY]\n[SELECT AN OPTION]");
    //While loop. Made it easier by calling methods
    while(flag)
    {
      System.out.print("1)Add Node\n2)Show PreOrder Form\n3)Show InOrder Form\n4)Show PostOrder Form\n5)BONUS:Show LevelOrder Form\n6)BONUS:Show Tree\n7)Delete Node\n8)Search\n9)Count Leaves\n10)Find Path\n11)Count Nodes\n42)Hard Coded Values\n99)Automated Test Cases\n0)Exit\n>>");//options
      //options var
      int option = reader.nextInt();
      //switch case for this cuz thats the most logical placement for this
      switch(option)
      {
        case 0:
          flag = false;
          break;
        case 1:
          addNode();
          break;
        case 2:
          showPreOrderForm();
          break;
        case 3:
          showInOrderForm();
          break;
        case 4:
          showPostOrderForm();
          break;
        case 5:
          showLevelOrderForm();
          break;
        case 6:
          printTree();
          break;
        case 7:
          deleteNodeMethod();
          break;
        case 8:
          search();
          break;
        case 9:
          countLeaves();
          break;
        case 10:
          findPathCount();
          break;
        case 11:
          countNodes();
          break;
        case 42:
          TestCase();
          break;
        case 99:
          AutomatedTestCases();
          break;
        default:
          System.out.println("\nERROR: Invalid command\n");
      }
    }
  }
  //Add Node but in runner
  public static void addNode(){
    Scanner reader = new Scanner(System.in);
    System.out.print("\nAdd Node:");
    String node = reader.next();
    if(theGivingTree.addNode(node)){
      System.out.println("Success!\n");
    }
    else{
      System.out.println("ERROR: Possible duplicate input\n");
    }
  }
  //Shows pre order form
  public static void showPreOrderForm(){
    //Checks to see if its not null
    if(theGivingTree.preOrder().size() == 0){
      System.out.println("\nError: Nothing is in Tree");
      System.out.println(theGivingTree.preOrder() + "\n");//No point in using a for loop for ArrayList cuz its an array list, it prints in really good format 
    }
    else{
      System.out.println("\n" + theGivingTree.preOrder() + "\n");
    }
  }
  //show post order form
  public static void showPostOrderForm(){
     if(theGivingTree.postOrder().size() == 0){
       System.out.println("\nError: Nothing is in Tree");
       System.out.println(theGivingTree.postOrder() + "\n");
    }
    else{
      System.out.println("\n" + theGivingTree.postOrder() + "\n");
    }
  }
  //shows in order form
  public static void showInOrderForm(){
     if(theGivingTree.inOrder().size() == 0){
       System.out.println("\nError: Nothing is in Tree");
      System.out.println(theGivingTree.inOrder() + "\n");
    }
    else{
      System.out.println("\n" + theGivingTree.inOrder() + "\n");
    }
  }
  //shows level order form
  public static void showLevelOrderForm(){
     if(theGivingTree.levelOrder().size() == 0){
       System.out.println("\nError: Nothing is in Tree");
      System.out.println(theGivingTree.levelOrder() + "\n");
    }
    else{
      System.out.println("\n" + theGivingTree.levelOrder() + "\n");
    }
  }
  //prints da tree
  public static void printTree(){
    if(theGivingTree.inOrder().size() == 0){
      System.out.println("\nError: Nothing is in the tree\n");
    }
    else{
      System.out.println();
      theGivingTree.printTree();
      System.out.println();
    }
  }
  public static void AutomatedTestCases(){
    //automated test cases go here
    // PASTE ALL OF THIS CODE INTO YOUR OPTION 99
   KeyboardReader reader1 = new KeyboardReader();
    LinkedBST treeterter;
    int selection;
    int casenum;
    boolean result = false; // records addNode return
    boolean result1 = false;
    boolean result2 = false;
    List answerTree;
    
    do
    { 
      // These options are for Part III -- delete and recursive methods   
      System.out.println("Welcome to the LinkedBST Automated Test Cases Sub Menu");
      System.out.println("\n1.) Test Group A -- Removing leaves"+
      "\n2.) Test Group B -- Removing root node from small trees"+
      "\n3.) Test Group C -- More complex trees"+
      "\n0.) Exit ");
      selection = reader1.readInt("Enter a selection: ");
      
      //Test Cases -- Group A       
      if (selection == 1)
      {
        treeterter = new LinkedBST();
        casenum = 1;  //used to increment the case number
        //Test Cases -- Group A       
        System.out.println("Test Group A\n\n");
                
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Add 10, 5, 15, 3, 6, 12, 20 to an empty tree and delete 3 ***\n");
        treeterter.addNode(new Integer(10));
        treeterter.addNode(new Integer(5));
        treeterter.addNode(new Integer(15));
        treeterter.addNode(new Integer(3));
        treeterter.addNode(new Integer(6));
        treeterter.addNode(new Integer(12));
        treeterter.addNode(new Integer(20));
        treeterter.deleteNode(new Integer(3));
 
        System.out.println("The CORRECT display is: \n[5, 6, 10, 12, 15, 20]\n");
        System.out.println("The STUDENT's display is: \n" + treeterter.inOrder()+"\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give .5/.5 point.\n\n");
        reader1.pause();
        //casenum++;
        
        //2
        casenum = 2;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** delete 6 from the same tree ***\n");
        treeterter.deleteNode(new Integer(6));
 
        System.out.println("The CORRECT display is: \n[5, 10, 12, 15, 20]\n");
        System.out.println("The STUDENT's display is: \n" + treeterter.inOrder()+"\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give .5/.5 point.\n\n");
        reader1.pause();
        casenum++;
        
        //3
        casenum = 3;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** delete 12 from the same tree ***\n");
        treeterter.deleteNode(new Integer(12));
 
        System.out.println("The CORRECT display is: \n[5, 10, 15, 20]\n");
        System.out.println("The STUDENT's display is: \n" + treeterter.inOrder()+"\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give .5/.5 point.\n\n");
        reader1.pause();
        casenum++;
 
        //4
        casenum = 4;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** delete 20 from the same tree ***\n");
        treeterter.deleteNode(new Integer(20));
 
        System.out.println("The CORRECT display is: \n[5, 10, 15]\n");
        System.out.println("The STUDENT's display is: \n" + treeterter.inOrder()+"\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give .5/.5 point.\n\n");
        reader1.pause();
        casenum++;
 
 
        //5
        casenum = 5;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** delete 5 from the same tree ***\n");
        treeterter.deleteNode(new Integer(5));
 
        System.out.println("The CORRECT display is: \n[10, 15]\n");
        System.out.println("The STUDENT's display is: \n" + treeterter.inOrder()+"\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give .5/.5 point.\n\n");
        reader1.pause();
        casenum++;
 
        //6
        casenum = 6;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** delete 15 from the same tree ***\n");
        treeterter.deleteNode(new Integer(15));
 
        System.out.println("The CORRECT display is: \n[10]\n");
        System.out.println("The STUDENT's display is: \n" + treeterter.inOrder()+"\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give .5/.5 point.\n\n");
        reader1.pause();
        casenum++;
 
        //7
        casenum = 7;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** delete 10 from the same tree ***\n");
        treeterter.deleteNode(new Integer(10));
 
        System.out.println("The CORRECT display is: \n[]\n");
        System.out.println("The STUDENT's display is: \n" + treeterter.inOrder()+"\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give .5/.5 point.\n\n");
        reader1.pause();
        casenum++;
      }
      //Test Cases -- Group B       
      else if (selection == 2)
      {
        treeterter = new LinkedBST();
        casenum = 1;  //used to increment the case number
        //Test Cases -- Group B       
        System.out.println("Test Group B\n\n");
                
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Add 10 to an empty tree and delete 10 ***\n");
        result1 = treeterter.addNode(new Integer(10));
        result2 = treeterter.deleteNode(new Integer(10));
 
        System.out.println("The CORRECT display is: \ntrue true []\n");
        System.out.println("The STUDENT's display is: \n" + result1 + " " + result2 + " " + treeterter.inOrder()+"\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give .5/.5 point.\n\n");
        reader1.pause();
        casenum++;
        
        //2
        casenum = 2;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Adding 10, 5, 15 to the tree and deleting 5***\n");
        treeterter = new LinkedBST();
        treeterter.addNode(new Integer(10));
        treeterter.addNode(new Integer(5));
        treeterter.addNode(new Integer(15));
        treeterter.deleteNode(new Integer(5));
        answerTree = treeterter.inOrder();
 
        System.out.println("The CORRECT display is:   \t[10, 15]\n");
        System.out.println("The STUDENT's display is: \t" + answerTree + "\n");
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give .5/.5 point.\n\n");
        reader1.pause();
        casenum++;
        
        //3
        casenum = 3;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Adding 10, 5, 15 to the tree and deleting 15***\n");
        treeterter = new LinkedBST();
        treeterter.addNode(new Integer(10));
        treeterter.addNode(new Integer(5));
        treeterter.addNode(new Integer(15));
        treeterter.deleteNode(new Integer(15));
        answerTree = treeterter.inOrder();
 
        System.out.println("The CORRECT display is:   \t[5, 10]\n");
        System.out.println("The STUDENT's display is: \t" + answerTree + "\n");
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
 
                  + "give .5/.5 point.\n\n");
        reader1.pause();
        casenum++;
 
        //4
        casenum = 4;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Adding 10, 5, 15 to the tree and deleting 10***\n");
        treeterter = new LinkedBST();
        treeterter.addNode(new Integer(10));
        treeterter.addNode(new Integer(5));
        treeterter.addNode(new Integer(15));
        treeterter.deleteNode(new Integer(10));
        answerTree = treeterter.inOrder();
 
        System.out.println("The CORRECT display is:   \t[5, 15]\n");
        System.out.println("The STUDENT's display is: \t" + answerTree + "\n");
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give .5/.5 point.\n\n");
        reader1.pause();
        casenum++;
        //5
        casenum = 5;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Adding 10, 5, to the tree and deleting 10***\n");
        treeterter = new LinkedBST();
        treeterter.addNode(new Integer(10));
        treeterter.addNode(new Integer(5));
        treeterter.deleteNode(new Integer(10));
        answerTree = treeterter.inOrder();
 
        System.out.println("The CORRECT display is:   \t[5]\n");
        System.out.println("The STUDENT's display is: \t" + answerTree + "\n");
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give .5/.5 point.\n\n");
        reader1.pause();
        casenum++;
        //6
        casenum = 6;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Adding 10, 5, to the tree and deleting 5***\n");
        treeterter = new LinkedBST();
        treeterter.addNode(new Integer(10));
        treeterter.addNode(new Integer(5));
        treeterter.deleteNode(new Integer(5));
        answerTree = treeterter.inOrder();
 
        System.out.println("The CORRECT display is:   \t[10]\n");
        System.out.println("The STUDENT's display is: \t" + answerTree + "\n");
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give .5/.5 point.\n\n");
        reader1.pause();
        casenum++;
        
        //7
        casenum = 7;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Adding 10, 15, to the tree and deleting 10***\n");
        treeterter = new LinkedBST();
        treeterter.addNode(new Integer(10));
        treeterter.addNode(new Integer(15));
        treeterter.deleteNode(new Integer(10));
        answerTree = treeterter.inOrder();
 
        System.out.println("The CORRECT display is:   \t[15]\n");
        System.out.println("The STUDENT's display is: \t" + answerTree + "\n");
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give .5/.5 point.\n\n");
        reader1.pause();
        casenum++;
        //8
        casenum = 8;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Adding 10, 15, to the tree and deleting 15***\n");
        treeterter = new LinkedBST();
        treeterter.addNode(new Integer(10));
        treeterter.addNode(new Integer(15));
        treeterter.deleteNode(new Integer(15));
        answerTree = treeterter.inOrder();
 
        System.out.println("The CORRECT display is:   \t[10]\n");
        System.out.println("The STUDENT's display is: \t" + answerTree + "\n");
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give .5/.5 point.\n\n");
        reader1.pause();
        casenum++;
        //2  When done
 
 
      }
      //Test Cases -- Group C       
      else if (selection == 3)
      {
        treeterter = new LinkedBST();
        casenum = 1;  //used to increment the case number
        //Test Cases -- Group C       
        System.out.println("Test Group C\n\n");
                
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Nasty test cases ***\n");
        System.out.println("*** Add 1, 0, 9, 7, 3, 8, 2, 4, 6, 5 to an empty tree and countLeaf ***\n");
        treeterter.addNode(new Integer(1));
        treeterter.addNode(new Integer(0));
        treeterter.addNode(new Integer(9));
        treeterter.addNode(new Integer(7));
        treeterter.addNode(new Integer(3));
        treeterter.addNode(new Integer(8));
        treeterter.addNode(new Integer(2));
        treeterter.addNode(new Integer(4));
        treeterter.addNode(new Integer(6));
        treeterter.addNode(new Integer(5));
 
        System.out.println("The CORRECT display is: \n4\n");
        System.out.println("The STUDENT's display is: \n" + treeterter.countLeaf()+"\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give 1/1 point.\n\n");
        reader1.pause();
        casenum++;
        
        //2
        casenum = 2;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Nasty test cases ***\n");
        System.out.println("*** Add 1, 0, 9, 7, 3, 8, 2, 4, 6, 5 to an empty tree and delete 7 ***\n");
        treeterter.deleteNode(new Integer(7));
 
        System.out.println("The CORRECT display is: \n[0, 1, 2, 3, 4, 5, 6, 8, 9]\n");
        System.out.println("The STUDENT's display is: \n" + treeterter.inOrder()+"\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give 1/1 point.\n\n");
        reader1.pause();
        casenum++;
        
        //3
        casenum = 3;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Nasty test cases ***\n");
        System.out.println("*** delete 9 ***\n");
 
        treeterter.deleteNode(new Integer(9));
 
        System.out.println("The CORRECT display is: \n[0, 1, 2, 3, 4, 5, 6, 8]\n");
        System.out.println("The STUDENT's display is: \n" + treeterter.inOrder()+"\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give 1/1 point.\n\n");
        reader1.pause();
        casenum++;
 
        //4
        casenum = 4;
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Nasty test cases ***\n");
        System.out.println("*** delete 3 ***\n");
 
        treeterter.deleteNode(new Integer(3));
 
        System.out.println("The CORRECT display is: \n[0, 1, 2, 4, 5, 6, 8]\n");
        System.out.println("The STUDENT's display is: \n" + treeterter.inOrder()+"\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give 1/1 point.\n\n");
        reader1.pause();
        casenum++;
      }
      //Test Cases -- Old Group A
      //Part I and II
      else if (selection == 11)
      {
        treeterter = new LinkedBST();
        casenum = 1;  //used to increment the case number
        //Test Cases -- Group A       
        System.out.println("Test Group A\n\n");
                
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Adding 5 to an empty tree ***\n");
        result = treeterter.addNode(new Integer(5));
 
        System.out.println("The CORRECT display is: \ntrue\n");
        System.out.println("The STUDENT's display is: \n" + result + "\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give 1/1 point.\n\n");
        reader1.pause();
        casenum++;
        
        //2
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Adding 3, 4, 2, and 7 to the tree ***\n");
        if(treeterter.addNode(new Integer(3)))
          System.out.println("3 was successfully added.");
        if(treeterter.addNode(new Integer(4)))
          System.out.println("4 was successfully added.");
        if(treeterter.addNode(new Integer(2)))
          System.out.println("2 was successfully added.");
        if(treeterter.addNode(new Integer(7)))
          System.out.println("7 was successfully added.");
 
        System.out.println("\nCase " + casenum + ": If 3, 4, 2, and 7 were successfully added, "
                  + "give 1/1 point.\n\n");
        reader1.pause();
        casenum++;
        
        //3
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Displaying preOrder ***\n");
        answerTree = treeterter.preOrder();
 
        System.out.println("The CORRECT display is:   \t[5, 3, 2, 4, 7]\n");
        System.out.println("The STUDENT's display is: \t" + answerTree + "\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give 1/1 point.\n\n");
        reader1.pause();
        casenum++;
        
        //4
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Displaying inOrder ***\n");
        answerTree = treeterter.inOrder();
 
        System.out.println("The CORRECT display is:   \t[2, 3, 4, 5, 7]\n");
        System.out.println("The STUDENT's display is: \t" + answerTree + "\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give 1/1 point.\n\n");
        reader1.pause();
        casenum++;
 
        //5
        System.out.println("\nCASE " + casenum + ": ");
        System.out.println("*** Displaying postOrder ***\n");
        answerTree = treeterter.postOrder();
 
        System.out.println("The CORRECT display is:   \t[2, 4, 3, 7, 5]\n");
        System.out.println("The STUDENT's display is: \t" + answerTree + "\n");
 
        System.out.println("\nCase " + casenum + ": If the CORRECT display matches the STUDENT's display, "
                  + "give 1/1 point.\n\n");
        reader1.pause();
        casenum++;
 
      }
      else if (selection == 0)
      {
        //When done
        System.out.print("\nI hope that this has been a pleasant testing experience.\n");
        System.out.print("\nCongratulations on creating your first Binary Search Tree!\n");
        System.out.print("\nThis program will terminate when you ");
        reader1.pause();
        System.exit(0);
 
        
      }     
    }while (selection != 0);
  }
  public static void deleteNodeMethod(){
    if(theGivingTree.inOrder().size() == 0){
      System.out.println("\nError: Nothing is in the tree\n");
      return;
    }
    Scanner reader = new Scanner(System.in);
    System.out.print("Which node would you like to delete?: ");
    String remove = reader.next();
   if(!theGivingTree.deleteNode(remove)){
      System.out.println("ERROR: when deleting. Maybe not in list?");
    }
    else{
      System.out.println("Successfully removed inputed value");
    }
  }
  public static void search()
  {
    if(theGivingTree.inOrder().size() == 0){
      System.out.println("\nError: Nothing is in the tree\n");
      return;
    }
    Scanner reader = new Scanner(System.in);
    System.out.print("\nEnter search value: ");
    String find = reader.next();
    if(theGivingTree.search(find)){
      System.out.println("The value is in the tree");
    }
    else{
      System.out.println("The value is not in the tree");
    }
  }
  public static void countLeaves()
  {
    if(theGivingTree.inOrder().size() == 0){
      System.out.println("\nError: Nothing is in the tree\n");
      return;
    }
    if(theGivingTree.countLeaf() == 0){
      System.out.println("\nMan idk your tree is basically dead cuz it has zero leaves\n");
    }
    else{
      System.out.println("\nThis tree is very healthy with a solid " + theGivingTree.countLeaf() + " leaves\n");
    }
    
  }
  public static void findPathCount(){
    if(theGivingTree.inOrder().size() == 0){
      System.out.println("\nError: Nothing is in the tree\n");
      return;
    }
    Scanner reader = new Scanner(System.in);
    System.out.print("Enter value: ");
    String findValue = reader.next();
    if(theGivingTree.findPath(findValue) == -1){
      System.out.println("Sorry, the value you entered is not in the tree");
    }
    else{
      System.out.println("It takes a solid " + theGivingTree.findPath(findValue) + " to get to your inputed value");
    }
  }
  public static void countNodes()
  {
    if(theGivingTree.inOrder().size() == 0){
      System.out.println("\nError: Nothing is in the tree\n");
      return;
    }
    if(theGivingTree.countNode() == 0){
      System.out.println("There are 0 nodes");
    }
    else{
      System.out.println("There are " + theGivingTree.countNode() + " nodes");
    }
  }
  public static void TestCase()
  {
    theGivingTree.addNode(5);
    theGivingTree.addNode(2);
    theGivingTree.addNode(4);
    theGivingTree.addNode(7);
    theGivingTree.addNode(1);
    theGivingTree.addNode(9);
    // pt3TC1();
    // //
    // TC10();

    // TC11();
    // TC12();
    // plsWork();
    // TC13();
    // TC14();
  }
  public static void TC14() {
      LinkedBST tree = new LinkedBST();
     tree.addNode(6);
     tree.addNode(2);
     tree.addNode(9);
     tree.addNode(1);
     tree.addNode(4);
     tree.addNode(8);
     tree.addNode(13);
     tree.addNode(3);
     tree.addNode(7);
     tree.addNode(11);


     System.out.println("Printing Tree" );
     tree.printTree();

     tree.deleteNode(12);
     System.out.println("Deleting node " + 12 );
     System.out.println("Printing Tree" );
     tree.printTree();

     tree.deleteNode(9);
     System.out.println("Deleting node " + 9 );
     System.out.println("Printing Tree" );
     tree.printTree();

     tree.deleteNode(7);
     System.out.println("Deleting node " + 7 );
     System.out.println("Printing Tree" );
     tree.printTree();

  }

  public static void TC13() {
      LinkedBST tree = new LinkedBST();
     tree.addNode(13);
     tree.addNode(12);
     tree.addNode(10);
     tree.addNode(4);
     tree.addNode(19);
     tree.addNode(16);
     tree.addNode(9);

     System.out.println("Printing Tree" );
     tree.printTree();

     tree.deleteNode(12);
     System.out.println("Deleting node " + 12 );
     System.out.println("Printing Tree" );
     tree.printTree();

     tree.deleteNode(9);
     System.out.println("Deleting node " + 9 );
     System.out.println("Printing Tree" );
     tree.printTree();

  }


  public static void plsWork(){
    LinkedBST tree = new LinkedBST();
     tree.addNode(50);
     tree.addNode(30);
     tree.addNode(70);
     tree.addNode(20);
     tree.addNode(40);
     tree.addNode(60);
     tree.addNode(80);
     tree.addNode(41);
     tree.addNode(45);
     tree.addNode(46);

     System.out.println("Printing Tree" );
     System.out.println(tree.preOrder());

     tree.deleteNode(20);
     System.out.println("Deleting node " + 20 );
     System.out.println("Printing Tree" );
     System.out.println(tree.preOrder());

     tree.deleteNode(30);
     System.out.println("Deleting node " + 30 );
     System.out.println("Printing Tree" );
     System.out.println(tree.preOrder());

     tree.deleteNode(50);
     System.out.println("Deleting node " + 50 );
     System.out.println("Printing Tree" );
     System.out.println(tree.preOrder());
  }
  // Delete leaf node
public static void TC12() {
      LinkedBST tree = new LinkedBST();
     tree.addNode(50);
     tree.addNode(30);
     tree.addNode(70);
     tree.addNode(20);
     tree.addNode(40);
     tree.addNode(60);
     tree.addNode(80);

     System.out.println("Printing Tree" );
     tree.printTree();

     tree.deleteNode(20);
     System.out.println("Deleting node " + 20 );
     System.out.println("Printing Tree" );
     tree.printTree();

     tree.deleteNode(30);
     System.out.println("Deleting node " + 30 );
     System.out.println("Printing Tree" );
     tree.printTree();

     tree.deleteNode(50);
     System.out.println("Deleting node " + 50 );
     System.out.println("Printing Tree" );
     tree.printTree();
  }


  public static void TC11() {
      LinkedBST tree = new LinkedBST();
     tree.addNode(44);
     tree.addNode(33);
     tree.addNode(31);
     tree.addNode(52);
     tree.addNode(75);
     tree.addNode(63);
     tree.addNode(74);

     System.out.println("Printing Tree" );
     tree.printTree();

     tree.deleteNode(52);
     System.out.println("Deleting node " + 52 );
     System.out.println("Printing Tree" );
     tree.printTree();
  }
  public static void TC10() {
     LinkedBST tree = new LinkedBST();
     tree.addNode(50);
     tree.addNode(17);
     tree.addNode(72);
     tree.addNode(12);
     tree.addNode(23);
     tree.addNode(54);
     tree.addNode(76);
     tree.addNode(9);
     tree.addNode(14);
     tree.addNode(19);
     tree.addNode(67);
     System.out.println("Printing Tree" );
     tree.printTree();
     
     System.out.println("No. of leaf nodes: " + 
     tree.countLeaf());
     System.out.println("FindPath: " + tree.findPath(76));
     System.out.println("FindPath: " + tree.findPath(14));

     System.out.println("Searching for " + 67 + " - " + tree.search(67));

     tree.addNode(32);
     System.out.println("Printing Tree" );
     tree.printTree();
     System.out.println("No. of leaf nodes: " + 
     tree.countLeaf());
     
     tree.deleteNode(14);
     System.out.println("Deleting node " + 14 );
     System.out.println("Printing Tree" );
     tree.printTree();
     System.out.println("No. of leaf nodes: " + 
     tree.countLeaf());

     tree.deleteNode(72);
     System.out.println("Deleting node " + 72 );
     System.out.println("Printing Tree" );
     tree.printTree();
     System.out.println("No. of leaf nodes: " + 
     tree.countLeaf());

     tree.deleteNode(17);
     System.out.println("Deleting node " + 17 );
     System.out.println("Printing Tree" );
     tree.printTree();
     System.out.println(tree.preOrder());
     System.out.println("No. of leaf nodes: " + 
     tree.countLeaf());

     System.out.println("FindPath: " + tree.findPath(76));
     System.out.println("FindPath: " + tree.findPath(14));
     System.out.println("No. of leaf nodes: " + 
     tree.countLeaf());
     
     tree.addNode(33);
     tree.addNode(44);
     System.out.println("No. of leaf nodes: " + 
     tree.countLeaf());
     tree.printTree();

     tree.deleteNode(23);
     System.out.println("Deleting node " + 23 );
     System.out.println("Printing Tree" );
     tree.printTree();
  
     System.out.println("No. of leaf nodes: " + 
     tree.countLeaf());
/*
     System.out.println("FindPath: " + tree.findPath(44));
     System.out.println("Searching for " + 45 + " - " + tree.search(45));

     tree.deleteNode(17);
     tree.deleteNode(72);

     System.out.println("Printing Tree" );
     tree.printTree();
  
    theGivingTree.addNode("25");
    theGivingTree.addNode("15");
    theGivingTree.addNode("10");
    theGivingTree.addNode("04");
    theGivingTree.addNode("12");
    theGivingTree.addNode("22");
    theGivingTree.addNode("18");
    theGivingTree.addNode("24");
    theGivingTree.addNode("50");
    theGivingTree.addNode("35");
    theGivingTree.addNode("31");
    theGivingTree.addNode("44");
    theGivingTree.addNode("70");
    theGivingTree.addNode("66");
    theGivingTree.addNode("90");
    theGivingTree.addNode("03");
    */
  }
  ///////////////////////////////////////////
  //
  //Testing
  //
  //
  //Testing
  //
  //Pre order:
  //Post order:
  //In order:
  //Level Order:
  //
  //
  //
  public static void pt3TC1(){
    LinkedBST tree = new LinkedBST();
    tree.addNode(5);
    tree.addNode(2);
    tree.addNode(10);
    tree.addNode(4);
    tree.addNode(8);
    tree.addNode(11);
    tree.addNode(3);
    tree.addNode(6);
    tree.addNode(9);
    tree.deleteNode(10);
    tree.printTree();
    System.out.println("FindPath: " + tree.findPath(10));
  }
  public static void LevelOrderForm(){
    LinkedBST tree = new LinkedBST();
    tree.addNode("b");
    tree.addNode("a");
    tree.addNode("c");
    tree.addNode("d");
    System.out.println(tree.levelOrder());
    tree.printTree();
  }
  //TC1
  public static void TC1(){
    //LinkedBST tree = new LinkedBST();
    gtree.addNode("3");
    gtree.addNode("4");
    gtree.addNode("2");
    
    printall();
  }
  //TC2
  public static void TC2(){
    
    gtree.addNode("5");
    gtree.addNode("4");
    gtree.addNode("7");
    gtree.addNode("6");
    gtree.addNode("8");
    gtree.addNode("9");
    printall();
    //tree.addNode("d");  
  }

//TC2
  public static void TC3(){
    
    gtree.addNode("E");
    gtree.addNode("D");
    gtree.addNode("G");
    gtree.addNode("F");
    gtree.addNode("H");
    gtree.addNode("I");
    printall();
    //tree.addNode("d");  
  }
  public static void TC4(){
    
    gtree.addNode("E");
    gtree.addNode("D");
    gtree.addNode("g");
    gtree.addNode("F");
    gtree.addNode("h");
    gtree.addNode("I");
    printall();
    //tree.addNode("d");  
  }
  public static void TC5(){
    
    gtree.addNode(1900);
    gtree.addNode(1600);
    gtree.addNode(4021);
    gtree.addNode(1200);
    gtree.addNode(1809);
    gtree.addNode(3042);
    gtree.addNode(5346);
    gtree.addNode(2519);
    printall();
    //tree.addNode("d");  
  }
  public static void TC6(){
    
    gtree.addNode("J");
    gtree.addNode("A");
    gtree.addNode("G");
    gtree.addNode("P");
    gtree.addNode("E");
    gtree.addNode("S");
    printall();
    //tree.addNode("d");  
  }
  public static void TC7(){
    
    gtree.addNode(25);
    gtree.addNode(15);
    gtree.addNode(50);
    gtree.addNode(10);
    gtree.addNode(22);
    gtree.addNode(35);
    gtree.addNode(70);
    gtree.addNode(04);
    gtree.addNode(12);
    gtree.addNode(18);
    gtree.addNode(24);
    gtree.addNode(31);
    gtree.addNode(44);
    gtree.addNode(66);
    gtree.addNode(90);
    printall();
    //tree.addNode("d");  
  }
  public static void TC8(){
    
    gtree.addNode(8);
    gtree.addNode(10);
    gtree.addNode(14);
    gtree.addNode(3);
    gtree.addNode(6);
    gtree.addNode(7);
    gtree.addNode(1);
    gtree.addNode(04);
    gtree.addNode(13);
    printall();
    //tree.addNode("d");  
  }
  public static void TC9(){
    
    gtree.addNode("CAT");
    gtree.addNode("DOG");
    gtree.addNode("BEAR");
    gtree.addNode("MOUSE");
    gtree.addNode("LION");
    gtree.addNode("ANT");
    gtree.addNode("TIGER");
    gtree.addNode("BIRD");
    gtree.addNode("CROW");
    printall();
  }
  public static void printall(){
    System.out.println("P R E      O R D E R");
    System.out.println("- - -      - - - - -");
    System.out.println(gtree.preOrder());
    System.out.println("");
    System.out.println("P O S T    O R D E R");
    System.out.println("- - - -    - - - - -");
    System.out.println(gtree.postOrder());
    System.out.println("");
    System.out.println("I N        O R D E R");
    System.out.println("- -        - - - - -");
    System.out.println(gtree.inOrder());
    System.out.println("");
    System.out.println("L E V E L   O R D E R");
    System.out.println("- - - - -   - - - - -");
    System.out.println(gtree.levelOrder());
    System.out.println("");
    System.out.println("T H E   T  R  E  E");
    System.out.println("- - -   -  -  -  -");
    gtree.printTree();
  }
}