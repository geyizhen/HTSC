package lesson.MapReduce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class mapReduce {

    public static HashMap<String,ArrayList<Integer>> result = new HashMap<>();


    public static ArrayList<HashMap<String, Integer>> Mapping(String lineTxt) {
        ArrayList<HashMap<String, Integer>> list = new ArrayList<>();
        lineTxt = lineTxt.toLowerCase();
        String[] str = lineTxt.split("[^a-zA-Z0-9]+");
        for (int i = 0; i < str.length; i++) {
            if (!str[i].equals("") && !str[i].equals(" ")) {
                HashMap<String, Integer> result = new HashMap<>();
                result.put(str[i], 1);
                list.add(result);
            }
        }
        return list;
    }

    public static void shuff(ArrayList<HashMap<String,Integer>> list) {
        for(int i = 0; i < list.size(); i++){
            HashMap<String, Integer> tempMap =list.get(i);
            for(String key:tempMap.keySet()){
                if(result.containsKey(key)){
                    ArrayList<Integer> tempList = result.get(key);
                    tempList.add(1);
                }
                else{
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(1);
                    result.put(key,tempList);
                }
            }
        }
    }

    public static HashMap<String, Integer> reduce(HashMap<String,ArrayList<Integer>> result) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        for(String key : result.keySet()){
            int size = result.get(key).size();
            resultMap.put(key,size);
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

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        String filePath = "C:/Users/sse/Desktop/Hamlet.txt";
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    ArrayList<HashMap<String,Integer>> mappingList = Mapping(lineTxt);
                    shuff(mappingList);
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        HashMap<String,Integer> reduceMap = reduce(result);
        Result(reduceMap);

        long endTime = System.currentTimeMillis();
        System.out.println("运行时间" + (endTime - startTime) + "ms");
    }
}
