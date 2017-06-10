package com.coco.demo.guava;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class GuavaTest {

    public static final BigDecimal ZERO_BIG_DECIMAL = new BigDecimal("0");

    public static void main(String[] args) {
        String str1 = null;
        str1 = Optional.fromNullable(str1).or("default1");
        System.err.println(str1);

        String str2 = "default2";
        str2 = Optional.fromNullable(str2).or("default1");
        System.err.println(str2);

        BigDecimal num1 = ZERO_BIG_DECIMAL;
        System.err.println(num1 == ZERO_BIG_DECIMAL);
        num1 = num1.add(new BigDecimal("10"));
        System.err.println(num1);
        System.err.println(num1 == ZERO_BIG_DECIMAL);

        BigDecimal num2 = ZERO_BIG_DECIMAL;
        num2 = num2.add(new BigDecimal("100"));
        System.err.println(num2);

        Optional<String> ostr1 = Optional.fromNullable(null);
        System.err.println(ostr1.isPresent());

        Optional<String> ostr2 = Optional.fromNullable("fff");
        System.err.println(ostr2.isPresent());
        System.err.println(ostr2.get());

        List<String> list = Lists.newArrayList("-1", "0", "1", "2", "3");
        Collection<String> collection = Collections2.filter(list, new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return NumberUtils.toInt(input) > 0;
            }
        });
        System.err.println(collection);

        Collection<Integer> c2 = Collections2.transform(collection, new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return NumberUtils.toInt(input) + 10;
            };
        });
        System.err.println(c2);
    }

}
