package com.thg.springbootdb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DBInit {
    private static final Logger log = LoggerFactory.getLogger(DBInit.class);
    @Bean
    public CommandLineRunner initialiseDatabase(JdbcTemplate jdbcTemplate) {
        log.info("Initialising database..");
        return args -> {
            log.info("Creating languages table");
            jdbcTemplate.execute("create table if not exists tasks(id bigint auto_increment primary key, name varchar(50), isComplete boolean, priority int)");


            Integer count = jdbcTemplate.queryForObject("select count(*) from tasks", Integer.class);
            if (count != null && count == 0) {
                log.info("inserting...");
                log.info("inserted: " + jdbcTemplate.update("insert into tasks (name, isComplete, priority) values ('task1',false, 1)"));
                log.info("inserted: " + jdbcTemplate.update("insert into tasks (name, isComplete, priority ) values ('task2',true, 2)"));
                log.info("inserted: " + jdbcTemplate.update("insert into tasks (name, isComplete, priority) values ('task3',false, 2)"));
                log.info("inserted: " + jdbcTemplate.update("insert into tasks (name, isComplete, priority) values ('task4',false, 3)"));
                log.info("inserted: " + jdbcTemplate.update("insert into tasks (name, isComplete, priority) values ('task5',true, 3)"));
                log.info("inserted: " + jdbcTemplate.update("insert into tasks (name, isComplete, priority) values ('task6',false, 4)"));
                log.info("inserted: " + jdbcTemplate.update("insert into tasks (name, isComplete, priority) values ('task7',false, 4)"));
                log.info("inserted: " + jdbcTemplate.update("insert into tasks (name, isComplete, priority) values ('task8',false, 5)"));
            } else {
                log.info("database already initialised");
            }
        }; }
}