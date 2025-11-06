import heapq
import time
def huffman_encoding(text):
    # Count frequency 
    freq = {}
    for ch in text:
        if ch in freq:
            freq[ch] += 1
        else:
            freq[ch] = 1
    
    # Huffman Tree
    heap = [[weight, [char, ""]] for char, weight in freq.items()]
    heapq.heapify(heap)

    if len(heap) == 1:
        char = heap[0][1][0]
        return [[char, "0"]]

    # Assign Binary Codes
    while len(heap) > 1:
        low1 = heapq.heappop(heap)
        low2 = heapq.heappop(heap)

        for pair in low1[1:]:
            pair[1] = '0' + pair[1]
        for pair in low2[1:]:
            pair[1] = '1' + pair[1]
        
        heapq.heappush(heap, [low1[0] + low2[0]] + low1[1:] + low2[1:])

    # Extract Huffman codes
    huffman_code = heapq.heappop(heap)[1:]
    return huffman_code

start = time.time()

text = input("Enter a text: ")
codes = huffman_encoding(text)

end = time.time()

print("Character | Huffman Code")
print("------------------------")
for ch in set(text):
    for symbol, code in codes:
        if symbol == ch:
            print(f"    {ch}     |    {code}")
            break

print(f"Execution Time: {end - start:.6f} Seconds")
