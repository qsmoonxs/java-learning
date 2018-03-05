/**
 * Copyright(C) 2017 Hangzhou Differsoft Co., Ltd. All rights reserved.
 */
package com.brianway.learning.java.base.generics;

import com.sun.javafx.collections.MappingChange;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 *
 * @author xus
 * @since 2018-03-05 14:08
 *
 */
public class GenericTest {

    public static void main(String[] args) throws Exception{
       // new GenericTest().testType();
        getParamType();
    }

    public void testType(){
        ArrayList<Integer> collection1 = new ArrayList<Integer>();
        ArrayList<String> collection2= new ArrayList<String>();

        System.out.println(collection1.getClass()==collection2.getClass());
        //两者class类型一样,即字节码一致

        System.out.println(collection1.getClass());

        System.out.println(collection2.getClass().getName());
        //class均为java.util.ArrayList,并无实际类型参数信息
    }

    /**
     * 利用反射方法参数的实际参数类型
     * @throws NoSuchMethodException
     */
    public static void getParamType() throws NoSuchMethodException {
        Method method = GenericTest.class.getMethod("applyMap", Map.class);
        //获取方法的泛型参数的类型
        Type[] types = method.getGenericParameterTypes();
        System.out.println(types[0]);
        //参数化类型
        ParameterizedType pType = (ParameterizedType) types[0] ;
        //原始参数类型
        System.out.println(pType.getRawType());
        //实际参数类型
        System.out.println(pType.getActualTypeArguments()[0]);
        System.out.println(pType.getActualTypeArguments()[1]);
    }


    /**
     * 供测试参数类型的方法
     * @param map
     */
    public static void applyMap(Map<Integer, String> map) {
        /**
         * - `ArrayList<E>` -- 泛型类型
         - `ArrayList` -- 原始类型
         - `E` -- 类型参数
         - `<>` -- 读作"typeof"
         - `ArrayList<Integer>` -- 参数化的类型
         - `Integer` -- 实际类型参数

         */
    }


}
