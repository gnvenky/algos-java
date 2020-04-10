
public class AtKMP {

    public static void main(String args[]) {

        String s = "ababababc";
        String p = "abab";
        int i = 0, j = 0;

        int pat[] = getPrefix(p);

        for (int k = 0; k < pat.length; ++k) {
            System.out.println(pat[k]);
        }

        while (i < s.length()) {
            if (p.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            }

            if (j == p.length()) {
                System.out.println("Matches at :" + (i - j));
                j = pat[j - 1];
            } else if (i < s.length() && p.charAt(j) != s.charAt(i)) {
                if (j != 0)
                    j = pat[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    public static int[] getPrefix(String p) {
        int pi[] = new int[p.length()];
        int len = 0;
        pi[0] = 0;
        // len tracks the suffix

        for (int i = 1; i < p.length(); i++) {

            while (len > 0 && pi[i] != pi[len])
                len = pi[len - 1];

            if (p.charAt(len) == p.charAt(i))
                len++;
            pi[i] = len;
        }
        return pi;
    }
}