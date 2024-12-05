def find(cards, given):
    start = 0
    end = len(cards)

    while(start <= end):
        mid = (start + end) // 2
        value = cards[mid]

        if(value <= given):
            start = mid + 1
        else :
            end = mid-1
    return start

N, M, K = map(int, input().split())
cards = list(map(int,input().split()))
cards.sort()
givens = list(map(int,input().split()))

visited = [False] * (len(cards) + 1)

for given in givens :
    right = find(cards, given)

    while True:
        if(visited[right]):
            right+=1
        else :
            break

    visited[right] = True
    print(cards[right])