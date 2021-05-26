package com.ruoyi.common.utils.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Bean 工具类
 * 
 * @author ruoyi
 */
public class BeanUtils extends org.springframework.beans.BeanUtils
{
    /** Bean方法名中属性名开始的下标 */
    private static final int BEAN_METHOD_PROP_INDEX = 3;

    /** * 匹配getter方法的正则表达式 */
    private static final Pattern GET_PATTERN = Pattern.compile("get(\\p{javaUpperCase}\\w*)");

    /** * 匹配setter方法的正则表达式 */
    private static final Pattern SET_PATTERN = Pattern.compile("set(\\p{javaUpperCase}\\w*)");

    /**
     * Bean属性复制工具方法。
     *
     * @param dest 目标对象
     * @param src 源对象
     */
    public static void copyBeanProp(Object dest, Object src)
    {
        try
        {
            copyProperties(src, dest);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 获取对象的setter方法。
     * 
     * @param obj 对象
     * @return 对象的setter方法列表
     */
    public static List<Method> getSetterMethods(Object obj)
    {
        // setter方法列表
        List<Method> setterMethods = new ArrayList<Method>();

        // 获取所有方法
        Method[] methods = obj.getClass().getMethods();

        // 查找setter方法

        for (Method method : methods)
        {
            Matcher m = SET_PATTERN.matcher(method.getName());
            if (m.matches() && (method.getParameterTypes().length == 1))
            {
                setterMethods.add(method);
            }
        }
        // 返回setter方法列表
        return setterMethods;
    }

    /**
     * 获取对象的getter方法。
     * 
     * @param obj 对象
     * @return 对象的getter方法列表
     */

    public static List<Method> getGetterMethods(Object obj)
    {
        // getter方法列表
        List<Method> getterMethods = new ArrayList<Method>();
        // 获取所有方法
        Method[] methods = obj.getClass().getMethods();
        // 查找getter方法
        for (Method method : methods)
        {
            Matcher m = GET_PATTERN.matcher(method.getName());
            if (m.matches() && (method.getParameterTypes().length == 0))
            {
                getterMethods.add(method);
            }
        }
        // 返回getter方法列表
        return getterMethods;
    }

    /**
     * 检查Bean方法名中的属性名是否相等。<br>
     * 如getName()和setName()属性名一样，getName()和setAge()属性名不一样。
     * 
     * @param m1 方法名1
     * @param m2 方法名2
     * @return 属性名一样返回true，否则返回false
     */

    public static boolean isMethodPropEquals(String m1, String m2)
    {
        return m1.substring(BEAN_METHOD_PROP_INDEX).equals(m2.substring(BEAN_METHOD_PROP_INDEX));
    }

    /**
     * 将一个 JavaBean 对象转化为一个  Map
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     * @throws IntrospectionException 如果分析类属性失败
     * @throws IllegalAccessException 如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static Map convertBeanToMap(Object bean) {
        Map returnMap = new HashMap();
        try {
            Class type = bean.getClass();

            BeanInfo beanInfo = Introspector.getBeanInfo(type);

            PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
            for (int i = 0; i< propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean, new Object[0]);
                    if (result != null) {
                        returnMap.put(propertyName, result);
                    } else {
                        returnMap.put(propertyName, "");
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return returnMap;
    }

    /**
     * map 转 Bean
     *
     * @param mpFrom
     * @param objTo
     * @return
     */
    public static Object convertMapToBean(Map mpFrom, Object objTo) {
        Object[] objKeys = mpFrom.keySet().toArray();
        String strFieldName = "";
        try {
            for (Object objkey : objKeys) {
                strFieldName = objkey.toString();
                Field objField = objTo.getClass().getDeclaredField(strFieldName.toLowerCase());
                objField.setAccessible(true);
                objField.set(objTo, mpFrom.get(strFieldName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objTo;
    }

    /**
     * map 转 Bean
     *
     * @param map
     * @param cls
     * @return
     */
    public static Object convertMapToBean(Map map, Class cls) {
        Object obj = null;
        try {
            obj = cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 取出bean里的所有方法
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; i++) {
            // 取方法名
            String method = methods[i].getName();
            // 取出方法的类型
            Class[] cc = methods[i].getParameterTypes();
            if (cc.length != 1)
                continue;
            // 如果方法名没有以set开头的则退出本次for
            if (method.indexOf("set") < 0)
                continue;
            // 类型
            String type = cc[0].getSimpleName();

            try {
                // 转成小写
                // Object value = method.substring(3).toLowerCase();
                String methodAliasName = method.substring(3, 4).toLowerCase() + method.substring(4);
//                System.out.println("methodAliasName == " + methodAliasName);
                // if (map.containsKey(methodAliasName) &&
                // map.get(methodAliasName) != null) {

                // }
                // 如果map里有该key
                Set<String> set = map.keySet();
                for (String key : set) {
                    if (methodAliasName.equalsIgnoreCase(key)) {
                        // 调用其底层方法
                        setValue(type, map.get(key), i, methods, obj);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    /***************************************************************************
     * 调用底层方法设置值
     */
    private static void setValue(String type, Object value, int i, Method[] method, Object bean) {
        if (value != null && !value.equals("")) {
            try {
                if (type.equals("String")) {
                    // 第一个参数:从中调用基础方法的对象 第二个参数:用于方法调用的参数
                    method[i].invoke(bean, new Object[] { value });
                } else if (type.equals("int") || type.equals("Integer")) {
                    method[i].invoke(bean, new Object[] { new Integer(""
                            + value) });
                } else if (type.equals("double") || type.equals("Double")) {
                    method[i].invoke(bean,
                            new Object[] { new Double("" + value) });
                } else if (type.equals("float") || type.equals("Float")) {
                    method[i].invoke(bean,
                            new Object[] { new Float("" + value) });
                } else if (type.equals("long") || type.equals("Long")) {
                    method[i].invoke(bean,
                            new Object[] { new Long("" + value) });
                } else if (type.equals("boolean") || type.equals("Boolean")) {
                    method[i].invoke(bean,
                            new Object[] { Boolean.valueOf("" + value) });
                } else if (type.equals("BigDecimal")) {
                    method[i].invoke(bean, new Object[] { new BigDecimal(""
                            + value) });
                } else if (type.equals("Date")) {
                    Date date = null;
                    if (value.getClass().getName().equals("java.util.Date")) {
                        date = (Date) value;
                    } else {
                        String format = ((String) value).indexOf(":") > 0 ? "yyyy-MM-dd hh:mm:ss"
                                : "yyyy-MM-dd";
                        SimpleDateFormat sf = new SimpleDateFormat();
                        sf.applyPattern(format);
                        date = sf.parse((String) (value));
                    }
                    if (date != null) {
                        method[i].invoke(bean, new Object[] { date });
                    }
                } else if (type.equals("byte[]")) {
                    method[i].invoke(bean,
                            new Object[] { new String(value + "").getBytes() });
                }
            } catch (Exception e) {
                System.out.println("将linkHashMap 或 HashTable 里的值填充到javabean时出错,请检查!");
                e.printStackTrace();
            }
        }
    }

}
