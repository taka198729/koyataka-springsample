package com.example.demo.login.domain.repository.jdbc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;

public class UserRowCallbackHandler implements RowCallbackHandler {

    @Override
    public void processRow(ResultSet rs) throws SQLException {

        try {

            File file = new File("sample.csv");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            do {

                String seperator = ",";
                StringBuilder sb = new StringBuilder();

                sb.append(rs.getString("user_id"));
                sb.append(seperator);
                sb.append(rs.getString("password"));
                sb.append(seperator);
                sb.append(rs.getString("user_name"));
                sb.append(seperator);
                sb.append(rs.getDate("birthday"));
                sb.append(seperator);
                sb.append(rs.getInt("age"));
                sb.append(seperator);
                sb.append(rs.getBoolean("marriage"));
                sb.append(seperator);
                sb.append(rs.getString("role"));

                String str = new String(sb);

                bw.write(str);
                bw.newLine();

            } while (rs.next());

            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
    }
}