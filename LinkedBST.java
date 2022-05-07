import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
public class LinkedBST
{
  private TreeNode root;
  public LinkedBST()
  {
    root= null; //Mr Mkeen Said you get the point for this but to rename it root
    //Must always need a funstructor
  }
  public boolean addNode(Comparable addMe)
  {
    //null case
    if(root == null){
      root = new TreeNode(addMe);
      return true;
    }
    TreeNode current = root;
    while(current != null)// again, while not null
    {
      if(addMe.compareTo(current.getValue()) == 0)//if they the same, it returns false;
      {
        return false;
      }
      if(addMe.compareTo(current.getValue()) < 0)//checks to see whether it goes to the left
      {
        if(current.getLeft() == null)//if it does, it adds to the left
        {
          current.setLeft(new TreeNode(addMe));
          return true;
        }
        //else, it moves left
        current = current.getLeft();
      }
      if(addMe.compareTo(current.getValue()) > 0)//checks to see if it adds to the right
      {
        if(current.getRight() == null)//if it does, it sets right and returns true
        {
          current.setRight(new TreeNode(addMe));
          return true;
        }
        //else, it moves right
        current = current.getRight();
      }
    }
    return false;
  }

  //Part 2

  private void preOrderTraverse(TreeNode current, List list)
  {
    if(current != null){
      list.add(current.getValue());//Adds the root first
      preOrderTraverse(current.getLeft(), list);//goes left and prints
      preOrderTraverse(current.getRight(), list);//goes right and prints
    }
  }
  private void inOrderTraverse(TreeNode current, List list)
  {
    if(current != null)
    {
      inOrderTraverse(current.getLeft(), list);//starts at the far most left, once it reaches null, it returns back values from bottom
      list.add(current.getValue());//adds root in the middle like picture book
      inOrderTraverse(current.getRight(), list);//then moves right, once it reaches null, it returns backwards
    }
  }
  private void postOrderTraverse(TreeNode current, List list)
  {
    if(current != null)
    {
      postOrderTraverse(current.getLeft(), list);//traverses left side until the node is equal to null, then back tracks and recurs
      postOrderTraverse(current.getRight(), list);//Traverses all the way to the right until node is equal to null, then back tracks and returns
      list.add(current.getValue());//prints root last
    }
  }
  private void levelOrderTraverse(TreeNode current, List list)
  {
    //Level order, but it's the cha cha slide
    if(current != null)
    {
      //This is a new queue
      Queue<TreeNode> levelOrderQueue = new LinkedList();
      //adding current to the queue
      levelOrderQueue.add(current);
      //One while loop now
      while(current != null)
      {
        //slides to the left
        if(current.getLeft() != null){
          levelOrderQueue.add(current.getLeft());
        }
        //slides to the right
        if(current.getRight() != null){
          levelOrderQueue.add(current.getRight());
        }
        //one remove this time *clap*
        list.add(levelOrderQueue.remove().getValue());
        //one peak this time *clap*
        current = levelOrderQueue.peek();
        //everybody clap your hands
      }
    }
  }
  public void printTreeLogic(TreeNode current, String str)
  {
    if(current != null)
    {
      // We mix it inOrder logic, except we just add strings. Lets gooo. The idea is simple. It prints the root, then it uses the string and adds a space for each level. Then it prints it. Idk if this is considered a tree but this is treeish to me ngl.
      System.out.println(str + " |-> " + current.getValue());
      printTreeLogic(current.getLeft(), str + " ");
      printTreeLogic(current.getRight(), str + " ");
    }
  }
  //Accessor methods(sort of)
  public List preOrder()
  {
    List preOrderList = new ArrayList();//ArrayList call
    preOrderTraverse(root, preOrderList);//Does PreOrder method
    return preOrderList;
  }
  public List inOrder()
  {
    List inOrderList = new ArrayList();//ArrayList call
    inOrderTraverse(root, inOrderList);//goes to in order
    return inOrderList;
  }
  public List postOrder()
  {
    List postOrderList = new ArrayList();//ArrayList Call
    postOrderTraverse(root, postOrderList);//goes to post order
    return postOrderList;
  }
  public List levelOrder()
  {
    List levelOrderList = new ArrayList();//ArrayList Call
    levelOrderTraverse(root, levelOrderList);//does the level order
    return levelOrderList;
  }
  public void printTree()
  {
    printTreeLogic(root, "");
  }

  // Part 3
  //Jimmy helped me with this
  public boolean deleteNode(Comparable find)
  {
    //initalize variables
    TreeNode current = root;
    TreeNode previous = root;
    //simple case. it could be null, or it could not even be there and it should return null
    if(root.getValue() == null || !search(find))
    {
      return false;
    }
    //root base case 1
    if(find.compareTo(root.getValue()) == 0 && root.getRight()== null && root.getLeft() == null){
      root = null;
      return true;
    }
    if(find.compareTo(root.getValue()) == 0){
      if(current.getLeft() != null)
      {
        //got to travel to the left first, then move right
        TreeNode temp = current.getLeft();
        TreeNode tempPrevious = current;
        while(temp.getRight()!=null)
        {
          tempPrevious = temp;
          temp = temp.getRight();
        }
        //ok so we got to store the thing in one, then put it into another
        current.setValue(temp.getValue());
        if(((Comparable)temp.getValue()).compareTo(((Comparable)tempPrevious.getValue())) > 0){
          tempPrevious.setRight(temp.getLeft());
        }
        else{
          tempPrevious.setLeft(temp.getLeft());
        }
        return true;
      }
      //More testing to make the root deletion works
      else
      {
        if(current.getLeft() == null && current.getRight() != null){
          TreeNode temp = root.getRight();
          root.setValue(temp.getValue());
          root.setRight(temp.getRight());
          return true;
        }
        else
        {
          //got to travel to the left first, then move right
          TreeNode temp = current.getLeft();
          TreeNode tempPrevious = current;
          while(temp.getRight()!=null)
          {
            tempPrevious = temp;
            temp = temp.getRight();
          }
          //ok so we got to store the thing in one, then put it into another
          current.setValue(temp.getValue());
          if(((Comparable)temp.getValue()).compareTo(((Comparable)tempPrevious.getValue())) > 0){
            tempPrevious.setRight(temp.getLeft());
          }
          else{
            tempPrevious.setLeft(temp.getLeft());
          }
          return true;
        }
      }
    }
    while(find.compareTo(current.getValue()) != 0)
    {
      previous=current;
      //moves current
      if(find.compareTo(current.getValue()) > 0)
      {
        current = current.getRight();//moves right if greater
      }
      else{
        current = current.getLeft();//moves less cuz it aint
      }
    }
    //There are 4 different cases. right and left can both be null. right and left both aren't null, left is null, or the right one is null
    if(current.getLeft() == null && current.getRight() == null){
      if(((Comparable)previous.getValue()).compareTo(current.getValue()) < 0)
      {
        previous.setRight(null);
        return true;
      }
      else{
        previous.setLeft(null);
        return true;
      }
    }
    else if(current.getLeft() != null)
    {
      //got to travel to the left first, then move right\
      TreeNode temp = current.getLeft();
      TreeNode tempPrevious = current;
      while(temp.getRight()!=null)
      {
        tempPrevious = temp;
        temp = temp.getRight();
      }
      //ok so we got to store the thing in one, then put it into another
      current.setValue(temp.getValue());
      if(((Comparable)temp.getValue()).compareTo(tempPrevious.getValue()) > 0)
      {
        tempPrevious.setRight(temp.getLeft());
      }
      else{
        tempPrevious.setLeft(temp.getLeft());
      }
      return true;
    }
    //Same logic as them both being null. Sets each right and left to the left
    //Thanks Jimmy!
    else{
      current.setValue(current.getRight().getValue());
      current.setRight(current.getRight().getRight());
      return true;
    }
    // else if(current.getLeft() == null && current.getRight() != null){
    //   if( ((Comparable) current.getValue()).compareTo(previous.getValue()) > 0){
    //     previous.setRight(current.getLeft());
    //     return true;
    //   }
    //   else{
    //     previous.setLeft(current.getLeft());
    //     return true;
    //   }
    // }
    // //The other case where the right is not null and the left is
    // else
    // {
    //   //sets each right and left is to to the right
    //   if( ((Comparable) current.getValue()).compareTo(previous.getValue()) > 0){
    //     previous.setRight(current.getRight());
    //     return true;
    //   }
    //   else{
    //     previous.setLeft(current.getRight());
    //     return true;
    //   }
    // }
  }
  public boolean search(Comparable key)
  {
    return search(root, key);
  }
  private boolean search(TreeNode current, Comparable key)
  {
    //checks to see if null because that means its not in the BST
    if(current == null){
      return false;
    }
    else{
      //checks too see if they are the same, if so then it returns true
      if(key.compareTo(current.getValue()) == 0){
        return true;
      }
      //else, it either goes right, or left
      else{
        if(key.compareTo(current.getValue()) > 0)
        {
          return search(current.getRight(), key);
        }
        else{
          return search(current.getLeft(), key);
        }
      }
    }
  }
  public int countLeaf()
  {
    return countLeaf(root);
  }     	
  private int countLeaf(TreeNode current)
  {
    if(current == null){
      return 0;//limits 
    }
    else{
      //if found, returns 1
      if(current.getLeft() == null && current.getRight() == null){
        return 1;
      }
      //keeps searching if not and adds to it
      else{
        return countLeaf(current.getLeft()) + countLeaf(current.getRight());
      }
    }
  }
  public int findPath(Comparable find)
  {
    if(!search(find)){
      return -1;
    }
    return findPath(root, find);
  }
  private int findPath(TreeNode current, Comparable find)
  {
    //search logic, but instead, you're adding 1 to each path
    if(current == null){
      return -1;
    }
      //checks too see if they are the same, if so then it returns true
    else if(find.compareTo(current.getValue()) == 0){
      return 0;
    }
    //else, it either goes right, or left
    else if(find.compareTo(current.getValue()) > 0)
    {
      return 1 + findPath(current.getRight(), find);
    }
    else
    {
      return 1 + findPath(current.getLeft(), find);
    }
  }
  public int countNode()
  {
    return countNode(root);
  }  
  private int countNode(TreeNode current)
  {
    if(current == null)//base case
    {
      return 0;
    }
    else
    {
      //returns 1 each time
      return 1 + countNode(current.getLeft()) + countNode(current.getRight()); 
    }
  }
}