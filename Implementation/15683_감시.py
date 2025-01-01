import copy
import sys

DX = [-1, 0, 1, 0]  # 상, 우, 하, 좌
DY = [0, 1, 0, -1]
EMPTY = 0
WALL = 6

def main():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    grid = []
    cctvs = []

    for i in range(N):
        row = list(map(int, input().split()))
        grid.append(row)
        for j in range(M):
            if row[j] != WALL and row[j] != EMPTY:
                cctvs.append((i, j, row[j]))

    # 최소 사각지대 크기 초기화
    answer = [float('inf')]

    def get_directions(category, direction):
        if category == 1:
            return [[DX[direction], DY[direction]]]
        elif category == 2:
            return [[DX[direction], DY[direction]], [DX[(direction + 2) % 4], DY[(direction + 2) % 4]]]
        elif category == 3:
            return [[DX[direction], DY[direction]], [DX[(direction + 1) % 4], DY[(direction + 1) % 4]]]
        elif category == 4:
            return [[DX[direction], DY[direction]], [DX[(direction + 1) % 4], DY[(direction + 1) % 4]], [DX[(direction + 2) % 4], DY[(direction + 2) % 4]]]
        elif category == 5:
            return [[DX[0], DY[0]], [DX[1], DY[1]], [DX[2], DY[2]], [DX[3], DY[3]]]
        return []

    def monitor(grid, x, y, directions):
        for dx, dy in directions:
            nx, ny = x, y
            while True:
                nx += dx
                ny += dy
                if nx < 0 or ny < 0 or nx >= N or ny >= M or grid[nx][ny] == WALL:
                    break
                if grid[nx][ny] == EMPTY:
                    grid[nx][ny] = 7

    def count_blind_spots(grid):
        return sum(row.count(EMPTY) for row in grid)

    def dfs(idx, grid):
        if idx == len(cctvs):
            answer[0] = min(answer[0], count_blind_spots(grid))
            return

        x, y, category = cctvs[idx]
        for direction in range(4):
            backup = copy.deepcopy(grid)
            directions = get_directions(category, direction)
            monitor(grid, x, y, directions)
            dfs(idx + 1, grid)
            grid = backup

    dfs(0, grid)
    print(answer[0])

if __name__ == "__main__":
    main()
