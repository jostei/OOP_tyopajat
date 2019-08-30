--create tables
CREATE TABLE "course" (
	"course_name"	TEXT NOT NULL,
	"course_id"	TEXT NOT NULL,
	"credits"	INTEGER NOT NULL,
	PRIMARY KEY("course_id")
);
CREATE TABLE "student" (
	"first_name"	TEXT NOT NULL,
	"last_name"	TEXT NOT NULL,
	"student_num"	INTEGER NOT NULL UNIQUE,
	PRIMARY KEY("student_num")
);
CREATE TABLE "student_credit" (
	"s_num"	INTEGER NOT NULL,
	"c_id"	TEXT NOT NULL,
	"grade"	INTEGER NOT NULL,
	PRIMARY KEY("s_num","c_id"),
	FOREIGN KEY("s_num") REFERENCES "student"("student_num") ON DELETE CASCADE,
	FOREIGN KEY("c_id") REFERENCES "course"("course_id")
);

--Generate some students
INSERT INTO student(first_name,last_name,student_num) VALUES ("Vilho", "Kivihalme", 12345);
INSERT INTO student(first_name,last_name,student_num) VALUES ("Erno", "Lokkila", 223456);
INSERT INTO student(first_name,last_name,student_num) VALUES ("Erkki", "Kaila", 666);
INSERT INTO student(first_name,last_name,student_num) VALUES ("Mikko-Jussi", "Laakso",777);

--Add some courses
Insert INTO course(course_name,course_id,credits) VALUES ("Algorithm Design","TKO_1234",5);
Insert INTO course(course_name,course_id,credits) VALUES ("Tietokannat 1","TKO_6556",5);
Insert INTO course(course_name,course_id,credits) VALUES ("Tietojenkäsittelyn perusteet","TKO_7823",5);


--add credits for students
INSERT INTO student_credit(s_num,c_id,grade) VALUES (666,"TKO_1234",2);
INSERT INTO student_credit(s_num,c_id,grade) VALUES (777,"TKO_1234",3);
INSERT INTO student_credit(s_num,c_id,grade) VALUES (666,"TKO_6556",2);
INSERT INTO student_credit(s_num,c_id,grade) VALUES (666,"TKO_7832",2);
INSERT INTO student_credit(s_num,c_id,grade) VALUES (12345,"TKO_1234",4);
INSERT INTO student_credit(s_num,c_id,grade) VALUES (777,"TKO_7832",2);
INSERT INTO student_credit(s_num,c_id,grade) VALUES (223456,"TKO_1234",4);
INSERT INTO student_credit(s_num,c_id,grade) VALUES (223456,"TKO_7832",2);
INSERT INTO student_credit(s_num,c_id,grade) VALUES (12345,"TKO_6556",3);
INSERT INTO student_credit(s_num,c_id,grade) VALUES (223456,"TKO_6556",4);
INSERT INTO student_credit(s_num,c_id,grade) VALUES (777,"TKO_6556",5);
INSERT INTO student_credit(s_num,c_id,grade) VALUES (12345,"TKO_7832",4);

