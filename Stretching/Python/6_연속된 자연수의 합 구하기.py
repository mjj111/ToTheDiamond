n = int(input())
start = 1
end = 2
s = start + end

answer = 0
while start < end < n :
  if s == n:
    end += 1
    s += end
    answer += 1

  elif s < n:
    end += 1
    s += end

  elif s > n:
    s -= start
    start += 1

print(answer+1)
