package com.burning8393.cor;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)，<script>，欢迎访问 mashibing.com ，大家都是996 ");

        FilterChain fc1 = new FilterChain();
        fc1.add(new HTMLFilter()).add(new SensitiveFilter());
        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter()).add(new URLFilter());
        fc1.add(fc2);
        fc1.doFilter(msg);
        System.out.println(msg);
    }
}

class Msg {
    String name;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

interface Filter {
    boolean doFilter(Msg m);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String msg = m.getMsg();
        msg = msg.replace("<", "[");
        msg = msg.replace(">", "]");
        m.setMsg(msg);
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace("996", "955");
        m.setMsg(r);
        return true;
    }
}

class FaceFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace(":)", "^V^");
        m.setMsg(r);
        return true;
    }
}

class URLFilter implements Filter {
    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace("mashibing.com", "http://www.mashibing.com");
        m.setMsg(r);
        return true;
    }
}

class FilterChain implements Filter {

    List<Filter> filters = new LinkedList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Msg m) {
        for (Filter filter : filters) {
            if (!filter.doFilter(m)) {
                return false;
            }
        }
        return true;
    }
}