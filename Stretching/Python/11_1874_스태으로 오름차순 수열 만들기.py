from collections import deque
n= int(input())
numbers = list(int(input()) for _ in range(n))

dq = deque()
resut = True
num = 1
for number in numbers:
  if number > num:
    while number >= num:
      dq.append(num)
      num+=1
      print("+")
    dq.pop()
    print("-")
  else :
    nn = dq.pop()
    if nn >= num :
      print("NO")
      result = False
      break
    else :
      print("-")