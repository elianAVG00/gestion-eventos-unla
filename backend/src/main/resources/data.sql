-- DEPARTAMENTOS
INSERT INTO departamento (id, nombre, color_visual) VALUES (1, 'Humanidades y Artes', '#FF5733');
INSERT INTO departamento (id, nombre, color_visual) VALUES (2, 'Desarrollo Productivo y Tecnológico', '#33FF57');
INSERT INTO departamento (id, nombre, color_visual) VALUES (3, 'Salud Comunitaria', '#3357FF');

-- USUARIOS
INSERT INTO usuario (id, nombre, email, rol, departamento_id)
VALUES (1, 'Ana Solicitante', 'ana@unla.edu.ar', 'SOLICITANTE', 1);
INSERT INTO usuario (id, nombre, email, rol, departamento_id)
VALUES (2, 'Carlos Técnico', 'carlos@unla.edu.ar', 'TECNICO', 2);
INSERT INTO usuario (id, nombre, email, rol, departamento_id)
VALUES (3, 'Lucía Admin', 'lucia@unla.edu.ar', 'ADMIN_CEREMONIAL', 3);

-- ESPACIOS
INSERT INTO espacio (id, nombre, capacidad, ubicacion, disponible)
VALUES (1, 'Aula Magna', 150, 'Jose Hernandez', true);
INSERT INTO espacio (id, nombre, capacidad, ubicacion, disponible)
VALUES (2, 'Auditorio Central', 300, 'Juana Manso', true);
INSERT INTO espacio (id, nombre, capacidad, ubicacion, disponible)
VALUES (3, 'Laboratorio 1', 30, 'Scalabrini Ortiz', true);

-- RECURSOS
INSERT INTO recurso (id, nombre, tipo, disponible)
VALUES (1, 'Micrófono Inalámbrico', 'AUDIO', true);
INSERT INTO recurso (id, nombre, tipo, disponible)
VALUES (2, 'Proyector 4K', 'VIDEO', true);
INSERT INTO recurso (id, nombre, tipo, disponible)
VALUES (3, 'Técnico de Sonido', 'PERSONAL', true);

-- EVENTOS
INSERT INTO evento (id, nombre, fecha_inicio, fecha_fin, estado, solicitante_id, espacio_id, departamento_id)
VALUES (1, 'Charla de bienvenida', '2025-08-01T09:00:00', '2025-08-01T11:00:00', 'APROBADO', 1, 1, 1);

INSERT INTO evento (id, nombre, fecha_inicio, fecha_fin, estado, solicitante_id, espacio_id, departamento_id)
VALUES (2, 'Seminario de Tecnología', '2025-08-10T10:00:00', '2025-08-10T15:00:00', 'EN_REVISION', 1, 2, 2);

-- RELACIÓN MANY-TO-MANY: evento_recursos
INSERT INTO evento_recursos (evento_id, recursos_id) VALUES (1, 1);
INSERT INTO evento_recursos (evento_id, recursos_id) VALUES (1, 3);
INSERT INTO evento_recursos (evento_id, recursos_id) VALUES (2, 2);
