public class HashMapTest {
    /**
     * Applies a supplemental hash function to a given hashCode, which
     * defends against poor quality hash functions.  This is critical
     * because HashMap uses power-of-two length hash tables, that
     * otherwise encounter collisions for hashCodes that do not differ
     * in lower bits. Note: Null keys always map to hash 0, thus index 0.
     */
    static int hash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * Returns index for hash code h.
     */
    static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    public static void main(String[] args) {
        int length = 1 << 3;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 100; i++) {
            int h = hash(i);
            sb.append("\n" + i + ": ").append(h);
            sb.append(" # " + i + ": ").append(indexFor(h, length));
        }
        System.out.println(sb.toString());
    }
}
