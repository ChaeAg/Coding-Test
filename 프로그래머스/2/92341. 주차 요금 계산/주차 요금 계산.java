import java.util.*;
class Solution { // fees = {기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)}
    public int[] solution(int[] fees, String[] records) {
        Map<String,String> Imap = new HashMap<>(); // 입차한 시간을 저장하는 map
        Map<String,Integer> timeMap = new TreeMap<>(); // 주차한 시간을 저장하는 map
        StringTokenizer st;

        for(String record : records){
            st = new StringTokenizer(record);
            String time = st.nextToken();
            String car = st.nextToken();
            String IO = st.nextToken();
			
            if(IO.equals("IN")){
                Imap.put(car, time);
            }
            else {
                int IOTime = getTime(Imap.get(car), time);
                timeMap.put(car, timeMap.getOrDefault(car, 0) + IOTime); // 주차시간 저장
                Imap.remove(car);
            }            
        }    

        for(String car : Imap.keySet()){ // 마지막까지 출차 안한 차량들 계산
            int IOTime = getTime(Imap.get(car), "23:59"); // 출차 시간을 23:59로 정해줌
            timeMap.put(car, timeMap.getOrDefault(car, 0) + IOTime);
        }

        int[] answer = new int[timeMap.size()];
        int i = 0;
        
        for(String car : timeMap.keySet()) { 
            int time = timeMap.get(car);
            int price;
            if(time <= fees[0]) { // 주차시간이 기본시간 미만이면 기본 요금
                price = fees[1];
            }
            else {
                 price = fees[1] + (int)Math.ceil((double)(time - fees[0]) / fees[2]) * fees[3];   
            }
            
            answer[i++] = price;
        }

        return answer;
    }
	
    // 주차 시간 구하는 메서드
    private static int getTime(String inTime, String outTime) {
        // 분 단위라서 60 곱해줌
        String[] s = inTime.split(":");
        int inNum = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        
        s = outTime.split(":");
        int outNum = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);

        return outNum - inNum;
    }
}