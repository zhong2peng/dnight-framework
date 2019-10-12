/**
 * @author ZHONGPENG769
 * @date 2019/10/12
 */
public class Solution {

    /**
     * You are playing the following Nim Game with your friend: There is a heap of stones on the table,
     * each time one of you take turns to remove 1 to 3 stones.
     * The one who removes the last stone will be the winner.
     * You will take the first turn to remove the stones.
     * <p>
     * Both of you are very clever and have optimal strategies for the game.
     * Write a function to determine whether you can win the game given the number of stones in the heap.
     * <p>
     * Example:
     * <p>
     * Input: 4
     * Output: false
     * Explanation: If there are 4 stones in the heap, then you will never win the game;
     * No matter 1, 2, or 3 stones you remove, the last stone will always be
     * removed by your friend.
     *
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        //  we can find f(x - 4) is a critical point, if f(x-4) is false, then f(x) will be always false.
        //we can also find out the initial conditions, f(1), f(2), f(3) will be true (A always win), and f(4) will be false. so
        //based on previous equation and initial conditions f(5) = f(6) = f(7) = true, f(8) = false;
        //obviously, f(1), f(2), f(3) can make all f(4n + 1), f(4n + 2), f(4n + 3) to be true, only f(4n) will be false then.
        //so here we go our one line solution:
        //
        //return (n % 4 != 0);


//       return (canWinNim(n-2)&&canWinNim(n-3)&&canWinNim(n-4))
//
//               || (canWinNim(n-3)&&canWinNim(n-4)&& canWinNim(n-5))
//               || (canWinNim(n-4)&&canWinNim(n-5)&&canWinNim(n-6));
        return n % 4 != 0;
    }

}
