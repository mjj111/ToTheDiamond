'''
백준 2018 번 연속된 자연수의 합 구하기

투 포인터는 보통 정렬된 상태에서 실행한다.

특정 포인터 사이의 값의 합을 고려할 때는
두 포인터를 모두 모인상태로 시작한다.

참고로, 이러한 모인상태에서 시작하다가, 조건에 도달할 경우 오른쪽만 한 칸 움직이면 된다.
'''
n = int(input())
start = 1
end = 2
s = start + end

answer = 0
while start < end < n :
  if s == n:
    end += 1
    s += end
    answer += 1

  elif s < n:
    end += 1
    s += end

  elif s > n:
    s -= start
    start += 1

print(answer+1)
