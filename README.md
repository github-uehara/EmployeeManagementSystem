### EmployeeManagementSystem
社員管理システム - SpringBoot
10238 上原功也

---
### 追加  
- Lombok

### SQL
```
CREATE database employee_db;
```
```
CREATE TABLE employee( 
    employee_id VARCHAR (8) NOT NULL UNIQUE
    , affiliation_cd VARCHAR (6) NOT NULL
    , position_cd VARCHAR (4) NOT NULL
    , employee_nm VARCHAR (64) NOT NULL
    , gender VARCHAR (1) NOT NULL
    , birthday DATE NOT NULL
    , foreign_nationality BOOLEAN NOT NULL DEFAULT false
    , base_salary DECIMAL (7, 2) NOT NULL
    , memo TEXT
    , insert_user VARCHAR (16) NOT NULL
    , insert_time DATETIME NOT NULL
    , update_user VARCHAR (16) NOT NULL
    , update_time DATETIME NOT NULL
    , PRIMARY KEY (employee_id)
    , FOREIGN KEY fk_affiliation_cd(affiliation_cd) REFERENCES m_affiliation(affiliation_cd)
    , FOREIGN KEY fk_position_cd(position_cd) REFERENCES m_position(position_cd)
);
```
```
CREATE TABLE m_affiliation( 
    affiliation_cd VARCHAR (6) NOT NULL UNIQUE
    , management_cd VARCHAR (2) NOT NULL
    , brunch_cd VARCHAR (2)
    , group_cd VARCHAR (2)
    , management_nm VARCHAR (32) NOT NULL
    , brunch_nm VARCHAR (32)
    , group_nm VARCHAR (32)
    , management_employee_id VARCHAR (8)
    , insert_user VARCHAR (16) NOT NULL
    , insert_time DATETIME NOT NULL
    , update_user VARCHAR (16) NOT NULL
    , update_time DATETIME NOT NULL
    , PRIMARY KEY (affiliation_cd)
);
```
```
CREATE TABLE m_position( 
    position_cd VARCHAR (4) NOT NULL UNIQUE
    , grade_cd VARCHAR (2) NOT NULL
    , rank_cd VARCHAR (2) NOT NULL
    , position_nm VARCHAR (32) NOT NULL
    , insert_user VARCHAR (16) NOT NULL
    , insert_time DATETIME NOT NULL
    , update_user VARCHAR (16) NOT NULL
    , update_time DATETIME NOT NULL
    , PRIMARY KEY (position_cd)
);
```
