'''
백준 19585번 전설
'''
def build_trie(colors):
  trie = {}
  for color in colors:
    current_node = trie

    for c in color:
      if c not in current_node:
        current_node[c] = {}
      current_node = current_node[c]
    current_node['end'] = True

  return trie

def is_valid_team(team, color_trie, nicknames):
  current_node = color_trie

  for i in range(len(team)):
    if 'end' in current_node and team[i:] in nicknames:
      return True

    if team[i] not in current_node:
      return False

    current_node = current_node[team[i]]
  return False

C, N = map(int, input().split())

colors = [input() for _ in range(C)]
color_trie = build_trie(colors)

nicknames = set(input() for _ in range(N))

T = int(input())
for _ in range(T):
  team = input()

  if is_valid_team(team, color_trie, nicknames):
    print("Yes")
  else:
    print("No")