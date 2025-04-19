n, capacity = map(int, input().split())
m = int(input())
in_box = [list(map(int, input().split())) for _ in range(m)]

in_box.sort(key=lambda x: x[1])

village = [0] * (n + 1)
result = 0

for f, t, box in in_box:
  # f부터 t-1 마을까지 가장 많이 실려 있는 구간을 기준으로 temp 계산
  max_loaded = max(village[f:t])
  temp = min(capacity - max_loaded, box)

  # 그만큼 각 구간에 더하기
  for i in range(f, t):
    village[i] += temp

  result += temp

print(result)
