package com.learning.basics_and_collections.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exceptions {
    /*
     * Exception Hierarchy:
     * Throwable
     *     Error
     *           StackOverflowError
     *           VirtualMachineError
     *           OutOfMemoryError
     *     Exception
     *           IOException
     *           SQLException
     *           ClassNotFoundException
     *           RuntimeException
     *               ArithmeticException
     *               NullPointerException
     *               NumberFormatException
     *               IndexOutOfBoundsException
     *                   ArrayIndexOutOfBoundsException / StringIndexOutOfBoundsException
     *
     * Errors:
     * represents irrecoverable conditions such as JVM running out of memory, memory Leaks,
     * Stack overflow errors, Library incompatibility, infinite recursion.
     *
     * Exceptions:
     * can be caught and handled by program.
     * Types:
     * RuntimeExceptions/ unchecked exceptions:
     * Happens due to a programming error. These are checked at run-time.
     * By default, Unchecked Exceptions are forwarded in calling chain (propagated).
     * Such as:
     * IllegalArgumentException: Improper use of API
     * NullPointerException: Null pointer access
     * ArrayIndexOutOfBoundsException
     * ArithmeticException: Dividing a number by 0
     *
     * IOExceptions/ checked exceptions:
     * Checked by compiler at compile time and programmer is prompted to handle these exceptions.
     * By default, Checked Exceptions are not forwarded in calling chain (propagated).
     * Such as:
     * FileNotFoundException
     * */

    public static void main(String[] args) {

        // Ex1:
        try {
            int divide = 10 / 0;
            System.out.println("REST TRY BLOCK CODE!");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        } finally {
            /*
             * Use:
             * Code that might be skipped by return, continue or break
             * Closing a file or connection
             *
             * Case when doesn't execute:
             * Use of System.exit()
             * An exception occurs within
             * The death of a thread
             * */
            System.out.println("Executed every Time!");
        }

        // Ex2:
        /*
         * More than one catch statement:
         * */
        try {
            int[] array = new int[10];
            array[10] = 30 / 0;
        }
        /*
        //NOTE: All catch blocks must be ordered from most specific to most general.
        catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("\nException: " + e.getMessage());
        }
        */
        // or
        catch (Exception e) {
            System.out.println("\nException: " + e.getMessage());
        }

        // This gives compilation error!
        /*
        catch (Exception | ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        */


        // divideByZero();


        // Ex3:
        try {
            zeroDivision();
        } catch (RuntimeException e) {
            System.out.println("\nRuntimeException: " + e.getMessage());
        }


        /*
         * Try-with-resources statement:
         * Automatically closes all resources at the end of statement.
         * Resource is an object to be closed at the end of the program.
         *
         * try(resource){
         * } catch(ExceptionType e) { }
         * */

        String str;
        try (BufferedReader br = new BufferedReader(new FileReader("NonExisting.txt"))) {
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println("\nThrown Exception: " + e.getMessage());
            /*
             * Exception from [try] is thrown and,
             * Exception form [try-with-resources] is suppressed.
             * */

            // Retrieving suppressed exceptions
            Throwable[] suppressedExceptions = e.getSuppressed();
            for (Throwable suppressedException : suppressedExceptions) {
                System.out.println("Suppressed Exception: " + suppressedException);
            }
        }

        //Nested try-catch
        try {
            try {
                System.out.println("going to divide");
                int b = 39 / 0;
            } catch (ArithmeticException e) {
                System.out.println(e);
            }

            try {
                int a[] = new int[5];
                a[5] = 4;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }
            System.out.println("other statement");
        } catch (Exception e) {
            System.out.println("handled");
        }

    }

    Connection con;

    static void viewTab(Connection con) throws SQLException {
        String query = "SELECT COLUMN_NAME FROM TABLE_NAME";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String cData = rs.getString("COLUMN_NAME");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * Throw:
     * Throw one exception.
     *
     * Syntax: throw throwableObject
     * */
    public static void divideByZero() {
        throw new ArithmeticException("divide by zero!");
    }

    /*
     * Throws:
     * Used to declare the type of exception that might occur within method.
     * Used in method declaration.
     *
     * Syntax:
     * accessModifier returnType methodName() throws ExceptionType1, ExceptionType2 ...{ // code }
     * */
    public static void zeroDivision() throws RuntimeException {
        // code that may generate IOException
        int d = 10 / 0;
    }


}

class SuperClass {

    public void method1() throws RuntimeException {
        return;
    }
}
class SubClass extends SuperClass{

    @Override
    //public void method1() throws Exception { // Compile error - Parent exception not allowed
    public void method1() throws RuntimeException {
        return;
    }


}
