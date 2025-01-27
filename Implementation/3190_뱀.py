from collections import deque
import sys
input = sys.stdin.read
APPLE = 3
dx = [-1, 0, 1, 0]  # 상, 우, 하, 좌
dy = [0, 1, 0, -1]

def main():
  N = int(input())
  K = int(input())

  board = [[0] * (N + 1) for _ in range(N + 1)]

  for i in range(2, 2 + K):
    x, y = map(int,input().split())
    board[x][y] = APPLE

  L = int(input())
  direction_changes = {}
  for i in range(3 + K, 3 + K + L):
    time, direction = map(int, input().split())
    direction_changes[int(time)] = direction

  snake = deque([(1, 1)])
  snake_body = {(1, 1)}

  current_direction = 1  # 초기 방향: 오른쪽
  time_passed = 0

  while True:
    time_passed += 1

    head_x, head_y = snake[0]
    new_x, new_y = head_x + dx[current_direction], head_y + dy[current_direction]

    # 종료 조건: 벽 또는 자기 몸과 충돌
    if not (1 <= new_x <= N and 1 <= new_y <= N) or (new_x, new_y) in snake_body:
      break

    # 이동 처리
    snake.appendleft((new_x, new_y))
    snake_body.add((new_x, new_y))

    # 사과 여부 확인
    if board[new_x][new_y] == APPLE:
      board[new_x][new_y] = 0
    else:
      tail_x, tail_y = snake.pop()
      snake_body.remove((tail_x, tail_y))

    # 방향 전환
    if time_passed in direction_changes:
      new_direction = direction_changes[time_passed]
      if new_direction == 'L':
        current_direction = (current_direction + 3) % 4  # 좌회전
      elif new_direction == 'D':
        current_direction = (current_direction + 1) % 4  # 우회전

  print(time_passed)

if __name__ == "__main__":
  main()