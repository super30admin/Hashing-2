// Time complexity - O(n), n -> length of input array
// Space complexity - O(n)

function findMaxLength(nums: number[]): number {
	const rSumIndexMap = new Map<number, number>([[0, -1]]);
	let maxlen = 0;
	let rSum = 0;
	for (let i = 0; i < nums.length; i++) {
		if (nums[i] === 0) {
			rSum--;
		} else {
			rSum++;
		}

		if (rSumIndexMap.has(rSum)) {
			maxlen = Math.max(maxlen, i - rSumIndexMap.get(rSum));
		} else {
			rSumIndexMap.set(rSum, i);
		}
	}
	return maxlen;
}
