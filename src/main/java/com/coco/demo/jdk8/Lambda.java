package com.coco.demo.jdk8;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Lambda expression
 * @see http://www.cnblogs.com/WJ5888/p/4618465.html
 * @author mvpzhao
 *
 */
public class Lambda {

	public static void main(String[] args) {
		new Thread(() -> System.out.println("Lambda is good!")).start();

		String[] datas = new String[] { "zhao", "chuan", "yun" };
		Arrays.sort(datas);
		Stream.of(datas).forEach(bean -> System.out.println(bean));
	}

}