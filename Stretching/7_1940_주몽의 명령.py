n = int(input())
m = int(input())
numbers = list(map(int, input().split()))

numbers.sort()

start = 0
end = n-1

answer = 0
while -1 < start < end < n :
  s = numbers[start] + numbers[end]

  if s == m:
    start -= 1
    end -= 1
    answer += 1

  elif s < m:
    start += 1

  elif s > m:
    end -= 1

print(answer)