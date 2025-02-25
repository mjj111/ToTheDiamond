prefix = input()
arr = prefix.split("-")

result = 0

for i in range(len(arr)):
  arr2 = list(map(int, arr[i].split("+")))
  print(arr2)

  if i == 0:
    result += sum(arr2)
  else:
    result -= sum(arr2)

print(result)