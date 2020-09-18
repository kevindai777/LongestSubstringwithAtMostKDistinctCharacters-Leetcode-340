//Java Solution

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        
        while (right < s.length()) {
            char curr = s.charAt(right);
            
            if (map.containsKey(curr) || map.size() < k) {
                ans = Math.max(ans, right - left + 1);
            } else {
                char lastMinKey = 'a';
                int lastMin = Integer.MAX_VALUE;
                
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() < lastMin) {
                        lastMin = entry.getValue();
                        lastMinKey = entry.getKey();
                    }
                }
                
                map.remove(lastMinKey);
                left = lastMin + 1;
            }
            
            map.put(curr, right++);
        }
        
        return ans;
    }
}