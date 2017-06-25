package com.company.ch06EnumAndAnnotation.item089;

import java.util.EnumSet;

//普通枚举项，数量小于64
enum Const {
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BA, CA, DA, EA, FA, GA, HA, NA, OA, PA, QA, RA, SA, TA, UA, VA, WA, XA, YA, ZA, BC, CC, DC, EC, FC, GC, HC, IC, JC, KC, LC, MC, NC, OC, PC, QC, RC;
}

//大枚举，数量超过64
enum LargeConst {
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BA, CA, DA, EA, FA, GA, HA, IA, JA, KA, LA, MA, NA, OA, PA, QA, RA, SA, TA, UA, VA, WA, XA, YA, ZA, AB, BB, CB, DB, EB, FB, GB, HB, IB, JB, KB, LB, MB;
}

public class Client {
    public static void main(String[] args) {
        //创建生成包含所有枚举项的EnumSet
        EnumSet<Const> cs = EnumSet.allOf(Const.class);
        EnumSet<LargeConst> lcs = EnumSet.allOf(LargeConst.class);
        //打印出枚举项数量
        System.out.println("Const枚举项数量：" + cs.size());
        System.out.println("LargeConst枚举项数量：" + lcs.size());
        //输出两个EnumSet的class
        System.out.println(cs.getClass());
        System.out.println(lcs.getClass());
    }
}