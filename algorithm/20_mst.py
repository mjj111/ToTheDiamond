# 간선의 개수가 작은 경우에는 크루스칼, 간선의 개수가 많은 경우에는 프림.
'''
백준 1197번 최소 스패닝 트리
'''
import sys
sys.setrecursionlimit(1000)

V, E = map(int, input().split())

edges = []
for _ in range(E):
  A, B, C = map(int, input().split())
  edges.append((C, A, B))
edges.sort()

parent = [i for i in range(V+1)]

def find(son):
  if parent[son] == son:
    return son
  parent[son] = find(parent[son])
  return parent[son]

def union(son1, son2):
  parent1 = find(son1)
  parent2 = find(son2)
  if parent1 < parent2 : parent1, parent2 = parent2, parent1
  parent[parent2] = parent1

answer = 0
for cost, node1, node2 in edges:
  if find(node1) == find(node2):
    continue
  union(node1, node2)
  answer += cost

print(answer)