import sys

input = sys.stdin.readline
min, max = map(int,input().split())

limit = int(max**0.5)
num_set = set()

for i in range(2, limit+1):
  roop = (min//i**2)*(i**2)
  if roop < min:
    roop += i**2

  for r in range(roop, max+1, i**2):
    num_set.add(r)

print(max-min-(len(num_set))+1)