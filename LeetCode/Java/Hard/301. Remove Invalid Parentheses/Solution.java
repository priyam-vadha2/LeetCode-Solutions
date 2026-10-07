class Solution {
    int min=Integer.MAX_VALUE;
    List<String> res=new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        String ss="";
        if(valid(s))
        {
            res.add(s);
            return res;
        }
        remove(s,0);
        if(res.isEmpty())
        {
            res.add("");
        }
        return res;
    }
    public void remove(String s, int removed) {

        if (removed > min) {
            return;
        }

        for (int i = 0; i < s.length(); i++) {

            String ss = s.substring(0, i) + s.substring(i + 1);

            if (valid(ss)) {
                if (removed + 1 < min) {
                    min = removed + 1;
                    res.clear();
                }
                if (removed + 1 == min && !res.contains(ss)) {
                    res.add(ss);
                }

            } else {
                remove(ss, removed + 1);
            }
        }
    }
     public static boolean valid(String s){    
        Stack<Character> st=new Stack<>();
        int j=0;
        int c=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')')
            {
                if(!st.isEmpty() && st.peek()=='(')
                {
                    st.pop();
                }
                else
                {
                    return false;
                }
            }
            else
            {
                c++;
                continue;
            }
        }
        return st.isEmpty();

    }
}