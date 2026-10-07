class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();

        q.add(s);
        seen.add(s);

        while (!q.isEmpty()) {
            int n = q.size();
            boolean found = false;

            while (n-- > 0) {
                String x = q.poll();

                if (valid(x)) {
                    res.add(x);
                    found = true;
                }

                if (found) continue;

                for (int i = 0; i < x.length(); i++) {
                    if (x.charAt(i) != '(' && x.charAt(i) != ')') continue;

                    String y = x.substring(0, i) + x.substring(i + 1);

                    if (seen.add(y))
                        q.add(y);
                }
            }

            if (found) break;
        }

        return res;
    }

    public boolean valid(String s) {
        int b = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') b++;
            else if (c == ')') {
                if (b == 0) return false;
                b--;
            }
        }

        return b == 0;
    }
}