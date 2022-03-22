
    /*For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17

     */
/*import java.util.*;
    public class day_1 {
        public static boolean list_add(int k,int l[])
        {
            for(int i=0;i<l.length;i++)
            {
                for(int j=i+1;j< l.length;j++)
                {
                    if(l[i]+l[j]==k)
                        return true;
                }
            }
            return false;
        }
        public static void main(String args[])
        {
            Scanner sc=new Scanner(System.in);
//        System.out.println("Enter the number of elements for the list");
//        int n=sc.nextInt();
//        int l=new int[n];
//        for(int i=0;i<n;i++)
//            l[i]=sc.nextInt();
            int l[]={10,3,5,7};
            System.out.println(list_add(17,l));
        }
    }
 */
    //Using hashmap
    import java.util.*;
    public class day_1 {
        public static void main(String[] args) {
            int[] nums = {2, 7, 11, 15, 19};
            int target = 13;
            int[] arr = twoSum(nums, target);
            System.out.print("[ ");
            for(int i = 0; i < 2; i++) {
                System.out.print(arr[i]+ " ");
            }
            System.out.println("]");
        }
        private static int[] twoSum(int[] nums, int target) {
            int[] arr = new int[2];
            Map<Integer, Integer> map = new HashMap<Integer,Integer>();
            for(int j = 0; j < nums.length; j++) {
                Integer value = map.get(target - nums[j]);
                System.out.println("Value"+value);
                if(value == null) { /* no match found */
                    map.put(nums[j], j);
                    System.out.println("nums[j]="+nums[j]);
                    System.out.println("j="+j);
                }
                else {     /* pair found, updating index */
                    arr[0] = value;
                    arr[1] = j;
                    break; //  loop exit
                }
            }
            return arr;
        }
    }