CREATE TABLE especialidad(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT
);

CREATE TABLE medico(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    id_especialidad INT,
    FOREIGN KEY (id_especialidad) REFERENCES especialidad(id) ON DELETE CASCADE
);

CREATE TABLE paciente(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    documento_identidad VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE cita(
	id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    motivo VARCHAR(255),
    id_paciente INT,
    id_medico INT,
    FOREIGN KEY (id_paciente) REFERENCES paciente(id) ON DELETE CASCADE,
    FOREIGN KEY (id_medico) REFERENCES medico(id) ON DELETE CASCADE
);

SELECT * FROM especialidad;

SELECT * FROM medico
INNER JOIN especialidad ON especialidad.id = medico.id_especialidad;

SELECT * FROM paciente;
