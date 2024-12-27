from collections import deque

def bfs(n, k):
    if n == k:
        return 0

    visited = [set(), set()]  # 짝수, 홀수 시간
    time = 0
    queue = deque([n])
    visited[time % 2].add(n)

    while queue:
        if k > 500000:
            return -1

        if k in visited[time % 2]:
            return time

        for _ in range(len(queue)):
            now = queue.popleft()
            next_time = (time + 1) % 2

            next_pos = now - 1
            if can_go(next_pos, next_time, visited):
                visited[next_time].add(next_pos)
                queue.append(next_pos)

            next_pos = now + 1
            if can_go(next_pos, next_time, visited):
                visited[next_time].add(next_pos)
                queue.append(next_pos)

            next_pos = now * 2
            if can_go(next_pos, next_time, visited):
                visited[next_time].add(next_pos)
                queue.append(next_pos)

        time += 1
        k += time

    return -1

def can_go(next_pos, next_time, visited):
    return 0 <= next_pos <= 500000 and next_pos not in visited[next_time]

if __name__ == "__main__":
    n, k = map(int, input().split())
    print(bfs(n, k))
