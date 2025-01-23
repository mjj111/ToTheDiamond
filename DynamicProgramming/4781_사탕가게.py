
def main():
  while True:
    n, m = map(float, input().split())
    n = int(n)
    m = round(m * 100)  # 달러를 센트 단위로 변환

    if n == 0 and m == 0:
      break

    costs = []
    cals = []
    for _ in range(n):
      cal, cost = map(float, input().split())
      cals.append(int(cal))
      costs.append(round(cost * 100))  # 비용을 센트 단위로 변환

    # dp[i]: i 센트로 얻을 수 있는 최대 칼로리
    dp = [0] * (m + 1)

    for i in range(n):
      now_cost = costs[i]
      now_cal = cals[i]

      for j in range(now_cost, m + 1):
        dp[j] = max(dp[j], dp[j - now_cost] + now_cal)

    print(max(dp))

if __name__ == "__main__":
  main()
