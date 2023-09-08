class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<pair<int, int>> nums_pair;
        pair<int, int> pr;
        for(int i = 0; i < nums.size(); i++) {
            pr = {nums[i], i};
            nums_pair.push_back(pr);
        }
        sort(nums_pair.begin(), nums_pair.end());
        
        for(int i = 0, j = nums.size() - 1; i <= j; ) {
            if (nums_pair[i].first + nums_pair[j].first < target) {
                i++;
            } else if (nums_pair[i].first + nums_pair[j].first > target) {
                j--;
            } else if (nums_pair[i].first + nums_pair[j].first == target) {
                return {nums_pair[i].second, nums_pair[j].second};
            }
        }
        
        return nums;
    }

};