class Solution {
    public String solution(String phone_number) {
        String secret = "";
        for(int i = 0; i<phone_number.length()-4; i++) {
            secret += "*";
        }
        return secret + phone_number.substring(phone_number.length()-4);
    }
}