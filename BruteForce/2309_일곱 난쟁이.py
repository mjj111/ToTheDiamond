numbers = [int(input()) for i in range(9)]

total = sum(numbers)

for i in range(9):
    for j in range(i+1,9):

        if 100 == total - (numbers[i] + numbers[j]):
            left, right =numbers[i],numbers[j]

            numbers.remove(left)
            numbers.remove(right)
            numbers.sort()

            for num in numbers:
                print(num)
            break

    if len(numbers)<9:
        break