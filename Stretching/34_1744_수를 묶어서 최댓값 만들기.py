import sys
input = sys.stdin.readline
from queue import PriorityQueue

pq = PriorityQueue()
mq = PriorityQueue()
one=0
zero=0

n=int(input())
for _ in range(n):
  data=int(input())
  if data>1:
    pq.put(data*-1)
  elif data==1:
    one+=1
  elif data==0:
    zero+=1
  else:
    mq.put(data)


sum=0

while pq.qsize() > 1:
  tmp= pq.get()*pq.get()
  sum+=tmp

if pq.qsize() > 0:
  sum+=pq.get()*-1

while mq.qsize() > 1:
  tmp = mq.get()*mq.get()
  sum += tmp

if mq.qsize() > 0:
  if zero==0:
    sum+=mq.get()