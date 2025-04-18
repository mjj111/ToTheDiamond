n = int(input())

print(2**n -1)

def hanoi(n, start, mid, to):
  if n == 1:
    print(f"{start} {to}")
    return
  hanoi(n - 1, start, to, mid)
  print(f"{start} {to}")
  hanoi(n - 1, mid, start, to)

hanoi(n, 1, 2, 3)