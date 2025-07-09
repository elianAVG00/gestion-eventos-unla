-- DEPARTAMENTOS
INSERT INTO departamento (nombre, colorVisual) VALUES ('Humanidades y Artes', '#FF5733');
INSERT INTO departamento (nombre, colorVisual) VALUES ('Desarrollo Productivo Tecnologico', '#33FF57');
INSERT INTO departamento (nombre, colorVisual) VALUES ('Salud Comunitaria', '#3357FF');

-- USUARIOS
INSERT INTO usuario (nombre, email, rol, departamento_id)
VALUES ('Ana Solicitante', 'ana@unla.edu.ar', 'SOLICITANTE', 1);
INSERT INTO usuario (nombre, email, rol, departamento_id)
VALUES ('Carlos Técnico', 'carlos@unla.edu.ar', 'TECNICO', 2);
INSERT INTO usuario (nombre, email, rol, departamento_id)
VALUES ('Lucía Admin', 'lucia@unla.edu.ar', 'ADMIN_CEREMONIAL', 3);

-- ESPACIOS
INSERT INTO espacio (nombre, capacidad, ubicacion, disponible)
VALUES ('Aula Magna', 150, 'Jose Hernandez', true);
INSERT INTO espacio (nombre, capacidad, ubicacion, disponible)
VALUES ('Auditorio Central', 300, 'Juana Manso', true);
INSERT INTO espacio (nombre, capacidad, ubicacion, disponible)
VALUES ('Laboratorio 1', 30, 'Scalabrini Ortiz', true);

-- RECURSOS
INSERT INTO recurso (nombre, tipo, disponible)
VALUES ('Micrófono Inalámbrico', 'AUDIO', true);
INSERT INTO recurso (nombre, tipo, disponible)
VALUES ('Proyector 4K', 'VIDEO', true);
INSERT INTO recurso (nombre, tipo, disponible)
VALUES ('Técnico de Sonido', 'PERSONAL', true);

-- EVENTOS
INSERT INTO evento (nombre, fecha_inicio, fecha_fin, estado, solicitante_id, espacio_id, departamento_id)
VALUES ('Charla de bienvenida', '2025-08-01 09:00:00', '2025-08-01 11:00:00', 'APROBADO', 1, 1, 1);

INSERT INTO evento (nombre, fecha_inicio, fecha_fin, estado, solicitante_id, espacio_id, departamento_id)
VALUES ('Seminario de Tecnología', '2025-08-10 10:00:00', '2025-08-10 15:00:00', 'SOLICITADO', 1, 2, 2);

-- RELACIÓN MANY-TO-MANY: evento_recursos
INSERT INTO evento_recursos (evento_id, recursos_id) VALUES (1, 1);
INSERT INTO evento_recursos (evento_id, recursos_id) VALUES (1, 3);
INSERT INTO evento_recursos (evento_id, recursos_id) VALUES (2, 2);
