// Time complexity - O(n), n -> length of input string
// Space complexity - O(n)
function subarraySum(nums: number[], k: number): number {
	const freqMap = new Map<number, number>([[0, 1]]);
	let count = 0;
	let rSum = 0;

	for (let i = 0; i < nums.length; i++) {
		rSum += nums[i];

		const targetPrefixSum = rSum - k;
		if (freqMap.has(targetPrefixSum)) {
			count += freqMap.get(targetPrefixSum);
		}

		freqMap.set(rSum, (freqMap.get(rSum) || 0) + 1);
	}
	return count;
}
