class Solution {
    public String reorderSpaces(String text) {
        int n = text.length();
        int words = 0;
        int spaces = 0;

        for(int i = 0; i < n; i++) {
            if(text.charAt(i) != ' ') {
                words++;
                while(i < n && text.charAt(i) != ' ') {
                    i++;
                }
                if (i < n) {
                    i--;
                }
            } else {
                spaces++;
            }
        }

        int fill;
        int rem;
        if (words == 1) {
            fill = 0;
            rem = spaces;
        } else {
            fill = spaces / (words - 1);
            rem = spaces % (words - 1);
        }

        StringBuilder str = new StringBuilder();
        int wordDone = 0;

        for(int i = 0; i < n; i++) {
            if (text.charAt(i) != ' ') {
                while(i < n && text.charAt(i) != ' ') {
                    str.append(text.charAt(i));
                    i++;
                }
                if (wordDone < (words - 1)) {
                    for(int j = 0; j < fill; j++) {
                        str.append(" ");
                    }
                }
                wordDone++;
            }
        }

        for(int i = 0; i < rem; i++) {
            str.append(" ");
        }

        return str.toString();
    }
}