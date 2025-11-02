import time

def fractional_knapsack(value, weight, capacity):
    ratio = []
    for i in range(len(value)):
        ratio.append(value[i] / weight[i])

    # Combine all lists and sort by ratio in descending order
    items = list(zip(value, weight, ratio))
    items.sort(key=lambda x: x[2], reverse=True)

    total_value = 0
    remaining_capacity = capacity

    for v, w, r in items:
        if remaining_capacity == 0:
            break

        if w <= remaining_capacity:
            total_value += v
            remaining_capacity -= w
            print(f"Take full item (value={v}), (weight={w})")

        else:
            fraction = remaining_capacity / w
            total_value += v * fraction
            print(f"Take {fraction * 100:.2f}% of item (value={v}), (weight={w})")
            remaining_capacity = 0  # bag is full

    return total_value


n = int(input("Enter total number of items: "))

value = []
weight = []

for i in range(n):
    v = float(input(f"Enter value of item {i + 1}: "))
    w = float(input(f"Enter weight of item {i + 1}: "))
    value.append(v)
    weight.append(w)

max_capacity = float(input("Enter capacity of the knapsack: "))

# Start Time
start = time.time()

max_value = fractional_knapsack(value, weight, max_capacity)
print(f"\nMaximum value in knapsack = {max_value:.2f}")

# End Time
end = time.time()

print(f"Execution Time: {end - start:.6f} Seconds")