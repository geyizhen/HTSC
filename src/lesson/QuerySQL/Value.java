package lesson.QuerySQL;

// 值节点,比如用来表示字段，表，条件，数值等节点
// 此类节点下面如果存在查询也可能存在多个子节点
public class Value extends Node {

    public Value(String value) {
        this.text = value;
    }
}
