package com.coco.demo.interview;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author zhaochuanyun
 *
 */
public class GetWeekOfDate {
	
	static char c;
    static String s;

    public static void main(String[] args) {
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        System.err.println(Calendar.DATE);
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK) - 1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        // 年
        System.out.println("yyyy:" + new SimpleDateFormat("yyyy").format(date));
        // 月
        System.out.println("MM:" + new SimpleDateFormat("MM").format(date));
        // 日
        System.out.println("dd:" + new SimpleDateFormat("dd").format(date));
        // 时（24小时制）
        System.out.println("HH:" + new SimpleDateFormat("HH").format(date));
        // 时（12小时制）
        System.out.println("hh:" + new SimpleDateFormat("hh").format(date));
        // 分
        System.out.println("mm:" + new SimpleDateFormat("mm").format(date));
        // 秒
        System.out.println("ss:" + new SimpleDateFormat("ss").format(date));
        // 星期几
        System.out.println("EE:" + new SimpleDateFormat("EE").format(date));

        char[] cArray = new char[100];
        String sArray = new String(cArray);
        System.out.println(sArray.length() + ":" + sArray + ".");

        @SuppressWarnings("unused")
        String bBb$ = null;

        // Returns a double value with a positive sign, greater than or equal to 0.0 and less than
        // 1.0.
        System.err.println(Math.random() < 0.5);

        System.out.println(Integer.valueOf('a'));
        System.out.println(Integer.valueOf('z'));
        System.out.println(Integer.valueOf('A'));
        System.out.println(Integer.valueOf('Z'));
        
        String[] strArray = new String[10];
        System.out.println(Arrays.toString(strArray));
        System.out.println(strArray.length);
        
        System.out.println(cArray);
        
        // 初始化问题
        System.out.println("c:[" + c + "]");
        System.out.println("s:" + s);
        
        int i = 1;
        long l = 1;
        double b = 1.2;
        float f = 1.2f;
        
		System.err.println(exceptionTest());
	}

	static int exceptionTest() {
		try {
			System.out.println("-------try-------");
			throw new Exception();
		} catch (Exception e) {
			System.out.println("-------catch-------");
			return -1;
		} finally {
			System.out.println("-------finally-------");
		}
	}

    /************************************************************************************************
     * 
     * 
     * @See 1、框架相关
     ***********************************************************************************************/
    // springMVC如何配置
    // spring事务的模块划分；实现原理
    // spring ioc原理（反射？代理？）
    // spring 用到的设计模式 http://www.uml.org.cn/j2ee/201301074.asp
    // spring @resource注解 如何获取applicationContex
    // spring的使用
    // spring aop应用
    // Spring中一个基类有多个实现类，该如何配置bean
    // spring加载顺序
    // SpringMVC的实现
    // Spring事务处理
    // BeanFactory FacotyBean区别
    /**
     * http://chenzehe.iteye.com/blog/1481476
     */
    // IoC容器初始化过程
    /**
     * 1、resource定位 2、BeanDefinition的载入 3、向IoC容器注册这些BeanDefination
     * 
     * ps：Ioc容器初始化过程一般不包括bean依赖注入的实现
     */
    // IoC容器中bean的生命周期
    /**
     * 1、bean的实例化 2、为bean设置属性 3、调用bean的初始化方法 4、bean在IoC容器中被调用 5、容器关闭时bean被销毁
     */
    // Spring容器启动时访问数据库，加载基础数据
    // mybatis一对多，多对多的配置
    /**
     * http://kinglixing.blog.51cto.com/3421535/709738
     * 
     * 1的那一方在resutMap里面用collection进行配置，并指定查询的column="id"和查询方法select=
     * "com.lixing.ibatis.onetomany.mapper.OrdersMapper.getOrdersById"
     * N的那一方在resutMap里面用association进行配置
     */
    // servlet生命周期
    /**
     * 注意servlet是被web容器管理的，bean是在spring容器中管理的
     * 
     * http://www.cnblogs.com/xuekyo/archive/2013/02/24/2924072.html 
     * 1、servlet加载 2、servlet实例化init() 3、服务service() 4、销毁destroy()
     */
    // mybatis与hibernate的区别，Spring、SpringMVC的优缺点
    /**
     * http://www.iteye.com/problems/100154
     * http://blog.163.com/ppy2790@126/blog/static/1032422412012115113638381/
     */
    // Servlet是否是线程安全的
    /**
     * Servlet是单例多线程，同时是线程不安全的
     */
    // http转发和重定向的区别
    /**
     * http://www.cnblogs.com/mengdd/archive/2013/06/15/3137367.html
     * http://blog.csdn.net/newjueqi/article/details/4782602
     */
    // web.xml中的加载顺序

    /************************************************************************************************
     * 
     * 
     * @See 2、Java知识
     ***********************************************************************************************/
	// JAVA异常类型
	/**
	 * http://blog.csdn.net/renfufei/article/details/16344847
	 */
    // JAVA新建对象方式（new constructor()；反射；其他？）
	/**
	 * http://lovelace.iteye.com/blog/182772
	 */
    // HashTable HashMap ConcurrentHashMap区别；hashcode冲突后处理策略
    // JAVA泛型好处
    // Java容器中定义了一个类，但是也可以保存这个类的子类，那么如何获取这个子类与父类不同的属性和方法
    // 设计模式分类（大类）
    /**
     * http://www.cnblogs.com/justForMe/archive/2011/07/18/2109211.html
     */
    // 一致性哈希算法
    // java hashcode作用
    /**
     * http://www.cnblogs.com/dolphin0520/p/3681042.html
     */
    // java 锁实现的方法和作用
    // java 内存模型
    // java 内存参数设置
    // ConcurrentHashMap和HashMap实现细节
	/**
	 * http://www.iteye.com/topic/344876
	 */
    // Object wait()方法和Thread sleep()方法本质区别
    /**
     * http://www.xuebuyuan.com/1658925.html
     */
    // jdk线程池满后处理策略
    /**
     * http://www.cnblogs.com/springsource/archive/2013/05/07/3040460.html
     * http://blog.csdn.net/cutesource/article/details/6061229
     */
    // hash key冲突时的处理
    // arrayList动态扩展内存的实现
    // StringBuilder StringBuffer区别 append效率 有没有线程同步
    // 各种容器的结构实现
    // throw Error情形
    // List Set的实现
    // Java override的实现
    // 实现Runnable接口和继承Thread类的区别
    // GC
    // Java容器原理，Set去重原理，Map使用等等
    // Java线程知识，悲观锁和乐观锁
    /**
     * http://blog.csdn.net/sdyy321/article/details/6183412
     */
    // JVM垃圾回收算法，年轻代过渡到年老代条件，垃圾回收触发条件
    // 设计模式，抽象工厂模式与工厂模式区别
    /**
     * http://blog.csdn.net/superbeck/article/details/4446177
     */
    // 死锁处理
    /**
     * http://leowzy.iteye.com/blog/740859
     * 
     * 1、让所有的线程按照同样的顺序获得一组锁。这种方法消除了 X 和 Y 的拥有者分别等待对方的资源的问题。
     * 2、将多个锁组成一组并放到同一个锁下。前面Java线程死锁的例子中，可以创建一个银器对象的锁。于是在获得刀或叉之前都必须获得这个银器的锁。
     */

    /************************************************************************************************
     * 
     * 
     * @See 3、数据库知识
     ***********************************************************************************************/
    // SQL语句优化方法
    /**
     * 1.使用explain来分析select查询
     * 2.为搜索字段建立索引
     * 3.连接查询的时候使用相同类型的列，并为其建立索引
     * 4.避免使用select * 
     * 5.避免字段的值为null
     */
    // MySQL查询的原理
    // 数据库知识，MySQL索引失效情况
    // 事务的特性和隔离级别，对数据库事务的理解

    /************************************************************************************************
     * 
     * 
     * @See 4、业务及应用
     ***********************************************************************************************/
    // 项目中的难点及解决方案！
    // 大型网站架构
    // 如何获取同时在线人数
    // MongoDB、Memcache、Redis优缺点，调优经验
    // 商品详情页除了用cdn加快访问速度外，还有没有其他方式？
    // struts拦截器跟filter拦截的区别，filter的实现原理
    // Session跨域共享
    // restful接口加密解密
    // ActiveMQ工作原理，如何设置消息处理策略
    // 系统报outOfMemory如何处理
    // 大型电商/IM网站架构设计
    // JMS：queue，topic区别
    /**
     * http://blog.csdn.net/aking21alinjuju/article/details/6051421
     */
    // GIT MOCK
    // MQ应用场景，如何设置消息可靠/不可靠
    // MongoDB应用场景，优劣势
    // rpc框架
    // rpc的应用场景和原理
    // java nio的应用场景和原理
    // 电商网站中rpc的应用
    // disruptor
    // mq的构造
    // 喜欢读源码吗
    // 上那些技术论坛
    // 擅长内容
    // 前端知识
    
    /************************************************************************************************
     * 
     * 
     * @See 5、经验
     ***********************************************************************************************/
    // 面试很大程度上是一个推销自己的过程，所以一切应围绕这个中心来
    // 必须将项目讲的非常具体，每个模块、功能的实现原理必须了解，能深入最好深入讲！
    // 要有闪光点
    // 清晰的职业规划
    // 换工作的原因
    /**
     * 一个HR对我建议
     * 
     * 你的个人优势：一，教育背景很好，这也是很多大型企业和外企看重。eBay里面很多都是国内211,985高校本科，硕士生。
     * 二，你现在的工作经历是一段比较完整的工作经验。
     * 就我和你打电话的感觉和面试官的反馈看来，我不知道是不是你不方便讲电话的原因，你在电话里面说话没有很放开。
     * 还有你换工作的原因是想学习更多新技术，说明你是一个很passion的人，但是在电话里面没有感觉到。
     * eBay那边对年轻人，他们喜欢passion和有potention的人。
     * 还有他们喜欢技术全面的人，因为要和各个不同的team，还有美国的team交流，所以要有一定良好的基础。
     * 所以对于明天的面试，我建议你在和面试官聊得时候，可以多表达一些，说说自己的项目的细节。
     * 一来，可以让面试官更了解你的技术情况，二来也可以看出你的attitude和你的communication。
     */
	
	/**
	 * dubbo原理、设计模式的应用及体现的软件设计思想（开闭原则）、多线程应用场景及如何保证线程安全、代码优化方案
	 * review代码出现问题最多的场景、金融业务的核心场景及原因、对项目中负责业务功能要烂熟于心
	 * spring设计模式（单例、工厂）
	 * bean生命周期
	 * list排序方法
	 * Hadoop如何防止重复分配作业
	 * @see com.coco.demo.tostring#Student
	 * @see com.coco.demo.tostring#User
	 */
	
	/**
	 * eleme
	 * spring dubbo zookeeper
	 * jvm内存模型 垃圾回收 线程容器
	 * sql索引优化 xml自定义标签
	 * 线程锁的种类 如何为线程分配栈空间 栈满的情况
	 * 改造jvm参数带来的影响 nosql优势 缓存服务器宕机应对
	 * copyonwritearraylist
	 * jdk cglib代理 spring
	 * scope如何实现 分布式session如何保持状态一致
	 */
	
	/**
	 * alibaba
	 * 深复制浅复制、addAll、如何实现深复制
	 * switch case
	 * TheadPoolExecutor
	 * HashMap
	 * Q的同步转异步
	 * 缓存不均衡策略
	 */
	
	/**
	 * dubbo源码、war包内容格式、Spring扫描注解步骤、单例模式class锁机制、各种排序算法，大数据取排名前100问题、jdk中各种数据结构实现
	 */
	
	/**
	 * 猎头的建议：条分缕析，理清楚项目中的重点和闪光点，并且能够表述出来
	 * Java基础要特别扎实
	 */

}
