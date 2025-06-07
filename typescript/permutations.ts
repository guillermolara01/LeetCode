function permute(nums: number[]): number[][] {
    const n = nums.length;
    const permutations: number[][] = [];
    const swapCounts: number[] = new Array(n).fill(0); // counts when we swap an index

    permutations.push([...nums]); // add the original, cause it's a permutation intself

    let index = 0;

    while (index < n) {
        if (swapCounts[index] < index) {
            if (index % 2 === 0) {
                [nums[0], nums[index]] = [nums[index], nums[0]];
            } else {
                [nums[swapCounts[index]], nums[index]] = [nums[index], nums[swapCounts[index]]];
            }

            permutations.push([...nums]); // Store a copy of the current permutation

            swapCounts[index] += 1;
            index = 0; 
        } else {
            swapCounts[index] = 0; // we have reached all the possible perms. We reset the count and advance one index.
            index += 1;
        }
    }

    return permutations;
}

let nums = [1,2,3]
let result = permute(nums)
console.log(result)
nums = [0,1]
result = permute(nums)
console.log(result)