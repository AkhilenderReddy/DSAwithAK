class Solution {
private:
    bool isPossible(vector<int>& nums, int maxOperations, int mid){
        int ops=0;
        for(int num : nums){
            ops += (num/mid); 
            if(num%mid==0){
                ops-=1;
            }
        }
        return ops<=maxOperations;
    }
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        int res;
        int low=1, high = *max_element(nums.begin(), nums.end());
        while(low<=high){
            int mid = (low+high)>>1;
            if(isPossible(nums, maxOperations, mid)){
                res = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }
};
