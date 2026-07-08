class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        ind_num = []
        for i, v in enumerate(nums):
            ind_num.append([v, i])
        ind_num.sort()
        i = 0
        j =len(ind_num)-1

        while i<j:
            sum = ind_num[i][0] + ind_num[j][0]
            if sum == target:
                return [ind_num[i][1], ind_num[j][1]]
            elif sum > target:
                j -= 1
            else:
                i += 1
