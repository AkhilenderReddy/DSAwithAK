class Solution {
private:
    void findCombinations(int ind, vector<vector<int>>& ans, vector<int>& candidates, vector<int>& current, int sum) {
        if (sum == 0) {
            ans.push_back(current);
            return;
        }
        if (sum < 0) return;

        for (int i = ind; i < candidates.size(); i++) {
            if (i > ind && candidates[i] == candidates[i - 1]) continue;

            current.push_back(candidates[i]);
            findCombinations(i + 1, ans, candidates, current, sum - candidates[i]);
            current.pop_back(); 
        }
    }

public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> current;

        sort(candidates.begin(), candidates.end());

        findCombinations(0, ans, candidates, current, target);
        return ans;
    }
};

