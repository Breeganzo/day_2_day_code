/*Given an array of integers, return a new array such that each element
at index i of the new array is the product of all the numbers in the original array except the one at i.
For example,
if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
If our input was [3, 2, 1], the expected output would be [2, 3, 6].
Follow-up: what if you can't use division?
*/

//time Complexity -O(N*2)
/*import java.util.*;
class day_2
{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of terms");
        int n=sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        int temp = 0;
        System.out.println("Enter the elements");
        for (int i=0;i<n;i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) {
        int j=1;int l=1;
        //System.out.println("a["+i+"]"+a[i]);
        temp=a[i];
        //System.out.println("temp="+temp);
        a[i]=a[0];
        //System.out.println("a["+i+"]"+a[i]);
        a[0]=temp;
        //System.out.println("a[0]"+a[0]);
        for(int k=1;k<n;k++)
        {
        l=l*a[k];
        //System.out.println("l"+l);
        }
        b[i]=l;
        }
         System.out.print("["+b[0]);
         for(int i=1;i<n;i++) {
             System.out.print(",");
             System.out.print(b[i]);
         }
         System.out.println("]");
    }
}*/

//time-O(N) 
import java.util.*;
class day_2
{
    public static int[] productExceptSelf(int[] nums) {
        int prod=1;
        int n=nums.length;
        int left[]=new int[n];
        int right[]=new int[n];
        int output[]=new int[n];
        left[0]=1;
        right[n-1]=1;
        for(int i=1;i<=n-1;i++)
        {
            left[i]=nums[i-1]*left[i-1];
        }
        for(int i=n-2;i>=0;i--)
        {
            right[i]=nums[i+1]*right[i+1];
        }
        for(int i=0;i<n;i++)
        {
            output[i]=left[i]*right[i];
        }
        return output;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of terms");
        int n=sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements");
        for (int i=0;i<n;i++)
            a[i] = sc.nextInt();
        int b[] = productExceptSelf(a);
        System.out.println("Output");
        System.out.print("["+b[0]);
        for(int i=1;i<a.length;i++) {
            System.out.print(",");
            System.out.print(b[i]);
        }
        System.out.println("]");
    }
}//Most interviews do not ask for space complexity so we dont need to solve this in O(N) space.
