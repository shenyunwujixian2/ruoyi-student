package com.ruoyi.person.Utils.personUtils;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by sW4716 on 2018/3/6.
 */
public class UploadFormFilePut {
    public String uploadFormFile(String urlStr, Map<String, String> textMap, Map<String, String> fileMap,
                                  String cookieVal) {
        String result = "";
        HttpURLConnection conn = null;
        //分隔符
        String finalSplit = "------WebKitFormBoundarygixxlBEvPTuLyNUM";
        String end = "\r\n";
        String twoHyphens = "--";
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + finalSplit);
            if (cookieVal != null) {
                //发送cookie信息上去，以表明自己的身份，否则会被认为没有权限
                conn.setRequestProperty("Cookie", cookieVal);
            }
            OutputStream out = new DataOutputStream(conn.getOutputStream());
            //文本域
            if (textMap != null) {
                StringBuffer strBuf = new StringBuffer();
                Iterator<Map.Entry<String, String>> iter = textMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, String> entry = iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    inputValue = new  String(inputValue.getBytes("GBK"));
                    strBuf.append("\r\n").append("--").append(finalSplit).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
                    strBuf.append(inputValue);
                }
                out.write(strBuf.toString().getBytes("UTF-8"));
            }

            // 上传文件
            if (fileMap != null) {
                Iterator<Map.Entry<String, String>> iter = fileMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, String> entry = iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    File file = new File(inputValue);
                    String filename = file.getName();
                    MagicMatch match = Magic.getMagicMatch(file, false, true);
                    String contentType = match.getMimeType();
                    StringBuffer strBuf = new StringBuffer();
                    strBuf.append("\r\n").append("--").append(finalSplit).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename + "\"\r\n");
                    strBuf.append("Content-Type:" + contentType + "\r\n\r\n");
                    out.write(strBuf.toString().getBytes());
                    DataInputStream in = new DataInputStream(new FileInputStream(file));
                    int bytes = 0;
                    byte[] bufferOut = new byte[1024];
                    while ((bytes = in.read(bufferOut)) != -1) {
                        out.write(bufferOut, 0, bytes);
                    }
                    in.close();
                }
            }
            byte[] endData = ( "\r\n--" + finalSplit + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();
            // 读取返回数据
            StringBuffer strBuf = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            result = strBuf.toString();
            reader.close();
            reader = null;
        } catch (Exception e) {
            System.out.println("上传文件请求失败！" + urlStr);
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        return result;
    }
}

