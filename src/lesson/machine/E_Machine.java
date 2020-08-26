package lesson.machine;

import java.awt.*;
import java.util.*;
import java.util.List;

public class E_Machine {



    private static void print(Machine machine) {
        System.out.println("序列号    " + machine.getSerialNumber());
        System.out.println("金额    " + machine.getPrice());
        for (Object key : machine.getSpec().getProperties().keySet()) {
            System.out.println(key + "    " + machine.getSpec().getProperties().get(key));
        }
    }
    private static void print(HashMap hashMap) {
        for (Object key : hashMap.keySet()) {
            System.out.println(key + "    " + hashMap.get(key));
        }
    }


    public static void main(String[] args) {

        //初始化仓库
        Inventory inventory = new Inventory();
        //添加商品信息
        HashMap<String, String> hashMap1 = new HashMap<String, String>(){{
            put("品牌", "联想");
            put("分类","游戏本");
            put("价格区间", "0-3000");
            put("屏幕尺寸","11.6英寸");
            put("处理器","Intel i9");
        }};
        HashMap<String, String> hashMap2 = new HashMap<String, String>(){{
            put("品牌", "戴尔");
            put("分类","轻薄本");
            put("价格区间", "3000-4000");
            put("屏幕尺寸","14.1英寸");
            put("处理器","Intel CoreM");
        }};
        HashMap<String, String> hashMap3 = new HashMap<String, String>(){{
            put("品牌", "华为");
            put("分类","常规笔记本");
            put("价格区间", "4000-5000");
            put("屏幕尺寸","15.4英寸");
            put("处理器","AMD");
        }};


        HashMap<String, String> hashMap4 = new HashMap<String, String>(){{
            put("品牌", "华为");
            put("分类","常规笔记本");
            put("价格区间", "4000-5000");
            put("屏幕尺寸","15.4英寸");
            put("处理器","AMD");
        }};

        //加入库存
        inventory.addMachine("00001", 2000, new MachineSpec(hashMap1));
        inventory.addMachine("00002", 3500, new MachineSpec(hashMap2));
        inventory.addMachine("00003", 4500, new MachineSpec(hashMap3));
        inventory.addMachine("00004", 4500, new MachineSpec(hashMap4));



        //通过序列号查询,并打印该machine信息
        System.out.println("通过序列号查询,并打印该machine信息");
        System.out.println();
        Machine search_machine = inventory.get("00003");
        if(search_machine == null){
            System.out.println("抱歉没有找到相关产品");
        }else {
            print(search_machine);
        }
        System.out.println();

        //通过MachineSpec查询，输出列表
        System.out.println("通过MachineSpec查询，输出列表");

        System.out.println("需要查询的商品信息");
        print(hashMap4);
        List list =  inventory.search(new MachineSpec(hashMap4));
        if(list.size() == 0){
            System.out.println("抱歉没有找到相关产品");
        }else {
            System.out.println("共查到" + list.size() + "个商品");
        }
    }

}
