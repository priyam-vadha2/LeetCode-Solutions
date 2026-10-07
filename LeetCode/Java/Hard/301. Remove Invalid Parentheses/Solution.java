class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<>();
        String ss="";
        if(s.length()==1 )
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
        //char []ch=new char[s.length()];
     public static boolean valid(String s){    
        Stack<Character> st=new Stack<>();
        int j=0;
        int c=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                st.push(s.charAt(i));
                //ch[j++]=s.charAt(i);
            }
            else if(s.charAt(i)==')')
            {
                if(!st.isEmpty() && st.peek()=='(')
                {
                    st.pop();
                    //ch[j++]=s.charAt(i);
                }
                else
                {
                    return false;
                }
            }
            else
            {
                //ch[j++]=s.charAt(i);
                c=1;
                continue;
            }
        }
        //String valid=new String(ch,0,j);
        //res.add(valid);
        if(st.isEmpty() && c==1)
        {
            return true;
        }
        else{ 
        return st.isEmpty();
        }
    }
}