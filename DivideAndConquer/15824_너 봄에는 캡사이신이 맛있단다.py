import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

def pow(a, b) :
    if b == 0 : return 1
    if b == 1 : return a

    divided = pow(a, b//2) % MOD

    if b % 2 == 0 : return (divided * divided) % MOD
    return (divided * divided) * a % MOD

MOD = 1000000007

n = int(input())
numbers = list(map(int, input().split()))
numbers.sort()

answer = 0
for i in range(n):
    answer = (answer + (numbers[i] * (pow(2, i) - pow(2, n - i - 1))) % MOD) % MOD

print(answer)