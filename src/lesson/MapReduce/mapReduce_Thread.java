package lesson.MapReduce;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class mapReduce_Thread {

    public static ConcurrentHashMap<String, ArrayList<Integer>> result = new ConcurrentHashMap<>();

    public static void startThread(ArrayList<ArrayList<String>> array) throws InterruptedException {
        int size = array.size();
        Thread thread[] = new Thread[size];
        for (int i = 0; i < array.size(); i++) {
            thread[i] = new Thread(new myThread(array.get(i)));
            thread[i].start();
        }
        for (int i = 0; i < thread.length; i++) {
            thread[i].join();
        }
    }

    public static class myThread implements Runnable {
        private ArrayList<String> line_temp;

        public myThread(ArrayList<String> list) {
            line_temp = list;
        }

        @Override
        public void run() {
            ArrayList<HashMap<String, Integer>> mappingList = new ArrayList<>();
            for (int i = 0; i < line_temp.size(); i++) {
                String str = line_temp.get(i);
                mappingList = Mapping(str);
                shuffing(mappingList);
            }
        }
    }

    //读取文件
    public static ArrayList<ArrayList<String>> readFile(String path) {
        File file = new File(path);
        int line_num = 2000;
        ArrayList<ArrayList<String>> array = new ArrayList<>();
        ArrayList<String> tempList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//读取文件
            String line_temp = null;
            int i = 0;
            while ((line_temp = br.readLine()) != null) {
                tempList.add(line_temp);
                i++;
                if (i == line_num) {
                    array.add(tempList);
                    tempList = new ArrayList<>();
                    i = 0;
                }
            }
            if (i > 0) {
                array.add(tempList);
            }
            } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return array;
    }

    public static ArrayList<HashMap<String, Integer>> Mapping(String line_temp) {
        ArrayList<HashMap<String, Integer>> list = new ArrayList<>();
        line_temp = line_temp.toLowerCase();
        String[] str = line_temp.split("[^a-zA-Z0-9]+");
        for (int i = 0; i < str.length; i++) {
            if (!str[i].equals("") && !str[i].equals(" ")) {
                HashMap<String, Integer> result = new HashMap<>();
                result.put(str[i], 1);
                list.add(result);
            }
        }
        return list;
    }

    public static void shuffing(ArrayList<HashMap<String, Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Integer> tempMap = list.get(i);
            for (String key : tempMap.keySet()) {
                if (result.containsKey(key)) {
                    ArrayList<Integer> tempList = result.get(key);
                    tempList.add(1);
                } else {
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(1);
                    result.put(key, tempList);
                }
            }
        }
    }

    public static HashMap<String, Integer> reducing(ConcurrentHashMap<String, ArrayList<Integer>> result) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        for (String key : result.keySet()) {
            int size = result.get(key).size();
            resultMap.put(key, size);
        }
        return resultMap;
    }

    public static void Result(HashMap<String, Integer> result) {
        ArrayList<HashMap<String, Integer>> resultList = new ArrayList<>();
        for (String key : result.keySet()) {
            int value = result.get(key);
            HashMap<String, Integer> resultMap = new HashMap<>();
            resultMap.put(key, value);
            resultList.add(resultMap);
        }
        for (int j = 1; j < resultList.size(); j++) {
            HashMap<String, Integer> temp = resultList.get(j);
            for (String key : temp.keySet()) {
                System.out.println(key + " " + temp.get(key));
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        String filePath = "C:/Users/sse/Desktop/Hamlet.txt";
        ArrayList<ArrayList<String>> array = readFile(filePath);
        startThread(array);
        HashMap<String, Integer> reduceMap = reducing(result);
        Result(reduceMap);
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间" + (endTime - startTime) + "ms");
    }

}
