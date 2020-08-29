package lesson.QuerySQL;

// 关键字节点,比如用来表示SQL中select，from，where，order by等关键字的节点
// 此类节点下面没有子节点
public class KeywordNode extends Node {

    public KeywordNode(String keyword) {
        this.text = keyword;
    }
}
