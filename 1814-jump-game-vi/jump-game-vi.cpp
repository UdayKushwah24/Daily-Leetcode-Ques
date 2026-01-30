class Solution {
public:
    int maxResult(vector<int>& nums, int k) {
        deque<pair<int,int>> dq; // {score, index}
        dq.push_back({nums[0], 0});

        for(int i = 1; i < nums.size(); i++){
            // remove out-of-range elements
            while(dq.front().second < i - k)
                dq.pop_front();

            int cur = dq.front().first + nums[i];

            // maintain decreasing order of score
            while(!dq.empty() && dq.back().first <= cur)
                dq.pop_back();

            dq.push_back({cur, i});
        }
        return dq.back().first;
    }
};