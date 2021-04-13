def solution(board, moves):
    answer = 0
    basket = []

    for m in moves:
        doll = 0
        for n in range(len(board)):
            if board[n][m - 1] != 0:
                doll = board[n][m - 1]
                board[n][m - 1] = 0
                break
        if doll != 0:  # 크레인에 인형이 있다면,
            if not basket:  # 바구니가 비어있다면,
                basket.append(doll)
            else:
                if basket[-1] == doll:
                    basket.pop()
                    answer += 2;
                else:
                    basket.append(doll)
    return answer