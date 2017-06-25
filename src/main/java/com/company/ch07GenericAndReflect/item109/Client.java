package com.company.ch07GenericAndReflect.item109;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Client {
    public static void main(String[] args) {
        BaseDao<String> userDao = new UserDao();
        userDao.get(12);
    }
}

abstract class BaseDao<T> {
    // 获得T的运行期类型
    private Class<T> clz = Utils.getGenricClassType(getClass());

    // 根据主键获得一条记录
    public void get(long id) {
        //session.get(clz,id);
    }
}

// 操作user表
class UserDao extends BaseDao<String> {
}

class Utils {
    // 获得一个泛型类的实际泛型类型
    public static <T> Class<T> getGenricClassType(Class clz) {
        Type type = clz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Type[] types = pt.getActualTypeArguments();
            if (types.length > 0 && types[0] instanceof Class) {
                //若有多个泛型参数，依据位置索引返回
                return (Class) types[0];
            }
        }
        return (Class) Object.class;
    }
}