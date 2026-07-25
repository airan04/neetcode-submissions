class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st=new Stack<>();
        int n=tokens.length;
        int ans=0;
        for(int i=0;i<n;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") ||
            tokens[i].equals("*")){
                int first=Integer.parseInt(st.pop());
                int second=Integer.parseInt(st.pop());
                int result=0;
                if(tokens[i].equals("+")){
                    result=second+first;
                }else if(tokens[i].equals("-")){
                    result=second-first;
                }else if(tokens[i].equals("*")){
                    result=second*first;
                }else{
                    result=second/first;
                }
                st.push(Integer.toString(result));
            }else{
                st.push(tokens[i]);
            }
        }
        return Integer.parseInt(st.peek());
    }
}