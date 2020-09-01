package lesson.QuerySQL_new;

import java.util.ArrayList;
import java.util.List;

public class SetNode extends Node {
    // 设置子节点之间的分隔符
    protected String seperator;

    public String getSeperator() {
        return seperator;
    }

    public SetNode() {
        seperator = "";
    }

    public SetNode(String seperator) {
        this.seperator = seperator;
    }

    public String toString() {
        String retval = this.text;

        List<String> ls = new ArrayList<String>();
        for(int i = 0; i < children.size(); i++) {
            Node child = children.get(i);
            ls.add(child.toString());
        }

        if (seperator == " and " || seperator == " or ") {
            retval += "(" + String.join(seperator, ls) + ")";
        }else {
            retval += String.join(seperator, ls);
        }

        return retval;
    }
}
