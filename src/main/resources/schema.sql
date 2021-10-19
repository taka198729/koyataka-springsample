/*従業員テーブル*/
CREATE TABLE IF NOT EXISTS employee(
    employee_id INT,
    employee_name VARCHAR(50),
    age INT
);
-- ALTER TABLE employee ADD CONSTRAINT employee_pk PRIMARY KEY(employee_id);

CREATE TABLE IF NOT EXISTS m_user(
    user_id VARCHAR(50),
    password VARCHAR(100),
    user_name VARCHAR(50),
    birthday DATE,
    age INT,
    marriage BOOLEAN,
    role VARCHAR(50)
);
-- ALTER TABLE m_user ADD CONSTRAINT m_user_pk PRIMARY KEY(user_id);