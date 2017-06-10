package com.coco.demo.massivedata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MyMassiveIP {

    public void generateIP(String fileName) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new File(fileName));
            String str = "192.168.";
            Random r = new Random();
            for (int num = 0; num < 10000; num++) {
                out.println(str + r.nextInt(256) + "." + r.nextInt(256));
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public void split(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }

        PrintWriter[] writer = new PrintWriter[10];
        for (int i = 0; i < writer.length; i++) {
            try {
                writer[i] = new PrintWriter(fileName.replace(".", "_" + i + "."));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String ip = null;
        try {
            while ((ip = reader.readLine()) != null) {
                int num = ip.hashCode() % 10;
                if (num < 0) {
                    num += 10;
                }
                writer[num].println(ip);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < writer.length; i++) {
                try {
                    writer[i].close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Map.Entry<String, Integer> statistic(String fileName) {
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
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Map.Entry<String, Integer> max = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max == null) {
                max = entry;
            }
            if (entry.getValue() > max.getValue()) {
                max = entry;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MyMassiveIP m = new MyMassiveIP();
        String fileName = "D:\\massive\\ip.txt";
        // m.generateIP(fileName);
        m.split(fileName);
    }

}
