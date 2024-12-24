import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

N = int(input())
numbers = list(map(int, input().split()))
tree = [0] * (N * 4)

def build(x, start, end):
    if start == end:
        tree[x] = (numbers[start], start)
        return tree[x]

    mid = (start + end) // 2
    left = build(2 * x, start, mid)
    right = build(2 * x + 1, mid + 1, end)

    if left[0] <= right[0]:
        tree[x] = left
    else:
        tree[x] = right
    return tree[x]

def update(index, value, x, start, end):
    if start == end:
        tree[x] = (value, index)
        return tree[x]

    mid = (start + end) // 2
    if index <= mid:
        left = update(index, value, 2 * x, start, mid)
        right = tree[2 * x + 1]
    else:
        left = tree[2 * x]
        right = update(index, value, 2 * x + 1, mid + 1, end)

    if left[0] <= right[0]:
        tree[x] = left
    else:
        tree[x] = right

    return tree[x]

def find(x, start, end, left, right):
    if start > right or end < left:
        return (float('inf'), -1)

    if start >= left and end <= right:
        return tree[x]

    mid = (start + end) // 2
    left_value = find(2 * x, start, mid, left, right)
    right_value = find(2 * x + 1, mid + 1, end, left, right)

    if left_value[0] <= right_value[0]:
        return left_value
    else:
        return right_value

build(1, 0, N - 1)

query_count = int(input())
output = []
for _ in range(query_count):
    q_type, a, b = map(int, input().split())
    if q_type == 1:
        index = a - 1
        new_value = b
        update(index, new_value, 1, 0, N - 1)
    else:
        left = a -1
        right = b -1
        result = find(1, 0, N - 1, left, right)
        print(result[1] + 1)