package lesson.QuerySQL_new;

// 值节点,比如用来表示字段，表，条件，数值等节点
// 此类节点下面如果存在查询也可能存在多个子节点
public class ValueNode extends Node {

    public ValueNode(String value) {
        this.text = value;
    }
}
