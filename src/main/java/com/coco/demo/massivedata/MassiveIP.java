package com.coco.demo.massivedata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 * 提取出某日访问百度次数最多的那个IP
 * 
 * http://blog.csdn.net/zhanglei0107/article/details/12137279#comments
 * 
 * @author zhaochuanyun
 *
 */
public class MassiveIP {

    // generate the massive numbers of IPs
    public void generateIP(String fileName) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(fileName);
            String s;
            Random r = new Random();
            for (int i = 0; i < 10000000; i++) {
                s = "159.227.";
                s += r.nextInt(256) + "." + r.nextInt(256);
                out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    // split the file to make it fit into the memory
    public void fileSplit(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintWriter[] out = new PrintWriter[10];
        String[] fileNameArray = fileName.split("\\.");
        for (int i = 0; i < 10; i++) {
            try {
                // specify split file name
                out[i] = new PrintWriter(fileNameArray[0] + i + "." + fileNameArray[1]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        String ip = null;
        try {
            while ((ip = reader.readLine()) != null) {
                int fileNum = ip.hashCode() % 10;
                fileNum = (fileNum >= 0 ? fileNum : fileNum + 10);
                out[fileNum].println(ip);
            }
            for (int i = 0; i < 10; i++) {
                out[i].close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // find IP with the largest number of occurrence
    public Map.Entry<String, Integer> statitics(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String ip = null;
        try {
            while ((ip = reader.readLine()) != null) {
                map.put(ip, map.get(ip) == null ? 1 : map.get(ip) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Entry in HashMap with the maximum value
        // which means the IP with the largest occurrence
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }

    public static void main(String[] args) {
        MassiveIP m = new MassiveIP();
        String fileName = "D://Data//test.txt";
        m.generateIP(fileName);
        m.fileSplit(fileName);
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
        String[] fileNameArray = fileName.split("\\.");
        for (int i = 0; i < 10; i++) {
            list.add(m.statitics(fileNameArray[0] + i + "." + fileNameArray[1]));
        }
        Map.Entry<String, Integer> maxEntry = list.get(0);
        for (int j = 1; j < 10; j++) {
            if (list.get(j).getValue() > maxEntry.getValue()) {
                maxEntry = list.get(j);
            }
        }
        System.out.println(maxEntry.getKey());
        System.out.println(maxEntry.getValue());
    }

}
