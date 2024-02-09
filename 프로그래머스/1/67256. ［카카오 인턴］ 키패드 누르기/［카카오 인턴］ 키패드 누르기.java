class Solution {
    public static int left = 10, right = 10;
    public static StringBuilder sb = new StringBuilder();
    public static String userHand = "";
    
    public String solution(int[] numbers, String hand) {
        userHand = hand;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                left = numbers[i];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                right = numbers[i];
            } else {
                int leftDistance = -1, rightDistance = -1, distance = -1;
                if (numbers[i] == 2) {
                    if(left == right) {
                        if(userHand.equals("left")) {
                            sb.append("L");
                            left = numbers[i];
                        }
                        else {
                            sb.append("R");
                            right = numbers[i];
                        }
                        continue;
                    }
                    for (int j = 0; j < 2; j++) {
                        int tmp = j == 0 ? left : right;
                        switch (tmp) {
                            case 2:
                                distance = 0;
                                continue;
                            case 1:
                            case 3:
                            case 5:
                                distance = 1;
                                break;
                            case 4:
                            case 6:
                            case 8:
                                distance = 2;
                                break;
                            case 7:
                            case 9:
                            case 0:
                                distance = 3;
                                break;
                            case 10:
                                distance = 4;
                                break;
                        }
                        if (tmp == left) leftDistance = distance;
                        else rightDistance = distance;
                    }
                    checkRightOrLeft(leftDistance, rightDistance, numbers[i]);
                } else if (numbers[i] == 5) {
                    if(left == right) {
                        if(userHand.equals("left")) {
                            sb.append("L");
                            left = numbers[i];
                        }
                        else {
                            sb.append("R");
                            right = numbers[i];
                        }
                        continue;
                    }
                    for (int j = 0; j < 2; j++) {
                        int tmp = j == 0 ? left : right;
                        switch (tmp) {
                            case 5:
                                distance = 0;
                                break;
                            case 2:
                            case 4:
                            case 6:
                            case 8:
                                distance = 1;
                                break;
                            case 1:
                            case 3:
                            case 7:
                            case 9:
                            case 0:
                                distance = 2;
                                break;
                            case 10:
                                distance = 3;
                                break;
                        }
                        if (tmp == left) leftDistance = distance;
                        else rightDistance = distance;
                    }
                    checkRightOrLeft(leftDistance, rightDistance, numbers[i]);
                } else if (numbers[i] == 8) {
                    if(left == right) {
                        if(userHand.equals("left")) {
                            sb.append("L");
                            left = numbers[i];
                        }
                        else {
                            sb.append("R");
                            right = numbers[i];
                        }
                        continue;
                    }
                    for (int j = 0; j < 2; j++) {
                        int tmp = j == 0 ? left : right;
                        switch (tmp) {
                            case 8:
                                distance = 0;
                                break;
                            case 5:
                            case 7:
                            case 9:
                            case 0:
                                distance = 1;
                                break;
                            case 4:
                            case 2:
                            case 6:
                            case 10:
                                distance = 2;
                                break;
                            case 1:
                            case 3:
                                distance = 3;
                                break;
                        }
                        if (tmp == left) leftDistance = distance;
                        else rightDistance = distance;
                    }
                    checkRightOrLeft(leftDistance, rightDistance, numbers[i]);
                } else if (numbers[i] == 0) {
                    if(left == right) {
                        if(userHand.equals("left")) {
                            sb.append("L");
                            left = numbers[i];
                        }
                        else {
                            sb.append("R");
                            right = numbers[i];
                        }
                        continue;
                    }
                    for (int j = 0; j < 2; j++) {
                        int tmp = j == 0 ? left : right;
                        switch (tmp) {
                            case 0:
                                distance = 0;
                                break;
                            case 8:
                            case 10:
                                distance = 1;
                                break;
                            case 7:
                            case 5:
                            case 9:
                                distance = 2;
                                break;
                            case 4:
                            case 2:
                            case 6:
                                distance = 3;
                                break;
                            case 1:
                            case 3:
                                distance = 4;
                                break;
                        }
                        if (tmp == left) leftDistance = distance;
                        else rightDistance = distance;
                    }
                    checkRightOrLeft(leftDistance, rightDistance, numbers[i]);
                }
            }
        }

        return sb.toString();
    }
    
    public static void checkRightOrLeft(int leftDistance, int rightDistance, int number) {
        if (leftDistance < rightDistance) {
            left = number;
            sb.append("L");
        } else if (leftDistance > rightDistance) {
            right = number;
            sb.append("R");
        } else {
            if (userHand.equals("left")) {
                left = number;
                sb.append("L");
            } else {
                right = number;
                sb.append("R");
            }
        }
    }
}