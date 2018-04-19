package com.easykotlin.lectures.jfp.extensions;

import java.util.Arrays;
import java.util.List;
import static java.lang.System.out;

public class SwapDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        CollectionUtils collectionUtils = new CollectionUtils();
        collectionUtils.swap(list, 1, 2);
        out.println(list);
        // list.swap(1,2)
    }
}

class CollectionUtils<T> {
    void swap(List<T> list, int index1, int index2) {
        T e1 = list.get(index1);
        T e2 = list.get(index2);
        list.set(index1, e2);
        list.set(index2, e1);
    }
}


/**
 * 在不修改原类的情况下, Kotlin能给一个类扩展新功能,无需继承该类,也不用任何设计模式(如装饰模式等),
 * Kotlin支持扩展函数和扩展属性!
 * <p>
 * 为什么要使用扩展(动机): 在Java中,有很多工具类如java.util.Collections,使用很繁琐：
 * // Java
 * Collections.swap(list,index1,index2)
 * <p>
 * 静态导入Collections类,简化写法:
 * // Java
 * swap(list,index1,index2)
 * <p>
 * 静态导入使用依然很麻烦,如果能给list类添加扩展函数就好了:
 * <p>
 * list.swap(index1,index2)
 */
