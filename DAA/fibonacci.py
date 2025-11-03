import time

# Recursive
def fib_recursive(n):
    if n <= 1:
        return n
    else:
        return fib_recursive(n - 1) + fib_recursive(n - 2)


n = int(input("Enter n: "))

r_start = time.time()
print(f"Fibonacci({n}) =", fib_recursive(n))
r_end = time.time()

print(f"Execution time of recursive fibonacci: {r_end - r_start:.6f}")


def fib_iterative(n):
    if n <= 1:
        return n
    
    a, b = 0, 1
    for i in range(2, n + 1):
        c = a + b
        a = b
        b = c
    return b

m = int(input("Enter m: "))

i_start = time.time()
print(f"Fibonacci({m}) =", fib_iterative(m))
i_end = time.time()

print(f"Execution time of recursive fibonacci: {i_end - i_start:.6f}")