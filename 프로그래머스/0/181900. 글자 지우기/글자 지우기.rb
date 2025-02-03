def solution(my_string, indices)
    for i in indices
        my_string[i] = 'A'
    end
    
    return my_string.gsub('A', '')
end