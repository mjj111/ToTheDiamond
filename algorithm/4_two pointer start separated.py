'''
백준 1940 번 주몽의 명령

투 포인터는 보통 정렬된 상태에서 실행한다.

특정 포인터 두 개의 값들의 합 혹은 차을 고려할 때는
두 포인터를 모두 양 끝에 분리한 상태로 시작한다.

참고로, 이러한 모인상태에서 시작하다가, 조건에 도달할 경우 양쪽 모두 한 칸씩 움직이면 된다.
'''
n = int(input())
m = int(input())
numbers = list(map(int, input().split()))

numbers.sort()

start = 0
end = n-1

answer = 0
while -1 < start < end < n :
  s = numbers[start] + numbers[end]

  if s == m:
    start += 1
    end -= 1
    answer += 1

  elif s < m:
    start += 1

  elif s > m:
    end -= 1

print(answer)