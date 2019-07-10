package util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZHONGPENG769
 * @date 2019/7/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {

    private String name;
    private Long chinese;
    private Long math;

    public Score(String name) {
        this.name = name;
    }

    public Score(String name, Long chinese) {
        this.name = name;
        this.chinese = chinese;
    }
}
