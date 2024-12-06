class Solution {

  private:
    void function(int index, vector<int>& ans, vector<int>& nums, int sum){
        if(index == nums.size()){
          ans.emplace_back(sum);
          return;
        }
        function(index+1, ans,nums, sum+ nums[index] );
        function(index+1, ans,nums, sum);
    }
  public:
    vector<int> subsetSums(vector<int>& nums) {
        //your code goes here
        int sum = 0;
        vector<int> ans;
        function(0, ans, nums, sum);

        return ans;
    }
};
