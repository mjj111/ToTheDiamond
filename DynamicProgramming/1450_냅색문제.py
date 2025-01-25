import bisect

def comb(arr, start, end, sum_val, c, result):
  if sum_val > c:
    return
  if start == end:
    result.append(sum_val)
    return

  comb(arr, start + 1, end, sum_val, c, result)
  comb(arr, start + 1, end, sum_val + arr[start], c, result)

def upperbound(arr, val, c):
  idx = bisect.bisect_right(arr, c - val)
  return idx - 1

def main():
  n, c = map(int, input().split())
  arr = list(map(int, input().split()))

  left = []
  comb(arr, 0, n // 2, 0, c, left)

  right = []
  comb(arr, n // 2, n, 0, c, right)
  right.sort()

  cnt = 0
  for val in left:
    idx = upperbound(right, val, c)
    cnt += idx + 1

  print(cnt)

if __name__ == "__main__":
  main()
