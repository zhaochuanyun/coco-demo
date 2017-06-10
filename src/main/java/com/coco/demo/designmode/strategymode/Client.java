package com.coco.demo.designmode.strategymode;

/**
 * 策略模式
 * 
 * @see http://www.cnblogs.com/java-my-life/archive/2012/05/10/2491891.html
 * @author zhaochuanyun
 *
 */
public class Client {

    public static void main(String[] args) {
        // 选择并创建需要使用的策略对象
        MemberStrategy strategy = new AdvancedMemberStrategy();
        // 创建环境
        Price price = new Price(strategy);
        // 计算价格
        double quote = price.quote(300);
        System.out.println("图书的最终价格为：" + quote);
    }

}
