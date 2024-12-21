n = int(input())
result = [0] * 10

num = 1

def one_digit(number):
    while number % 10 != 9:
        for i in str(number):
            result[int(i)] += num
        number -= 1

    return number


while n > 0:
    n = one_digit(n)

    if n < 10:
        for i in range(n+1):
            result[i] += num
    else:
        for j in range(10):
            result[j] += (n//10 + 1) * num

    result[0] -= num
    num *= 10
    n //= 10


for i in result:
    print(i, end = ' ')