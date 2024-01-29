package com.thg.springbootdb.persistence;

import com.thg.springbootdb.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Task> getAllTasks() throws Exception {
        return jdbcTemplate.query("select * from tasks" , (rs, rowNum) ->
                new Task(
                        rs.getString("name"),
                        rs.getBoolean("isComplete"),
                        rs.getInt("priority")
                ));
    }
}
