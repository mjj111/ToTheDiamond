import sys
input = sys.stdin.readline

def build(tree, x, left, right, is_min):
    if left == right:
        tree[x] = numbers[left]
        return tree[x]

    mid = (left + right) // 2
    left_value = build(tree, 2*x, left, mid, is_min)
    right_value = build(tree, 2*x + 1, mid + 1, right, is_min)

    if is_min:
        tree[x] = min(left_value, right_value)
    else:
        tree[x] = max(left_value, right_value)

    return tree[x]

def find(tree, x, left, right, start, end, is_min):
    if end < left or start > right:
        return float('inf') if is_min else float('-inf')

    if start <= left and end >= right:
        return tree[x]

    mid = (left + right) // 2
    left_value = find(tree, 2*x, left, mid, start, end, is_min)
    right_value = find(tree, 2*x + 1, mid + 1, right, start, end, is_min)

    return min(left_value, right_value) if is_min else max(left_value, right_value)

N, M = map(int, input().split())
numbers = [int(input()) for _ in range(N)]
min_tree = [0] * (4 * N)
max_tree = [0] * (4 * N)

build(min_tree, 1, 0, N-1, True)
build(max_tree, 1, 0, N-1, False)

for _ in range(M):
    start, end = map(int,input().split())
    min_val = find(min_tree, 1, 0, N-1, start-1, end-1, True)
    max_val = find(max_tree, 1, 0, N-1, start-1, end-1, False)
    print(f"{min_val} {max_val}")