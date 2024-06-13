--
-- ���� ������������ � ������� SQLiteStudio v3.4.4 � �� ��� 27 19:27:27 2024
--
-- �������������� ��������� ������: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- �������: ages
CREATE TABLE IF NOT EXISTS ages (id INTEGER PRIMARY KEY AUTOINCREMENT, age INTEGER);
INSERT INTO ages (id, age) VALUES (1, 20);

-- �������: cities
CREATE TABLE IF NOT EXISTS cities (id INTEGER PRIMARY KEY AUTOINCREMENT, city varchar (255));
INSERT INTO cities (id, city) VALUES (1, '�������');

-- �������: disabilities
CREATE TABLE IF NOT EXISTS disabilities (id INTEGER PRIMARY KEY AUTOINCREMENT, disability varchar (255));
INSERT INTO disabilities (id, disability) VALUES (1, '���');
INSERT INTO disabilities (id, disability) VALUES (2, '3');
INSERT INTO disabilities (id, disability) VALUES (3, '2');
INSERT INTO disabilities (id, disability) VALUES (4, '1');

-- �������: employments
CREATE TABLE IF NOT EXISTS employments (id INTEGER PRIMARY KEY AUTOINCREMENT, employment varchar (255));
INSERT INTO employments (id, employment) VALUES (1, '����������');
INSERT INTO employments (id, employment) VALUES (2, '������������');

-- �������: first_name
CREATE TABLE IF NOT EXISTS first_name (id INTEGER PRIMARY KEY AUTOINCREMENT, gender_id INTEGER REFERENCES genders (id), name varchar (255));
INSERT INTO first_name (id, gender_id, name) VALUES (1, 2, '������');
INSERT INTO first_name (id, gender_id, name) VALUES (2, 1, '����');

-- �������: genders
CREATE TABLE IF NOT EXISTS genders (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar (255));
INSERT INTO genders (id, name) VALUES (1, '���');
INSERT INTO genders (id, name) VALUES (2, '���');

-- �������: last_names
CREATE TABLE IF NOT EXISTS last_names (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar (255));
INSERT INTO last_names (id, name) VALUES (1, '���������(��)');

-- �������: middle_names
CREATE TABLE IF NOT EXISTS middle_names (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar (255));
INSERT INTO middle_names (id, name) VALUES (1, '������(�)');

-- �������: official_employments
CREATE TABLE IF NOT EXISTS official_employments (id INTEGER PRIMARY KEY AUTOINCREMENT, official_employment varchar (255), employment_id INTEGER REFERENCES employments (id));
INSERT INTO official_employments (id, official_employment, employment_id) VALUES (1, '��� �����������', 1);
INSERT INTO official_employments (id, official_employment, employment_id) VALUES (2, '��� ��', 1);
INSERT INTO official_employments (id, official_employment, employment_id) VALUES (3, '�� ��', 1);
INSERT INTO official_employments (id, official_employment, employment_id) VALUES (4, '�� �����������', 1);

-- �������: regions
CREATE TABLE IF NOT EXISTS regions (id INTEGER PRIMARY KEY AUTOINCREMENT, region varchar (255));
INSERT INTO regions (id, region) VALUES (1, '��������� �������');

-- �������: registrations
CREATE TABLE IF NOT EXISTS registrations (id INTEGER PRIMARY KEY AUTOINCREMENT, registration varchar (255));
INSERT INTO registrations (id, registration) VALUES (1, '����������');
INSERT INTO registrations (id, registration) VALUES (2, '���������');

-- �������: terms
CREATE TABLE IF NOT EXISTS terms (id INTEGER PRIMARY KEY AUTOINCREMENT, term varchar (255));
INSERT INTO terms (id, term) VALUES (1, '15');
INSERT INTO terms (id, term) VALUES (2, '10');

-- �������: unofficial_employments
CREATE TABLE IF NOT EXISTS unofficial_employments (id INTEGER PRIMARY KEY AUTOINCREMENT, employment_id INTEGER REFERENCES employments (id), unofficial_employment varchar (255));
INSERT INTO unofficial_employments (id, employment_id, unofficial_employment) VALUES (1, 2, '�� �����������');
INSERT INTO unofficial_employments (id, employment_id, unofficial_employment) VALUES (2, 2, '�� ������������');
INSERT INTO unofficial_employments (id, employment_id, unofficial_employment) VALUES (3, 2, '�� ��');
INSERT INTO unofficial_employments (id, employment_id, unofficial_employment) VALUES (4, 2, '�� ����');

-- �������: work_experiences
CREATE TABLE IF NOT EXISTS work_experiences (id INTEGER PRIMARY KEY AUTOINCREMENT, work_experience INTEGER);
INSERT INTO work_experiences (id, work_experience) VALUES (1, 24);
INSERT INTO work_experiences (id, work_experience) VALUES (2, 2);
INSERT INTO work_experiences (id, work_experience) VALUES (3, 4);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
