package com.learning.Interview;

import java.io.IOException;
import java.sql.SQLException;

public class ExceptionFAQ extends S{
    public static void main(String[] args) throws SQLException, IOException {

        ExceptionFAQ o1 = new ExceptionFAQ();
        o1.method1();

        S o2 = new S();
        o2.method1();
    }

    void method1 () throws SQLException {
        throw new SQLException();
    }
}

class S {
    void method1() throws IOException, SQLException {
        throw new IOException();
    }
}


