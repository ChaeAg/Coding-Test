import java.math.BigInteger;
class Solution {
    public String solution(String a, String b) {
        BigInteger A = new BigInteger(a);
        return A.add(new BigInteger(b)).toString();
    }
}