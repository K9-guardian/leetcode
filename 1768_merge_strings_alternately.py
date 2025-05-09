class Solution(object):
    def mergeAlternately(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: str
        """
        interleaved = ''.join([c for p in zip(word1, word2) for c in p])
        if len(word1) > len(word2):
            interleaved = interleaved + word1[len(word2):]
        elif len(word2) > len(word1):
            interleaved = interleaved + word2[len(word1):]
        return interleaved
