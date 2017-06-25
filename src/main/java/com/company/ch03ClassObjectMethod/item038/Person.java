package com.company.ch03ClassObjectMethod.item038;

/**
 * 建议38： 使用静态内部类提高封装性
 */
public class Person {
    //姓名
    private String name;
    //家庭
    private Home home;

    //构造函数设置属性值
    public Person(String _name) {
        name = _name;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        name = _name;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public static class Home {
        //家庭地址
        private String address;
        //家庭电话
        private String tel;

        public Home(String _address, String _tel) {
            address = _address;
            tel = _tel;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
