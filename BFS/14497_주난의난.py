import heapq

def dijkstra():
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    checked = [[False] * (M + 1) for _ in range(N + 1)]
    pq = []
    heapq.heappush(pq, (0, curR, curC))  # (시간, 행, 열)
    checked[curR][curC] = True

    while pq:
        time, row, col = heapq.heappop(pq)

        if row == thiefR and col == thiefC:
            print(time)
            return

        for dr, dc in directions:
            nextR, nextC = row + dr, col + dc

            if nextR <= 0 or nextR > N or nextC <= 0 or nextC > M or checked[nextR][nextC]:
                continue

            checked[nextR][nextC] = True
            next_time = time if map[nextR][nextC] == '0' else time + 1
            heapq.heappush(pq, (next_time, nextR, nextC))

if __name__ == "__main__":
    import sys
    input = sys.stdin.read
    data = input().splitlines()

    N, M = map(int, data[0].split())
    curR, curC, thiefR, thiefC = map(int, data[1].split())
    map = [[''] * (M + 1) for _ in range(N + 1)]

    for i in range(1, N + 1):
        line = data[i + 1]
        for j in range(1, M + 1):
            map[i][j] = line[j - 1]

    dijkstra()
