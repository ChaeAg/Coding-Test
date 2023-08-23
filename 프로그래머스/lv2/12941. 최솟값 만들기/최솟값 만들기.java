import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        List<Integer> listB = new ArrayList();
        
        for(int i=0; i<B.length; i++) listB.add(B[i]);
        
        Arrays.sort(A); // A배열 오름차순 정렬
        listB.sort(Collections.reverseOrder()); //B배열 내림차순 정렬
        
        for(int i=0; i<A.length; i++)
            answer += A[i] * listB.get(i);

        return answer;
    }
}