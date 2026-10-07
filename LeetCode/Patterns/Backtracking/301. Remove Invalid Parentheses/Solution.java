class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<>();
        String ss="";
        if(valid(s))
        {
            res.add(s);
        }
        else{ 
        for(int i=0;i<s.length();i++)
        {
            if(i==0)
            {
                ss=s.substring(i+1);
            }
            else
            {
                ss=s.substring(0,i)+s.substring(i+1);
            }
            if(valid(ss)&& !res.contains(ss))
            {
                res.add(ss);
            }
        }
        if(res.isEmpty())
        {
            res.add("");
        }
        }
        return res;
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
                c=1;
                continue;
            }
        }
        if(st.isEmpty() && c==1)
        {
            return true;
        }
        else{ 
        return st.isEmpty();
        }
    }
}