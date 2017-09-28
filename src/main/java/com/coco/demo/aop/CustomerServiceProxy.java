package com.coco.demo.aop;

public class CustomerServiceProxy implements ICustomerService {

    private ICustomerService customerService;

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public void someMethod() {
        doBefore();
        customerService.someMethod();
        doAfter();
    }

    public void someInnerMethod() {
        doBefore();
        customerService.someInnerMethod();
        doAfter();
    }

    private void doBefore() {
        // 例如，可以在此处开启事务
        System.out.println("--- aop - do some important things before...");
    }

    private void doAfter() {
        // 例如，可以在此处提交或回滚事务、释放资源等等
        System.out.println("--- aop - do some important things after...");
    }

}
