package com.dnight.base;

/**
 * @author ZHONGPENG769
 * @date 2019/8/23
 */
public class Test {

    class Inner {
        Boolean flag;

        public Boolean getFlag() {
            return flag;
        }

        public void setFlag(Boolean flag) {
            this.flag = flag;
        }
    }

    public static void main(String[] args) {
        Inner i = new Test().new Inner();
        System.out.println(i.flag != null && !i.flag);
        System.out.println(i.flag);
    }
}
