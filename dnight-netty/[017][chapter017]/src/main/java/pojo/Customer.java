package pojo;

import lombok.Data;

import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/4
 */
@Data
public class Customer {
    private long customerNumber;
    private String firstName;
    private String lastName;
    private List<String> middleName;

}
