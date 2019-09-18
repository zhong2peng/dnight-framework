import java.util.Arrays;

/**
 * @author ZHONGPENG769
 * @date 2019/9/18
 */
public class Solution {

    /**
     * 公主(P)被恶魔抓走了！她被囚禁在了地牢的右下角。地牢由二维平面上的M×N个房间组成。骑士(K)的起始位置在地图的左上角，
     * 他必须一路穿过地牢的房间去拯救位于右下角的公主。
     * <p>
     * 骑士起始的时候有一定数量的生命值。如果在任意时刻，骑士的血量低于或者等于零，他会立即死去。
     * <p>
     * 有一些房间是由恶魔把守的，骑士进入这些房间会损失掉一定数量的生命值(负整数)，
     * 其他房间可能是空的(零)也有可能有魔法药水来帮助他增加生命值(正整数)。
     * <p>
     * 为了尽可能快的营救公主，骑士决定每次移动只向右和向下两个方向走。
     * <p>
     * 请写一个函数来计算骑士营救公主所需要的最少血量。
     * <p>
     * 例如，给出地牢的地图如下所示，骑士初始情况下最少需要7滴血量才可营救公主，移动方向为右->右->下->下。
     * <p>
     * -2(K)	-3	  3
     * -5	   -10	  1
     * 10	  30	-5(P)
     * 注意：
     * <p>
     * 骑士的血量没有上限；
     * 任意的房间都有可能存在威胁或者补给，包括骑士初始位于的房间，以及公主所在的房间。
     * <p>
     * 假设骑士位于坐标为(i, j)的位置上，如果我们想要知道从这一点出发到达公主所在的房间所需要的最少血量(记为dp[i][j])的话，与哪些因素有关系呢？因为骑士只能向右或者向下走，因此该值取决于三个方面：
     * <p>
     * 骑士从坐标(i+1,j)出发到达公主所在的房间所需要的最少血量，dp[i+1][j]；
     * 骑士从坐标(i,j+1)出发到达公主所在的房间所需要的最少血量，dp[i][j+1]；
     * 坐标(i,j)所在的房间中包含的补给或威胁对应的数值，dungeon[i][j]。
     * 分析到这里，其实可以看出动态规划转移方程的雏形了，具体描述如下：
     * <p>
     * dp[i][j]=max(1,min(dp[i+1][j],dp[i][j+1])−dungeon[i][j])
     * 其中，min(dp[i+1][j],dp[i][j+1])表示从向右或者向下的道路中选择所需血量较少的那一条路前进，因为房间中可能有怪物或者补给，所以得到的值需要减去这个房间中补给或怪物对应的数值dungeon[i][j]，又因为骑士的血量不能低于1，因此还需要执行max函数来保证dp[i][j]大于等于1。
     * <p>
     * 然后根据动态规划转移方程从右向左、从下到上依次计算，最后得到的dp[0][0]即为所求。
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] health = new int[m][n];
        // Q的活命，生命值
        health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

        // 最后一列，倒数第二行，只能往左
        for (int i = m - 2; i >= 0; i--) {
            health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        // 最后一行，倒数第二列，只能往上
        for (int j = n - 2; j >= 0; j--) {
            health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        // 剩余部分
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                health[i][j] = Math.min(right, down);
            }
        }

        return health[0][0];
    }

    public int calculateMinimumHP1(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int minHp = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = (minHp <= 0) ? 1 : minHp;
            }
        }
        return dp[0][0];
    }
}
