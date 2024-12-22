import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
M = int(input())

time = [0] * (N+1)
in_degree = [0] * (N+1)
cnt = [[] for _ in range(N+1)]

graph = [[] for _ in range(N+1)]
bgraph = [[] for _ in range(N+1)]
in_degree = [0] * (N+1)
for _ in range(M):
    start, end, cost = map(int, input().split())
    graph[start].append((cost, end))
    bgraph[end].append(start)
    in_degree[end] += 1

start_city, destination_city = map(int, input().split())

q = deque([])
q.append(start_city)

while q:
    now = q.popleft()

    for next in graph[now]:
        n_cost = next[0]
        n_city = next[1]

        in_degree[n_city] -= 1
        if in_degree[n_city] == 0:
            q.append(n_city)

        #시간 단축
        if time[n_city] < time[now] + n_cost:
            time[n_city] = time[now] + n_cost

            cnt[n_city] = [now]

        # 같은 시간
        elif time[n_city] == time[now] + n_cost:
            cnt[n_city].append(now)


q = deque([destination_city])
route = set()
while q:
    now = q.popleft()
    for x in cnt[now]:
        if (now, x) not in route:
            route.add((now, x))
            q.append(x)

print(time[destination_city])
print(len(route))