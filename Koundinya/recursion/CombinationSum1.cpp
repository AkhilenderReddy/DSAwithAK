class Solution {

private:
    void function(int ind, vector<vector<int>>& ans,vector<int>& candidates, vector<int>& arr, int sum){
        if(sum==0){
            ans.push_back(arr);
            return;
        }
        if(sum<0 || ind>=candidates.size()) return;
                arr.push_back(candidates[ind]);

        function(ind, ans, candidates, arr ,sum-candidates[ind]);
                arr.pop_back();

        function(ind+1, ans, candidates, arr, sum);

    }

public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        //your code goes here
        vector<vector<int>> ans;
        vector<int> arr;
        function(0, ans, candidates, arr, target);
        return ans;
    }
};
