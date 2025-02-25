import math

min_value, max_value = map(int, input().split())
Check = [False] * (max_value - min_value + 1)

for i in range(2, int(math.sqrt(max_value) + 1)):
  pow = i * i
  start_index = int(min_value / pow)
  if min_value % pow != 0:
    start_index += 1
  for j in range(start_index, int(max_value / pow) + 1):
    Check[int((j * pow) - min_value)] = True

count = 0

for i in range(0, max_value - min_value + 1):
  if not Check[i]:
    count += 1

print(count)