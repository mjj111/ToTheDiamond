import sys

input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))

res = []
for i in range(n - 1, 0, -1):
    temp = arr[i : n] + arr[ : i]
    cnt = 0
    start = -1
    for j in range(n - 1):

        if (0 < temp[j] - 1 == temp[j + 1]) or (temp[j] - 1 == 0 and temp[j + 1] == n):
            cnt += 1

            if start == -1:
                start = j

    if cnt > 0:
        res.append((start, cnt, i))

res.sort(key=lambda x : (-(x[1] - x[0])))

arr = arr[res[0][2] : n] + arr[ : res[0][2]]
arr = arr[:res[0][0]] + arr[res[0][0] : res[0][1] + 1][::-1] + arr[res[0][1] + 1 : n]
idx = arr.index(1)

print(n - idx)
print(res[0][0] + 1, res[0][1] + 1)
print(n - res[0][2])