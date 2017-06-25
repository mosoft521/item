package com.company.ch03ClassObjectMethod.item041;

//父亲
interface Father {
    public int strong();
}

//母亲
interface Mother {
    public int kind();
}

/**
 * 建议41： 让多重继承成为现实
 */
public class Client {
}

class FatherImpl implements Father {
    //父亲的强壮指数是8
    public int strong() {
        return 8;
    }
}

class MotherImpl implements Mother {
    //母亲的温柔指数是8
    public int kind() {
        return 8;
    }
}

class Son extends FatherImpl implements Mother {
    @Override
    public int strong() {
        //儿子比父亲强壮
        return super.strong() + 1;
    }

    @Override
    public int kind() {
        return new MotherSpecial().kind();
    }

    private class MotherSpecial extends MotherImpl {
        public int kind() {
            //儿子温柔指数降低了
            return super.kind() - 1;
        }
    }
}

class Daughter extends MotherImpl implements Father {
    @Override
    public int strong() {
        return new FatherImpl() {
            @Override
            public int strong() {
                //女儿的强壮指数降低了
                return super.strong() - 2;
            }
        }.strong();
    }
}