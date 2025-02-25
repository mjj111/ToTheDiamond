import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

N = int(input())

def prime(num):
  for i in range(2, int(num**(1/2))+1):
    if num % i == 0:
      return False
  else:
    return True

def dfs(n):
  if len(str(n)) == N:
    print(n)
  else:
    for i in range(1,10,2):
      if prime(10 * n + i):
        dfs(10 * n + i)
      else:
        pass

dfs(2)
dfs(3)
dfs(5)
dfs(7)
