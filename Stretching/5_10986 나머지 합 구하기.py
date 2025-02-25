n, m = map(int, input().split())
numbers = list(map(int, input().split()))
p_sum = [0] * (n+1)
for i in range(1,n+1):
  p_sum[i] = (p_sum[i-1] + numbers[i-1]) % m

same_p = [0]*(m+1)
answer = 0
for p in p_sum:
  if p == 0:
    answer += 1
  else :
    same_p[p] += 1
answer -= 1

answer += answer * (answer -1) / 2
for s in same_p:
  if s == 0 :
    continue
  answer += s * (s-1) / 2

print(answer)