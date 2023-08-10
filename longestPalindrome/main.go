// 1 pass, using a set
// if an item already exists in set, congrats we found a pair to use
func longestPalindrome(s string) int {
    set := map[byte]struct{}{}
    count := 0
    for i := 0; i < len(s); i++ {
        char := s[i]
        if _, ok := set[char]; ok {
            count+=2
            delete(set, char)
        } else {
            set[char] = struct{}{}
        }
    }
    if len(set) > 0 {count++}
    return count
}

// 2 pass
// o(n) time
// o(1) space
// func longestPalindrome(s string) int {
//     freqMap := map[byte]int{}
//     for i := 0; i < len(s); i++ {
//         freqMap[s[i]]++
//     }
//     count := 0
//     for k, v := range freqMap {
//         if v % 2 == 0 {
//             count += v
//             delete(freqMap, k)
//         } else if v != 1 {
//             count += v-1
//             freqMap[k] = v-1
//         }
//     }
//     if len(freqMap) != 0 {
//         count++
//     }
//     return count
// }
