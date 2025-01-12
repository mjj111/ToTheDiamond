from collections import deque

def bfs(n):
  q = deque([n])
  visited[n][0] = 0
  visited[n][1] = 1

  while q:
    x = q.popleft()

    for i in [x - 1, x + 1, x * 2]:
      if 0 <= i <= 100000:
        if visited[i][0] == -1: # 처음 도달 시
          visited[i][0] = visited[x][0] + 1 # 걸린 시간 저장 +=1
          visited[i][1] = visited[x][1] #같은 경우이기 때문에(최초) 경우의 수 갱신
          q.append(i)

        elif visited[i][0] == visited[x][0] + 1: # 처음이 아니고 (하지만 최단 시간이라면) 이전+=1 지금과 같다면 최단시간이다.
          visited[i][1] += visited[x][1] # 최단 시간이 걸린  경우의 수 합

n, k = map(int, input().split())
visited = [[-1, 0] for _ in range(100001)]

bfs(n)
print(visited[k][0])
print(visited[k][1])