    class Solution {
        public String removeKdigits(String num, int k) {
            Stack<Integer> stack = new Stack<>();
            char[] arr = num.toCharArray();
            boolean isDone = false;

            for(char c : arr) {
                if(isDone) {
                    stack.push(c - '0');
                    continue;
                }

                while(!stack.isEmpty()) {
                    int n = stack.pop();
                    if(c - '0' < n) {
                        k--;
                        if(k == 0) {
                            isDone = true;
                            break;
                        }
                    } else {
                        stack.push(n);
                        break;
                    }
                }

                stack.push(c - '0');
            }

            while(k > 0) {
                stack.pop();
                k--;
            }

            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) {
                sb.insert(0, stack.pop());
            }
            
            while(sb.length() > 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }

            return sb.isEmpty() ? "0" : sb.toString();
        }
    }