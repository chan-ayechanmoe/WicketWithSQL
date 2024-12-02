package com.example.wicket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class HomePage extends WebPage {
    public HomePage() {
//        add(new Label("message", "Hello, World!"));
    	
    	String dbMessage = "Database connection not attempted.";
        try (Connection conn = DatabaseUtil.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT TOP 1 CusCode As 'CustomerCode' FROM [dbo].[Customer]");
            if (rs.next()) {
                dbMessage = rs.getString("CustomerCode");
            }
        } catch (Exception e) {
            dbMessage = "Database error: " + e.getMessage();
        }

        add(new Label("dbMessage", dbMessage));
    }
}
