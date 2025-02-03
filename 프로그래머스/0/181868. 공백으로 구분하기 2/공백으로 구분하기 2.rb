def solution(my_string)
    answer = []
    str = ''
    for i in 0..my_string.length-1
        if my_string[i] == ' '
            if(str != '')
                answer.push(str)
                str = ''
            end
            next
        end
        str += my_string[i]
    end
    
    return str == '' ? answer : answer << str
end