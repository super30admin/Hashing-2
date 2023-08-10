func longestPalindrome(s string) int {
    freqMap := map[byte]int{}
    for i := 0; i < len(s); i++ {
        freqMap[s[i]]++
    }
    count := 0
    for k, v := range freqMap {
        if v % 2 == 0 {
            count += v
            delete(freqMap, k)
        } else if v != 1 {
            count += v-1
            freqMap[k] = v-1
        }
    }
    if len(freqMap) != 0 {
        count++
    }
    return count
}
