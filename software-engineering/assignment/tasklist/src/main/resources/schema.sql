--Alternatively, create the table in DataLoader using CommandLineRunner

CREATE TABLE IF NOT EXISTS Task (
    id INTEGER AUTO_INCREMENT,
    task_name varchar(255) NOT NULL,
    desc text,
    status VARCHAR(20) NOT NULL,
    priority INTEGER NOT NULL,
    date_created TIMESTAMP NOT NULL,
    primary key (id)
);

-- INSERT INTO Task(taskName, desc, status, priority, date_created)
-- VALUES('Task 1', 'Task 1 Description', 'Completed',3,CURRENT_TIMESTAMP())