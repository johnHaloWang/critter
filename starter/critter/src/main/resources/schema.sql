CREATE TABLE IF NOT EXISTS employee_employee_skill (
    _id bigint not null,
    EmployeeSkill bigint not null, -- the ordinal number of enum value
    primary key (_id, EmployeeSkill)
);
