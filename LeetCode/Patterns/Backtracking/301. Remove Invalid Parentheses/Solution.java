class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<>();
        String ss="";
        if(valid(s))
        {
            res.add(s);
            return res;
        }
        remove(s,res);
        if(res.isEmpty())
        {
            res.add("");
        }
        return res;
    }
    public static void remove(String s,List<String> res){ 
        for(int i=0;i<s.length();i++)
        {
            String ss;
            if(i==0)
            {
                ss=s.substring(i+1);
            }
            else if(i==((s.length())-1))
            {
                ss=s.substring(0,i);
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