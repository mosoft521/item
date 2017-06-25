package com.company.ch08Exception.item111;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        try {
            //Do Something
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
