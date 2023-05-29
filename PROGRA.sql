CREATE TABLE cars(
id INT NOT NULL PRIMARY KEY,
matricula VARCHAR(8) NOT NULL UNIQUE,
marca VARCHAR(30) NOT NULL,
modelo INTEGER NULL,
motor VARCHAR(25) NULL,
gasolina VARCHAR(20) NOT NULL,
ruedas INTEGER NOT NULL,
puertas INTEGER NOT NULL
);

CREATE SEQUENCE CARS_ID
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1;
  
CREATE TABLE airplains(
id INT NOT NULL PRIMARY KEY,
matricula VARCHAR(8) NOT NULL UNIQUE,
marca VARCHAR(30) NOT NULL,
modelo INTEGER NULL,
motor VARCHAR(25) NULL,
gasolina VARCHAR(20) NOT NULL,
num_pasajeros INTEGER NOT NULL
);

CREATE SEQUENCE AIRPLAINS_ID
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1;

CREATE TABLE boats(
id INT NOT NULL PRIMARY KEY,
matricula VARCHAR(8) NOT NULL UNIQUE,
marca VARCHAR(30) NOT NULL,
motor VARCHAR(25) NULL,
gasolina VARCHAR(20) NOT NULL,
remos NUMBER(1,0) DEFAULT 0
);

CREATE SEQUENCE BOATS_ID
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1;