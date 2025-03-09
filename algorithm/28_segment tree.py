'''
백준 2043 구간합 구하기

세그먼트 트리는 특정 구간의 합을 빠르게 구할 수 있도록 도와준다.
세그먼트 트리는 트리 구조를 사용하여 구간합을 저장하며,O(N)
트리의 각 노드는 특정 구간의 합을 나타낸다.
트리를 구축한 후에는 구간 합을 빠르게 찾거나 O(logN), 특정 원소를 업데이트 O(logN)할 수 있다.

해당 코드는 직접 노드 클래스를 사용하지않고, 배열에 저장한 트리형태이기 떄문에
현재에서 2로 나누면 부모로 가며
왼쪽자식노드는 2*n 오른쪽 자식 노드는 2*n+1 로 접근하면 된다.

재밌는 점은 find에서
현재 찾고자 하는 영역의 왼쪽과 오른쪽에 해당하는 노드를 만났을 때 수거하는 노드의값 조건이다.
  if start <= left and end >= right:
    return tree[x]
현재 찾고자 하는 영역의 내부에 속한다면? 그냥 현재 노드 값을 반환하면 된다.
그렇지 않다면 다시 현재 노드를 분기점으로 하고 재귀로 접근한다.
  return find(2*x, left, mid, start, end) + find(2*x+1, mid+1, right, start, end)

'''

import sys
input = sys.stdin.readline

N, M, K = map(int, input().split())
numbers = [int(input()) for _ in range(N)]
tree = [0] * (4 * N)

def build(x, left, right):
  if left == right:
    tree[x] = numbers[left]
    return tree[x]

  mid = (left + right) // 2
  tree[x] = build(2*x, left, mid) + build(2*x+1, mid+1, right)
  return tree[x]

def find(x, left, right, start, end):
  if end < left or start > right:
    return 0
  if start <= left and end >= right:
    return tree[x]

  mid = (left + right) // 2
  return find(2*x, left, mid, start, end) + find(2*x+1, mid+1, right, start, end)

def update(x, left, right, index, value):
  if left == right:
    tree[x] = value
    return
  if index < left or index > right:
    return

  mid = (left + right) // 2
  update(2*x, left, mid, index, value)
  update(2*x+1, mid+1, right, index, value)

  tree[x] = tree[2*x] + tree[2*x+1]

build(1, 0, N-1)

for _ in range(M + K):
  a, b, c = map(int, input().split())
  if a == 1:
    update(1, 0, N-1, b-1, c)
  else:
    print(find(1, 0, N-1, b-1, c-1))
