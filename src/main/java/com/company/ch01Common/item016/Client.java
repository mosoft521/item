package com.company.ch01Common.item016;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 使用内置的脚本语言
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //获得一个javascript的执行引擎
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        //建立上下文变量
        Bindings bind = engine.createBindings();
        bind.put("factor", 1);
        //绑定上下文，作用域是当前引擎范围
        engine.setBindings(bind, ScriptContext.ENGINE_SCOPE);
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int first = input.nextInt();
            int sec = input.nextInt();
            System.out.println("输入参数是：" + first + "," + sec);
            //执行js代码
            engine.eval(new FileReader("L:\\ws_ij_java\\item\\src\\main\\java\\com\\company\\item016\\model.js"));
            //是否可调用方法
            if (engine instanceof Invocable) {
                Invocable in = (Invocable) engine;
                //执行js中的函数
                Double result = (Double) in.invokeFunction("formula", first, sec);
                System.out.println("运算结果：" + result.intValue());
            }
        }
    }
}