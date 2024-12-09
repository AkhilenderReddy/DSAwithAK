class Solution {
    // public boolean checkSpecial(int[] nums, int start,int end){
    //    int num=start;
    //     boolean even;
    //     if(nums[num]%2==0){
    //         even=true;
    //     }else{
    //         even=false;
    //     }
    //     boolean check;
    //     boolean isEven;
    //     for(int i=start+1;i<=end;i++){
    //         isEven=(nums[i]&1)==0?true:false;
    //         // check=((nums[i]&1)!=0)?true:false;
    //         System.out.println(nums[i-1]+" "+nums[i]);
    //         System.out.println(even+""+isEven);
    //         if(even==isEven){
    //             return false;
    //         }
    //         even=isEven;
    //     }
        
    //     return true;
    // }
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
       
        int len=nums.length;

        int[] prefix=new int[len];
        prefix[0]=1;

        for(int i=1;i<len;i++){

            if((nums[i]&1) !=(nums[i-1]&1)){
                // System.out.println( (nums[i]&1)+"!="+(nums[i-1]&1) );
                prefix[i]=1+prefix[i-1];
            }else{
                prefix[i]=1;
            }
        }
        boolean[] ans=new boolean[queries.length];
        int c=0;
        // for(int i:prefix){
        //     System.out.print(i+" ");
        // }
        for(int[] i:queries){
            if(i[1]-i[0]==prefix[i[1]]-prefix[i[0]]){
                ans[c++]=true;
            }else{
                ans[c++]=false;
            }
        }

        return ans;

        // boolean[] ans=new boolean[queries.length];
        // int c=0;
        // for(int i=0;i<queries.length;i++){
        //     int num1=queries[i][0];
        //     int num2=queries[i][1];
        //     System.out.println(num1);
        //     System.out.println(num2);
        //     boolean res=checkSpecial(nums,num1,num2);
        //     ans[c++]=res;
        // }
        // return ans;
        
    }
}