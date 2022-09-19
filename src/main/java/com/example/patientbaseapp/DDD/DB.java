package com.example.patientbaseapp.DDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {


        public static void main(String args[]) {

            Connection c = null;

            Statement stmt = null;

            try {

                Class.forName("org.postgresql.Driver");

                c = DriverManager.getConnection("jdbc:postgresql://abul.db.elephantsql.com:5432/ckkttdhb", "ckkttdhb", "nozrUH1mHHpvvm8s9L_JPAgb1bm14w20");

//     c.setAutoCommit(false);

                System.out.println("Successfully Connected.");


                stmt = c.createStatement();

                ResultSet rs = stmt.executeQuery("select * from hospital_db.patients ;");

                while (rs.next()) {

                    int id = rs.getInt("id");
                    String first_name = rs.getString("first_name");
                    String second_name = rs.getString("second_name");
                    String day_of_birth = rs.getString("day_of_birth");
                    String diagnosis = rs.getString("diagnosis");



                    System.out.printf("id = %s , first_name = %s, second_name = %s, day_of_birth = %s, diagnosis = %s", id, first_name, second_name, day_of_birth, diagnosis);

                    System.out.println();

                }

                rs.close();

                stmt.close();

                c.close();

            } catch (Exception e) {

                System.err.println(e.getClass().getName() + ": " + e.getMessage());

                System.exit(0);

            }

            System.out.println(" Data Retrieved Successfully ..");

        }
    }

