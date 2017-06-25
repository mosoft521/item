package alvintest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alvin on 2014/7/14 0014.
 */
public class KeylessEntry {

    public static void main(String[] args) {
        Map m = new HashMap();
        for (int i = 0; i < 10000; i++)
            if (!m.containsKey(i))
                m.put(new Key(i), "Number:" + i);

        System.out.println("over");
    }

    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            boolean response = false;
            if (o instanceof Key) {
                response = (((Key) o).id).equals(this.id);
            }
            return response;
        }
    }
}
