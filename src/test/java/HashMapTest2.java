import org.junit.Test;

import java.util.HashMap;

/**
 * @copyright 版权所有<2010-2050> 上海登飞计算机科技有限公司
 * @version： 1.0 \n
 * 程序包/文件名：	PACKAGE_NAME/HashMapTest2\n
 * 创建及变更历史：[格式说明：日期/执行者\n {--删减++增加**变更}描述]\n
 * TODO
 * <p/>
 * 2012-04-12/Alvin  创建
 */
public class HashMapTest2 {
    @Test
    public void test1() {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("a", "aaa");
        hm.put("b", "bbb");
        hm.get("a");
    }
}
