def solution(n)
    answer = Array.new(n) { Array.new(n, 0) }  # 2차원 배열 초기화
    direction = [[0,1], [1, 0], [0, -1], [-1, 0]]
    
    now_i = 0
    now_j = 0
    now_num = 1
    now_d_idx = 0
    for i in 0...n
        for j in 0...n
            answer[now_i][now_j] = now_num
            now_num += 1
            next_i = now_i + direction[now_d_idx][0]
            next_j = now_j + direction[now_d_idx][1]
            if next_i >= n || next_j >= n || next_i < 0 || next_j < 0 || answer[next_i][next_j] != 0
                now_d_idx = (now_d_idx+1) % 4
                next_i = now_i + direction[now_d_idx][0]
                next_j = now_j + direction[now_d_idx][1]
            end
            now_i = next_i
            now_j = next_j
        end
    end
    
    return answer
end