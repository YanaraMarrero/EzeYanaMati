DROP DATABASE IF EXISTS ProgYBD;

CREATE DATABASE ProgYBD;

USE ProgYBD;

CREATE TABLE Perfil (
id INT AUTO_INCREMENT,
nom1 VARCHAR(20) NOT NULL,
nom2 VARCHAR(20),
ape1 VARCHAR(20) NOT NULL,
ape2 VARCHAR(20),
fechaNac VARCHAR(10) NOT NULL,
fechaFall VARCHAR(10) NOT NULL,
nacionalidad VARCHAR(32) NOT NULL,

PRIMARY KEY (id)
);

CREATE TABLE Ocupacion (
ocupacion_id INT AUTO_INCREMENT,
perfil_id INT,
ocupacion VARCHAR(255) NOT NULL,

PRIMARY KEY (ocupacion_id),
FOREIGN KEY (perfil_id) REFERENCES Perfil(id)
);

CREATE TABLE Logro (
logro_id INT AUTO_INCREMENT,
perfil_id INT,
logro VARCHAR(255) NOT NULL,

PRIMARY KEY (logro_id),
FOREIGN KEY (perfil_id) REFERENCES Perfil(id)
);

INSERT INTO Perfil (nom1, nom2, ape1, ape2, fechaNac, fechaFall, nacionalidad)
VALUES
#1
('Ada', null, 'Lovelace', null, '10/12/1815', '20/11/1852', 'Británica'),
#2
('Barbara', null, 'Thoens', null, '20/06/1949', '14/12/2017', 'Alemana'),
#3
('Betty', null, 'Synder', 'Holberton', '07/03/1917', '08/12/2001', 'Brítanica'),
#4
('Carol', null, 'Shaw', null, '11/12/1955', 'Viva', 'Estadounidense'),
#5
('Erna', null, 'Schneider', 'Hoover', '19/06/1923', 'Viva', 'Estadounidense'),
#6
('Evelyn', null, 'Berezin', null, '12/04/1925', '08/12/2018', 'Estadounidense '),
#7
('Frances', null, 'E.','Allen', '04/08/1932', '04/08/2020', 'Estadounidense'),
#8
('Grace', null, 'Murray', 'Hopper', '09/12/1906', '01/01/1992', 'Estadounidense'),
#9
('Hedy', null, 'Lamarr', null, '09/11/1914', '19/01/2000', 'Austro estadounidense'),
#10
('Jean', null, 'Bartik', null, '20/12/1924', '23/03/2011', 'Estadounidense'),
#11
('Jean', null, 'E.', 'Sammet', '23/03/1928', '21/05/2017', 'Estadounidense'),
#12
('Joan', null, 'Clarke', null, '24/06/1917', '04/09/1996', 'Británica'),
#13
('Joanna', null, 'Rutkowska', null, '03/10/1981', 'Viva', 'Polaca'),
#14
('Jude', null, 'Milhon', null, '12/07/1939', '19/07/2003', 'Estadounidense'),
#15
('Karen', null, 'Spärck', 'Jones', '26/08/1935', '04/04/2007', 'Británica'),
#16
('Kathleen', 'McNulty', 'Mauchly', 'Anton', '12/02/1921', '20/04/2006', 'Estadounidense'),
#17
('Lynn', null, 'Conway', null, '02/01/1938', 'Viva', 'Estadounidense'),
#18
('Margaret', null, 'Hamilton', null, '17/08/1936', 'Viva', 'Estadounidense'),
#19
('Marlyn', null,'Wescoff', 'Meltzer', '16/05/1922', '04/12/2008', 'Estadounidense'),
#20
('Radia', null, 'Perlman', null, '18/12/1951', 'Viva', 'Estadounidense'),
#21
('Rózsa', null, 'Péter', null, '17/02/1905', '09/02/1986', 'Estadounidense'),
#22
('Ruth', null,'Lichterman', 'Teitelbaum', '01/02/1924', '16/02/1977', 'Húngara'),
#23
('Gertrude', null, 'Blanch', null, '02/03/1897', '07/01/1996', 'Estadounidense');

INSERT INTO Ocupacion (perfil_id, ocupacion) VALUES
(1, 'Matemática'),
(1, 'Escritora'),
(2, 'Hacker'),
(2, 'Seguridad Informatica'),
(3, 'Cientifica de la compuacion'),
(4, 'Informatica'),
(4, 'Diseñadora de juegos'),
(5, 'Inventora'),
(5, 'Cientifica'),
(6, 'Informatica'),
(7, 'Cientifica de la computación'),
(8, 'Cientifica de la coputación'),
(8, 'Admirante de la marina'),
(9, 'Actriz'),
(9, 'Inventora'),
(10, 'Cientifica de la computacion'),
(11, 'Cientifica de la computación'),
(12, 'Matemática'),
(12, 'Criptógrafa'),
(13, 'Experta en seguriad informatica'),
(14, 'Escritora'),
(14, 'Activista'),
(15, 'Cientifica de la computación'),
(16, 'Matematica'),
(17, 'Ingeniera elctrica'),
(18, 'Cientifica de la computación'),
(19, 'Matemática'),
(19, 'Informatica'),
(20, 'Ingeniera en redes'),
(21, 'Programadora'),
(22, 'Matemática'),
(22, 'Autora'),
(23, 'Matemática'),
(23, 'Estadistíca');

INSERT INTO Logro (perfil_id, logro) VALUES
(1, 'Ser la primera programadora.'),
(2, 'Pionera en la Automatización de Tareas Paralelas.'),
(3, 'Programadora de la ENIAC.'),
(4, 'Dejó una marca significativa en la industria de los videojuegos al abrir camino para otras mujeres en este campo.'),
(4, 'Primer mujer creadora de videojuegos.'),
(5, 'Desarrollo del sistema de control de tráfico telefónico.'),
(6, 'Diseñadora de la primera palabra procesadora electrónica.'),
(7, 'Primera mujer en ganar el premio Turing.'),
(8, 'Hopper fue una de las primeras programadoras de la computadora Harvard Mark I a principios de la década de 1940.'),
(8,'Hopper lideró el equipo que desarrolló el primer compilador de programación, conocido como A-0, que traducía instrucciones en lenguaje de programación de alto nivel'),
(9, 'Invención del espectro ensanchado.'),
(9, 'Fue reconocida como una contribución fundamental al desarrollo de tecnologías modernas de comunicación inalámbrica.'),
(10, 'Una de las primeras programadoras de la ENIAC.'),
(11, 'Creadora de el lenguaje de programación FORMAC.'),
(12, 'Desarollo codigos durante la segunda guerra mundial.'),
(13, 'Conocida por su trabajo en "Blue Pill".'),
(14, 'Pionera en el ciberfeminismo'),
(15,'Contribuyó al procesamiento del lenguaje natural.'),
(16, 'Fue una de las primeras programadoras de la ENIAC.'),
(17, 'Activista por los derechos transgenero'),
(17, 'Contribuyó a la arquitectura de diseño VLSI.'),
(18, 'Lidero el equipo de software del proyecto Apollo.'),
(19, 'Una de las primeras programadoras del grupo ENIAC.'),
(20, 'Creadora del protocolo de árbol de expansión STP.'),
(21, 'Fue una pionera en el campo de la lógica matemática. Es especialmente conocida por su trabajo en lógica recursiva y la teoría de las computadoras.'),
(22, 'Fue una de las programadoras del ENIAC,  Junto con otras mujeres programadoras, ayudó a desarrollar el software para el ENIAC durante la Segunda Guerra Mundial'),
(22, 'Participó en el desarrollo del UNIVAC I, el primer ordenador comercialmente disponible en los Estados Unidos, producido por Remington Rand.'),
(23, 'Contribuyó a la teoria de números y la estadistica.');

CREATE TABLE Imagen (
imagen_id INT AUTO_INCREMENT ,
titulo VARCHAR(255) NOT NULL,
imagen VARCHAR(255) NOT NULL,

PRIMARY KEY (imagen_id)
);

INSERT INTO Imagen (titulo, imagen)
VALUES
('Ada Lovelace', 'src/img/Ada_Lovelace.jpg'),
('Barbara Thoens', 'src/img/Barbara_Thoens.jpg'),
('Betty Snyder Holberton', 'src/img/Betty_Snyder_Holberton.jpg'),
('Carol Shaw', 'src/img/Carol_Shaw.jpg'),
('Erna Schneider Hoover', 'src/img/Erna_Schneider_Hoover.jpg'),
('Evelyn Berezin', 'src/img/Evelyn_Berezin.jpg'),
('Frances E Allen', 'src/img/Frances_E_Allen.jpg'),
('Gertrude Blanch', 'src/img/Gertrude_Blanch.jpg'),
('Grace Murray Hopper', 'src/img/Grace_Murray_Hopper.jpg'),
('Hedy Lamarr', 'src/img/Hedy_Lamarr.jpg'),
('Jean Bartik', 'src/img/Jean_Bartik.jpg'),
('Jean E Sammet', 'src/img/Jean_E_Sammet.jpg'),
('Joan Clarke', 'src/img/Joan_Clarke.jpg'),
('Joanna Rutkowska', 'src/img/Joanna_Rutkowska.jpg'),
('Jude Milhon', 'src/img/Jude_Milhon.jpg'),
('Karen Spärck Jones', 'src/img/Karen_Sparck_Jones.jpg'),
('Kathleen McNulty Mauchly Anton', 'src/img/Kathleen_McNulty_Mauchly_Anton.jpg'),
('Lynn Conway', 'src/img/Lynn_Conway.jpg'),
('Margaret Hamilton', 'src/img/Margaret_Hamilton.jpg'),
('Marlyn Wescoff Meltzer', 'src/img/Marlyn_Wescoff_Meltzer.jpg'),
('Radia Perlman', 'src/img/Radia_Perlman.jpg'),
('Rózsa Péter', 'src/img/Rozsa_Peter.jpg'),
('Ruth Lichterman Teitelbaum', 'src/img/Ruth_Lichterman_Teitelbaum.jpg');

SELECT p.*,
    GROUP_CONCAT(DISTINCT o.ocupacion ORDER BY o.ocupacion SEPARATOR ', ') AS ocupaciones,
    GROUP_CONCAT(DISTINCT l.logro ORDER BY l.logro SEPARATOR ', ') AS logros
FROM Perfil p
LEFT JOIN Ocupacion o ON p.id = o.perfil_id
LEFT JOIN Logro l ON p.id = l.perfil_id
GROUP BY p.id;