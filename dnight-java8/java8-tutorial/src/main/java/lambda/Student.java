package lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ZHONGPENG769
 * @date 2019/10/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    String name;
    Integer age;
    Integer high;
}
