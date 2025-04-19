# 같이 눈사람 만들래?
# https://www.acmicpc.net/problem/20366

N = int(input())
H = list(map(int, input().split()))

H.sort()

min_diff = abs((H[0] + H[3]) - (H[1] + H[2]))

# 바깥쪽 두 눈덩이 선택 (안나의 눈사람)
for i in range(N - 3):
  for j in range(i + 3, N):
    anna = H[i] + H[j]  # 안나의 눈사람 키

    left = i + 1
    right = j - 1
    while left < right:
      elsa = H[left] + H[right]
      diff = abs(anna - elsa)

      min_diff = min(min_diff, diff)

      if min_diff == 0:
        print(0)
        exit()

      if elsa > anna:
        right -= 1
      else:
        left += 1

print(min_diff)
