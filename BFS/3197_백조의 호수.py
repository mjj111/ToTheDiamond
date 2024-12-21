from collections import deque
import sys

input = sys.stdin.readline
def is_valid(r, c):
    return 0 <= r < R and 0 <= c < C

R, C = map(int, input().split())

waterQ = deque()
q = deque()
swan = []

map_data = []
visited = [[False] * C for _ in range(R)]

for r in range(R):
    line = list(input().strip())
    map_data.append(line)
    for c in range(C):
        if line[c] == 'L':
            swan.append((r, c))
        if line[c] != 'X':
            waterQ.append((r, c))

q.append(swan[0])
visited[swan[0][0]][swan[0][1]] = True

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
day = 0
meet = False

while True:
    next_q = deque()
    while q:
        r, c = q.popleft()

        if (r, c) == swan[1]:
            meet = True
            break

        for dr, dc in directions:
            nr, nc = r + dr, c + dc

            if not is_valid(nr, nc) or visited[nr][nc]:
                continue

            visited[nr][nc] = True

            if map_data[nr][nc] == 'X':
                next_q.append((nr, nc))
            else:
                q.append((nr, nc))

    if meet:
        break

    q = next_q

    for _ in range(len(waterQ)):
        r, c = waterQ.popleft()

        for dr, dc in directions:
            nr, nc = r + dr, c + dc

            if not is_valid(nr, nc):
                continue

            if map_data[nr][nc] == 'X':
                map_data[nr][nc] = '.'
                waterQ.append((nr, nc))

    day += 1

print(day)