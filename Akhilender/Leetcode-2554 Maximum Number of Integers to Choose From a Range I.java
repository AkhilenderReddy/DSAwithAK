class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:banned){
            set.add(i);
        }
        int sum=0;
        int count=0;
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                if(sum+i<=maxSum){
                    sum+=i;
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;
        
    }
}