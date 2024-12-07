class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lo=1;
        int hi=1;
        for(int i:nums){
            hi=Math.max(hi,i);
        }
        System.out.println(hi);
        int res=Integer.MAX_VALUE;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int operations=0;
            for(int i:nums){
                if(i>mid){
                    int op= (int)Math.ceil((double)(i-mid)/mid);
                    operations+=op;
                }
               
            }
            if(operations<=maxOperations){
                res=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return res;
        
        
        
    }
}