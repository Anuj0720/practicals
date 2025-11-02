import time

def dp_knapsack(value, weight, capacity):
    n = len(value)
    dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]
    for i in range(1, n  + 1):
        for w in range(1, capacity + 1):
            if weight[i - 1] <= w:
                dp[i][w] = max(value[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w])
            else:
                dp[i][w] = dp[i - 1][w]
    
    return dp[n][capacity]

n = int(input("Enter total number of items: "))

value = []
weight = []

for i in range(n):
    v = int(input(f"Enter value of item {i + 1}: "))
    w = int(input(f"Enter weight of item {i + 1}: "))
    value.append(v)
    weight.append(w)

max_capacity = int(input("Enter capacity of the knapsack: "))

# Start Time
start = time.time()

max_value = dp_knapsack(value, weight, max_capacity)
print(f"\nMaximum value in knapsack = {max_value:.2f}")

# End Time
end = time.time()

print(f"Execution Time: {end - start:.6f} Seconds")