class Solution:
    def permute(self, nums):
        n = len(nums)
        permutations = []
        swap_counts = [0] * n         #count the swaps for each index
        permutations.append(nums[:])  # we have one already: the original array

        index = 0                     # Current index we're working with
        while index < n:
            if swap_counts[index] < index: 
                if index % 2 == 0:
                    # We swap an element with an even index
                    nums[0], nums[index] = nums[index], nums[0]
                else:
                    # we swap the index with the number of counts
                    nums[swap_counts[index]], nums[index] = nums[index], nums[swap_counts[index]]

                # Store the new permutation
                permutations.append(nums[:])

                swap_counts[index] += 1
                index = 0
            else:
                # If the counts are now more than the index, we have reached all the permutations with this index, we go forward and clean the number of swaps
                swap_counts[index] = 0
                index += 1

        return permutations


sol = Solution()

nums = [1,2,3]
result = sol.permute(nums)
print(result)
nums = [0,1]
result = sol.permute(nums)
print(result)