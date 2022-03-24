/*This problem was asked by Google.

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s),
 which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'

*/
import com.sun.source.tree.Tree;

import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x)
    {
        val=x;
    }
}
public class day_3 {
    TreeNode root;
    public static String serialize(TreeNode root)
    {
        if(root==null)
            return "";
        StringBuilder sb=new StringBuilder();
        traverse(root,sb);
        return sb.toString();
    }
    private static void traverse(TreeNode root,StringBuilder sb)
    {
        if(root!=null)
        {
            sb.append(String.valueOf(root.val));
            sb.append(",");
            traverse(root.left,sb);
            traverse(root.right,sb);
        }
        else
        {
            sb.append("null");
            sb.append(",");
        }
    }
    public static TreeNode deserialize(String data)
    {
        if(data==null || data.isEmpty())
            return null;
        String values[]=data.split(",");
        Queue<String> queue = new LinkedList<String>(Arrays.asList(values));
        return buildTree(queue);
    }
    private static TreeNode buildTree(Queue<String> queue)
    {
        if(queue==null ||queue.isEmpty())
            return null;
        String value = queue.poll();
        if(value.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
    static void preorder(TreeNode root)
    {
        if(root!=null)
        {
            System.out.print(root.val+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        day_3 tree = new day_3();
        tree.root = new TreeNode(20);
        tree.root.left =new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);
        String serialized = serialize(tree.root);
        System.out.println("Serialized view of the tree:");
        System.out.println(serialized);
        TreeNode deserialized = deserialize(serialized);
        System.out.println("The tree after preorder traversal:");
        preorder(deserialized);
    }
}
