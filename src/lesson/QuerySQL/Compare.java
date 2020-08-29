package lesson.QuerySQL;

// 比较节点,用来表示条件比较的节点，如age>41,level>9
// 此类节点下面理论上存在左右两个节点，如果存在查询也可能存在多个子节点
public class Compare extends Node {

    public Compare(String value) {
        this.text = value;
    }

    public String toString() {

        Node node1 = children.get(0);
        Node node2 = children.get(1);

        String retval = "(" + node1 + " " + this.text + " "+ node2 + ")";

        return retval;
    }
}
