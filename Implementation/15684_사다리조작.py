n, m, h = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(m)]
map = [[0] * (n + 1) for _ in range(h + 1)]

for x, y in data:
    map[x][y] = 1
    map[x][y + 1] = 2

answer = [4]

def dfs(x, count):
    if answer[0] <= count:
        return
    if check():
        answer[0] = count
        return

    for i in range(x, h + 1):
        for j in range(1, n):
            if map[i][j] == 0 and map[i][j + 1] == 0:
                # 사다리 추가
                map[i][j] = 1
                map[i][j + 1] = 2
                dfs(i, count + 1)
                # 사다리 제거
                map[i][j] = map[i][j + 1] = 0

def check():
    for i in range(1, n + 1):
        y = i
        for x in range(1, h + 1):
            if map[x][y] == 1:
                y += 1
            elif map[x][y] == 2:
                y -= 1
        if y != i:
            return False
    return True

dfs(1, 0)

print(answer[0] if answer[0] != 4 else -1)
