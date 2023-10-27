class Solution {
    public String longestPalindrome(String s) {
		int n = s.length();
		int maxLen = -1;
		String ans = "";

		for(int k = 0; k < n; k++) {
			int i = k - 1;
			int j = k + 1;
			while(i >= 0 && j < n && s.charAt(i) == s.charAt(j) ) {
				i--;
				j++;
			}
			if (j - i + 1 - 2 > maxLen) {
				ans = s.substring(i + 1, j);
				maxLen = j - i + 1 - 2;
				// System.out.println(ans + " " + maxLen);
			}
		}

		for(int k = 1; k < n; k++) {
			if (s.charAt(k) == s.charAt(k-1)) {
				int i = k - 1;
				int j = k;
				while(i >= 0 && j < n && s.charAt(i) == s.charAt(j) ) {
					i--;
					j++;
				}
				if (j - i + 1 - 2 > maxLen) {
					ans = s.substring(i + 1, j);
					maxLen = j - i + 1 - 2;
					// System.out.println(ans + " " + maxLen);
				}
			}
		}

		return ans;
    }
}