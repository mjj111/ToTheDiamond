N = int(input())
rows = [0] * N

for i in range(N):
    coins = input().strip()
    for j in range(N):
        if coins[j] == 'T':
            rows[i] |= 1 << j

def masking(row):
    global rows
    mask = (1 << N) - 1

    for i in range(N):
        if row & (1 << i):
            rows[i] = ~(rows[i] ^ mask) & mask

def cal_value(row):
    value = 0
    masking(row)
    for i in range(N):
        cols = 0
        for j in range(N):
            if rows[j] & (1 << i):
                cols += 1
        value += min(cols, N - cols)
    masking(row)
    return value

ans = N ** 2
for i in range(1 << N):
    ans = min(ans, cal_value(i))
print(ans)
