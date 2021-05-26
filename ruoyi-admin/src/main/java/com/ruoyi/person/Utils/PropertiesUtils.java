package com.ruoyi.person.Utils;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;


public class PropertiesUtils
{
    /**
     *
     * @Description: TODO 根据key读取value
     * @author z00562 2016年3月31日
     * @param filePath
     * @param key
     * @return
     */
    public static String readValue(String filePath, String key)
    {
        Properties props = new Properties();
        InputStream in = null;
        try
        {
            in = new FileInputStream(new File(filePath));
            // in = cl.getResourceAsStream(filePath);
            props.load(new InputStreamReader(in,"UTF-8"));
            String value = props.getProperty(key);
            if (null != value)
            {
                value = value.trim();
            }
            return value;
        }
        catch (Exception e)
        {
            e.printStackTrace();

            return null;
        }
        finally
        {
            if(in != null)
            {
                try
                {
                    in.close();
                }
                catch(IOException ie)
                {

                }
            }
        }
    }

    /**
     *
     * @Description: TODO 读取properties的全部信息
     * @author z00562 2016年3月31日
     * @param filePath
     */
    public static HashMap<String, String> readProperties(String filePath)
    {
        Properties props = new Properties();
        HashMap<String, String> oMap = new HashMap<String, String>();
        InputStream in = null;
        if(null != filePath && !"".equals(filePath))
        {
            try {
                in = new FileInputStream(filePath);
                props.load(new InputStreamReader(in, "UTF-8"));
                Enumeration<?> en = props.propertyNames();
                while (en.hasMoreElements())
                {
                    String key = (String) en.nextElement();
                    String Property = props.getProperty(key);
                    System.out.println(key + "=" + Property);
                    if (null != key) {
                        key = key.trim();
                    }
                    if (null != Property) {
                        Property = Property.trim();
                    }
                    oMap.put(key, Property);
                }
            } catch (Exception e)
            {
                e.printStackTrace();

            }
            finally
            {
                if (in != null)
                {
                    try
                    {
                        in.close();
                    }
                    catch (IOException ie)
                    {

                    }
                }
            }
        }
        return oMap;
    }

    /**
     * @Date：2017/10/12  10:10
     * @Author：hW4406
     * @Description：TODO 读取properties的全部信息,但是不打印
     * @Param：filePath
     * @return：
     */
    public static HashMap<String, String> readPropertiesNoPrint(String filePath)
    {
        Properties props = new Properties();
        HashMap<String, String> oMap = new HashMap<String, String>();
        InputStream in = null;
        if(null != filePath && !"".equals(filePath))
        {
            try {
                in = new FileInputStream(filePath);
                props.load(new InputStreamReader(in, "UTF-8"));
                Enumeration<?> en = props.propertyNames();
                while (en.hasMoreElements())
                {
                    String key = (String) en.nextElement();
                    String Property = props.getProperty(key);
                    if (null != key)
                    {
                        key = key.trim();
                    }
                    if (null != Property)
                    {
                        Property = Property.trim();
                    }
                    oMap.put(key, Property);
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                if (in != null)
                {
                    try
                    {
                        in.close();
                    }
                    catch (IOException ie)
                    {
                        System.out.println("读取properties文件失败 ");
                    }
                }
            }
        }
        return oMap;
    }



    /**
     *
     * @Description: TODO 写入properties信息
     * @author z00562 2016年3月31日
     * @param filePath
     * @param parameterName
     * @param parameterValue
     */
    public static void writeProperties(String filePath, String parameterName, String parameterValue)
    {
        Properties props = new Properties();
        try
        {
            InputStream fis = new FileInputStream(filePath);
            // 从输入流中读取属性列表（键和元素对）
            props.load(new InputStreamReader(fis,"UTF-8"));
            // 调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
            OutputStream fos = new FileOutputStream(filePath);
            props.setProperty(parameterName, parameterValue);
            // 以适合使用 load 方法加载到 Properties 表中的格式，
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
            props.store(fos, "Update '" + parameterName + "' value");
        }
        catch (IOException e)
        {
            System.err.println("Visit " + filePath + " for updating " + parameterName + " value error");
        }
    }

    /**
     * 测试方法
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        // System.out.println(Class.class.getClass().getResource("/").getPath());
        System.out.println(System.getProperty("user.dir"));
        String strProjectPath = System.getProperty("user.dir");
        String strPropertyPath = strProjectPath + "\\public.properties";
        String strTollgateCodePath = strProjectPath + "\\config" + "\\fuzhoufirm" + "\\TollgateCodeH3.properties";
        System.out.println(strPropertyPath);
        System.out.println(PropertiesUtils.readValue(strPropertyPath, "tmsIp0"));

        // 读取卡口编码转换文件
        HashMap<String, String> oHashMapTollgateCode = new HashMap<String, String>();
        oHashMapTollgateCode = PropertiesUtils.readProperties(strTollgateCodePath);
        // oFzConfig.setoHashMapVehicleType(oTollgateCode);
    }
}
