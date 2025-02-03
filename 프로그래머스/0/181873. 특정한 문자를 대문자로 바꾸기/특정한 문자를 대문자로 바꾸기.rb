def solution(my_string, alp)
    answer = ''
    
    for i in 0..my_string.length-1
        if my_string[i] == alp
            answer << my_string[i].upcase
        else
            answer << my_string[i]
        end
    end
    
    return answer
end