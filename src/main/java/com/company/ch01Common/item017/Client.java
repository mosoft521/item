package com.company.ch01Common.item017;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 慎用动态编译
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //Java源代码
        String sourceStr = "public class Hello{	public String sayHello(String name){return \"Hello,\" + name + \"!\";}}";
        //类名及文件名
        String clsName = "Hello";
        //方法名
        String methodName = "sayHello";
        //当前编译器
        JavaCompiler cmp = ToolProvider.getSystemJavaCompiler();
        //Java标准文件管理器
        StandardJavaFileManager fm = cmp.getStandardFileManager(null, null, null);
        //Java文件对象
        JavaFileObject jfo = new StringJFO(clsName, sourceStr);
        //编译参数，类似与javac <options>中的options
        List<String> optionsList = new ArrayList<String>();
        //编译文件的存放地方，注意：此处是为Eclipse工具特设的
        optionsList.addAll(Arrays.asList("-d", "./bin"));
        //要编译的单元
        List<JavaFileObject> jfos = Arrays.asList(jfo);
        //设置编译环境
        JavaCompiler.CompilationTask task = cmp.getTask(null, fm, null, optionsList, null, jfos);
        //编译成功
        if (task.call()) {
            //生成对象
            Object obj = Class.forName(clsName).newInstance();
            Class<? extends Object> cls = obj.getClass();
            //调用sayHello方法
            Method m = cls.getMethod(methodName, String.class);
            String str = (String) m.invoke(obj, "Dynamic Compilation");
            System.out.println(str);
        }
    }
}

//文本中的Java对象
class StringJFO extends SimpleJavaFileObject {
    //源代码
    private String content = "";

    //遵循Java规范的类名及文件
    public StringJFO(String _javaFileName, String _content) {
        super(_createStringJavaObjectUri(_javaFileName), Kind.SOURCE);
        content = _content;
    }

    //产生一个uri资源路径
    private static URI _createStringJavaObjectUri(String name) {
        //注意此处没有设置包名
        return URI.create("String:///" + name + Kind.SOURCE.extension);
    }

    //文本文件代码
    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors)
            throws IOException {
        return content;
    }
}