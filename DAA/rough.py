import time

def is_safe(board, row, col):
    for i in range(row):
        if board[i] == col or \
        board[i] - i == col - row or \
        board[i] + i == col + row:
            return False
    return True
    


def n_queen(board, row, n):
    if row == n:
        return True
    for col in range(n):
        if is_safe(board, row, col):
            board[row] = col

            if n_queen(board, row + 1, n):
                return True
            board[row] = -1
    return False


def print_board(board, n):
    for row in range(n):
        line = ['Q' if board[row] == col else '.' for col in range(n)]
        print(" ".join(line))


def n_queen_backtrack(n):
    board  = [-1] * n
    if n_queen(board, 0, n):
        print_board(board, n)
    else:
        print("No Solution Found")

start = time.time()
n = int(input("Enter a grid size:"))
n_queen_backtrack(n)

end = time.time()

print(f"Execution Time: {end - start:.6f} Seconds")
