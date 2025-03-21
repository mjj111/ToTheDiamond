import heapq
from collections import defaultdict
from typing import List

class Solution:
    def reachableNodes(self, edges: List[List[int]], maxMoves: int, n: int) -> int:
        graph = defaultdict(dict)
        for u, v, w in edges:
            graph[u][v] = w
            graph[v][u] = w

        pq = [(-maxMoves, 0)]  # (남은 이동 횟수, 현재 노드)
        dist = {}  # 최단 경로 저장 (노드별 최대 이동 가능 거리)

        while pq:
            moves, node = heapq.heappop(pq)
            moves = -moves 
            
            if node in dist:
                continue
            dist[node] = moves 

            for nxt, cost in graph[node].items():
                if nxt in dist:
                    continue

                next_moves = moves - (cost + 1)
                if next_moves >= 0: 
                    heapq.heappush(pq, (-next_moves, nxt))

        reachable_nodes = len(dist)  

        for u, v, w in edges:
            moves_from_u = dist.get(u, 0)
            moves_from_v = dist.get(v, 0)
            reachable_nodes += min(w, moves_from_u + moves_from_v)

        return reachable_nodes