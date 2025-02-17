import java.util.*;

class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0, r = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;

        while (r < n) {
            // Expand window
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            // Shrink window when all 'a', 'b', 'c' are present
            while (map.size() == 3) {
                cnt += (n - r); // All substrings from l to end
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) {
                    map.remove(s.charAt(l));
                }
                l++; // Shrink window
            }
            r++; // Expand window
        }

        return cnt;
    }
}
