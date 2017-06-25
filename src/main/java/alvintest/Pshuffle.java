package alvintest;

/*=============================================*\
完美洗牌算法：
有个长度为2n的数组{a1,a2,a3,...,an,b1,b2,b3,...,bn}，
希望排序后{a1,b1,a2,b2,....,an,bn}，
要求时间复杂度o(n),空间复杂度0(1)。
\*=============================================*/
public class Pshuffle {

    public static void main(String[] args) {
        shuffle(8);
    }

    public static char[] shuffle(int count) {
        char[] arr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        return shuffle(arr, count);
    }

    public static char[] shuffle(char[] arr, int count) {
        for (int i = 0; i < count; i++) {
            int index = arr.length / 2;
            char temp = arr[index];
            while (index != 1) {
                int tempIndex = (index + (index % 2) * (arr.length - 1)) / 2;
                arr[index] = arr[tempIndex];
                index = tempIndex;
            }
            arr[1] = temp;
            System.out.println(arr);
        }
        return arr;
    }
}
//AaBDCFGHEJKLMgOPIRSTUVWXYZNbcdefQhijklmnopqrstuvwxyz
//ANaDBFGHCJKLMQOPERSTUVWXYZgbcdefIhijklmnopqrstuvwxyz
//AgNDaFGHBJKLMIOPCRSTUVWXYZQbcdefEhijklmnopqrstuvwxyz
//AQgDNFGHaJKLMEOPBRSTUVWXYZIbcdefChijklmnopqrstuvwxyz
//AIQDgFGHNJKLMCOPaRSTUVWXYZEbcdefBhijklmnopqrstuvwxyz
//AEIDQFGHgJKLMBOPNRSTUVWXYZCbcdefahijklmnopqrstuvwxyz
//ACEDIFGHQJKLMaOPgRSTUVWXYZBbcdefNhijklmnopqrstuvwxyz
//ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz