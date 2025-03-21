'''
백준 2343 번 블루레이 만들기

이진 검색은 매우 유용하다. 그러나 단순 검색으로 쓰이지는 않고
특정 영역에서, 조건에 부합한 영역에서 최대나 최소를 찾을 때 주로 쓰인다.
검색된 부합한 영역에서 최소를 찾는다면 start, 최대를 찾는다면 end를 쓰면 된다.

기본적으로 정렬이된 배열에서 동작한다면 logN이며
중요한 것은 검색 영역을 선택하기 위해 쓰이는 동작의 시간복잡도다.
영역을 어떻게 움직일 지에 대한 조건은 mid 에의한 동작에 의해 이뤄진다.

'''

def get_c(mid) :
  total = 0
  count = 1
  for t in time:
    if total + t > mid:
      count += 1
      total = 0
    total += t
  return count

n, m = map(int,input().split())
time = list(map(int,input().split()))

start = max(time)
end = sum(time)

while start <= end:
  mid = (start + end) // 2
  count = get_c(mid)

  #최소 값을 구할 때
  if count <= m:
    end = mid - 1
  else:
    start = mid + 1

  # #최대 값을 구할 때
  # if count >= m:
  #   start = mid + 1
  # else:
  #   end = mid - 1
  # # print(end)
print(start)