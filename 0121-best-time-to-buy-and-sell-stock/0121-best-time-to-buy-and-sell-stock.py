class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        mini = prices[0]
        maxProf = 0

        for i in range(1, len(prices)):
            diff = prices[i] - mini
            maxProf = max(diff, maxProf)
            mini = min(mini, prices[i])
        return maxProf
