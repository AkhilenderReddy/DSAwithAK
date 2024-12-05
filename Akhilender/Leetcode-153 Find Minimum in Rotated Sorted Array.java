class Solution {
    public int findMin(int[] nums) {
        int len=nums.length-1;
        int i=0;
        int j=len;
        int min=Integer.MAX_VALUE;
        while(i<=j){
            int mid=(j+i)/2;
            System.out.println(nums[mid]);
            if(nums[mid]<=min){
                min=nums[mid];
            }
            if(nums[mid]>=nums[j]){
                i=mid+1;
            }else{
                j=mid;
            }
        }
        return min;
    }
}