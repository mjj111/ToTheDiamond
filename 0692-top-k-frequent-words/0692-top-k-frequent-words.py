class Solution:
    def add_word(self, trie: Mapping, word: str) -> None:
            root = trie
            for c in word:
                if c not in root:
                    root[c] = {}
                root = root[c]
            root['#'] = {}

    def get_words(self, trie: Mapping, prefix: str) -> List[str]:
            if self.k == 0:
                return []
            res = []

            if '#' in trie:
                self.k -= 1
                res.append(prefix)

            for i in range(26):
                c = chr(ord('a') + i)
                if c in trie:
                    res += self.get_words(trie[c], prefix+c)
            return res

    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        n = len(words)
        cnt = collections.Counter(words)
        bucket = [{} for _ in range(n+1)]
        self.k = k

        for word, freq in cnt.items():
            self.add_word(bucket[freq], word)

        res = []
        for i in range(n, 0, -1):
            if self.k == 0:
                return res

            if bucket[i]:
                res += self.get_words(bucket[i], '')
        return res