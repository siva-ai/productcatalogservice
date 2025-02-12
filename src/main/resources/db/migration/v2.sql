ALTER TABLE tpc_instructor
DROP
COLUMN email;

ALTER TABLE tpc_mentor
DROP
COLUMN email;

ALTER TABLE tpc_ta
DROP
COLUMN email;

ALTER TABLE st_user
    MODIFY rating INT NOT NULL;

ALTER TABLE st_user
    MODIFY user_type VARCHAR (31) NULL;