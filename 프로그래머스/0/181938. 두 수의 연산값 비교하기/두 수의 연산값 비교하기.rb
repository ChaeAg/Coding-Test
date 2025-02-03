def solution(a, b)
    return [(a.to_s + b.to_s).to_i, 2 * a * b].max
end