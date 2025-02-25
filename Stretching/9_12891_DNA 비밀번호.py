from collections import deque

s, p = map(int, input().split())
string = list(input())
A, C, G, T = map(int, input().split())

dic = {'A': 0, 'C': 0, 'G': 0, 'T': 0}
start = 0
end = p-1
for i in string[start:end]:
  dic[i] += 1

answer = 0
while end < s:
  dic[string[end]] += 1

  if dic['A'] >= A  and dic['C'] >= C and dic['G'] >= G and dic['T'] >= T:
    answer += 1

  dic[string[start]] -= 1
  start += 1
  end += 1

print(answer)