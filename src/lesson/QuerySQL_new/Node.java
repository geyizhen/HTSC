package lesson.QuerySQL_new;

import java.util.ArrayList;
import java.util.List;

// 节点抽象类，作为各种节点的基类
public abstract class Node {
    // 此节点的子节点
    protected List<Node> children;

    // 表示此节点的文字
    protected String text = "";

    public Node() {
        children = new ArrayList<Node>();
    }

    // 添加一个子节点
    public Node addChild(Node n) {
        children.add(n);
        return this;
    }

    public void popChild(){
        if(children.size() > 2) {
            if (children.get(children.size() - 1).toString().equals("()")) {
                children.remove(children.size() - 1);
            }
        }
    }

    public String toString() {
        String retval = this.text + "";

        for(int i = 0; i < children.size(); i++) {
            Node child = children.get(i);
            retval += child.toString();
        }
        return retval;
    }
}
