def count_broken(eggs):
  return sum(1 for hp, _ in eggs if hp <= 0)


def dfs(current, eggs):
  global max_broken

  if current == n:
    count = count_broken(eggs)
    max_broken = max(max_broken, count)
    return

  # 현재 계란이 깨졌으면 다음 계란으로
  if eggs[current][0] <= 0:
    dfs(current + 1, eggs)
    return

  is_hit = False
  for target in range(n):
    if target == current : continue
    if eggs[target][0] <= 0: continue

    is_hit = True
    eggs[current][0] -= eggs[target][1]
    eggs[target][0] -= eggs[current][1]

    dfs(current + 1, eggs)

    eggs[current][0] += eggs[target][1]
    eggs[target][0] += eggs[current][1]

  # 칠 계란이 없으면 그냥 넘김
  if not is_hit:
    dfs(current + 1, eggs)


n = int(input())
eggs = [list(map(int, input().split())) for _ in range(n)]

max_broken = 0
dfs(0, eggs)
print(max_broken)
