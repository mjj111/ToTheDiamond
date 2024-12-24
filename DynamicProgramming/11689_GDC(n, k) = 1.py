N = int(input())
answer = N
i = 2

while i * i <= N:
    if N % i == 0:
        while N % i == 0:
            N //= i
        answer -= answer / i
    i += 1

if N > 1:
    answer -= answer / N

print(int(answer))