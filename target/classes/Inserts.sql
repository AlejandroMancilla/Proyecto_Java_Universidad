-- Script de población de la tabla City con 8 registros de Bucaramanga y su área metropolitana.
INSERT INTO City (name) VALUES
('Bucaramanga'),
('Floridablanca'),
('Girón'),
('Piedecuesta'),
('Lebrija'),
('Rionegro'),
('Los Santos');

-- Script de población de la tabla Address con 20 registros de direcciones de Bucaramanga y su área metropolitana
INSERT INTO Address (road, roadNumber, roadCross, roadDist) VALUES
('Calle 10', 12, 0, 0),
('Avenida 5', 45, 0, 0),
('Carrera 15', 78, 0, 0),
('Carrera 10', 32, 0, 0),
('Avenida 8', 65, 0, 0),
('Calle 20', 98, 0, 0),
('Calle 30', 12, 0, 0),
('Carrera 20', 45, 0, 0),
('Avenida 10', 79, 0, 0),
('Avenida 15', 32, 0, 0),
('Carrera 25', 65, 0, 0),
('Carrera 30', 98, 0, 0),
('Calle 40', 12, 0, 0),
('Avenida 20', 45, 0, 0),
('Calle 50', 78, 0, 0),
('Carrera 35', 31, 0, 0),
('Avenida 25', 64, 0, 0),
('Carrera 40', 97, 0, 0),
('Carrera 45', 13, 0, 0),
('Carrera 50', 46, 0, 0);

-- Inserción de 5 registros de nombres reales
INSERT INTO Building (name, levels) VALUES
('Torre del Este', 6),
('Edificio La Cumbre', 8),
('Torre Centenario', 5),
('Edificio El Pinar', 6),
('Torre del Norte', 5);

-- Script de población de la tabla Person con 20 registros, 12 jóvenes y 8 adultos, y ciudades de residencia de Bucaramanga y su área metropolitana
INSERT INTO Person (typeId, numId, name, lastName, phoneNumber, dateBirth, gender, cityResidence, addressId) VALUES
-- Personas jóvenes
('CC', '123456789', 'Juan', 'Gomez', '3001234567', '2000-01-01', 1, 1, 1),
('TI', '987654321', 'Maria', 'Rodriguez', '3012345678', '2001-02-02', 2, 2, 2), 
('CE', '567890123', 'Carlos', 'Martinez', '3023456789', '2002-03-03', 1, 3, 3), 
('CC', '345678901', 'Luisa', 'Lopez', '3034567890', '2003-04-04', 2, 4, 4), 
('TI', '901234567', 'Andres', 'Hernandez', '3045678901', '2004-05-05', 1, 1, 5),
('CC', '678901234', 'Camila', 'Perez', '3056789012', '2000-05-04', 2, 1, 6),
('TI', '234567890', 'Santiago', 'Gonzalez', '3067890123', '2002-07-04', 1, 2, 7),
('CE', '456789012', 'Valentina', 'Sanchez', '3078901234', '2000-11-08', 2, 2, 8),
('CC', '789012345', 'Pedro', 'Ramirez', '3089012345', '2005-29-09', 1, 2, 9), 
('TI', '012345678', 'Laura', 'Diaz', '3209876543', '2004-17-10', 2, 3, 
('CC', '543210987', 'Juan', 'Rodriguez', '3101234567', '204-08-11', 1, 4, 11),
('TI', '098765432', 'Maria', 'Martinez', '3112345678', '2003-12-02', 2, 4, 12), 
-- Personas adultas
('CC', '123456789', 'Carlos', 'Gomez', '3001234567', '1980-01-01', 1, 1, 13), 
('TI', '987654321', 'Luisa', 'Rodriguez', '3012345678', '1975-02-02', 2, 2, 14), 
('CE', '567890123', 'Andres', 'Martinez', '3023456789', '1970-03-03', 1, 2, 15),
('CC', '345678901', 'Camila', 'Lopez', '3034567890', '1965-04-04', 2, 2, 16), 
('TI', '901234567', 'Santiago', 'Hernandez', '3045678901', '1960-05-05', 1, 2, 17),
('CC', '678901234', 'Valentina', 'Perez', '3056789012', '1955-06-06', 2, 4, 18), 
('TI', '234567890', 'Pedro', 'Gonzalez', '3067890123', '1950-07-07', 1, 4, 19), 
('CE', '456789012', 'Laura', 'Sanchez', '3078901234', '1945-08-08', 2, 3, 20); 

