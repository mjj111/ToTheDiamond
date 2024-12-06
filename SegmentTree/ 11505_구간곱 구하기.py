N, M, K = map(int, input().split())  # 수 개수, 변경 횟수, 구간의 곱 구하는 횟수
numbers = [int(input()) for _ in range(N)]
tree = [0] * (N * 4)
MOD = 1000000007

def build(x, start, end):
    if start == end:
        tree[x] = numbers[start] % MOD
        return tree[x]

    mid = (start + end) // 2
    left = build(2 * x, start, mid)
    right = build(2 * x + 1, mid + 1, end)

    tree[x] = (left * right) % MOD
    return tree[x]

def update(index, value, x, start, end):
    if start == end:
        tree[x] = value % MOD
        return tree[x]

    mid = (start + end) // 2
    if index <= mid:
        left_value = update(index, value, 2 * x, start, mid)
        right_value = tree[2 * x + 1]
    else:
        left_value = tree[2 * x]
        right_value = update(index, value, 2 * x + 1, mid + 1, end)

    tree[x] = (left_value * right_value) % MOD
    return tree[x]

def find(x, start, end, left, right):
    if start > right or end < left:
        return 1
    if start >= left and end <= right:
        return tree[x]

    mid = (start + end) // 2
    left_value = find(2 * x, start, mid, left, right)
    right_value = find(2 * x + 1, mid + 1, end, left, right)
    return (left_value * right_value) % MOD

build(1, 0, N - 1)

for _ in range(M + K):
    a, b, c = map(int, input().split())
    if a == 1:  # b를 c로 변경
        update(b - 1, c, 1, 0, N - 1)
    elif a == 2:  # b부터 c까지의 곱 출력
        print(find(1, 0, N - 1, b - 1, c - 1))
