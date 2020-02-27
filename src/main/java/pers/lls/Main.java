package pers.lls;

import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        list.add(new A("1","1,2")) ;
        list.add(new A("1","1,2,3")) ;
        list.add(new A("2","1,2")) ;

        Collection<A> values = list.stream().collect(
                Collectors.toMap(A::getName, Function.identity(), ((a, a2) -> {
                    StringBuilder result = new StringBuilder();
                    a.setPermission(a.getPermission() + "," + a2.getPermission());

                    String[] strings = a.getPermission().split(",");
                    for (String s : new HashSet<>(Arrays.asList(strings))) {
                        result.append(s).append(",");
                    }

                    a.setPermission(result.toString().substring(0,result.toString().length()-1));
                    return a;
                }))).values();
        System.out.println(
                JSONObject.toJSONString(values)
        );
    }
}

class A {
    private String name;

    public A(String name, String permission) {
        this.name = name;
        this.permission = permission;
    }

    private String permission;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}