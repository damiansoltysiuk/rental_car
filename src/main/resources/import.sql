INSERT INTO role (role_name) VALUE ('ADMIN');
INSERT INTO role (role_name) VALUE ('MODERATOR');
INSERT INTO role (role_name) VALUE ('USER');

INSERT INTO users (login, password, address, discount, email, phone_no, user_name, user_surname, user_status, role_id) VALUE ('dami', 'damimiiim', 'sosnowiec, PL', 0, 'dami@ex.ex', '999 999 999', 'Damian', 'Soltysiuk', 'KEY_CLIENT', 3);
INSERT INTO users (login, password, address, discount, email, phone_no, user_name, user_surname, user_status, role_id) VALUE ('dada', 'dada', 'dada, PL', 10, 'dada@ex.ex', '123 123 123', 'dada', 'dada', 'NORMAL_CLIENT', 2);
INSERT INTO users (login, password, address, discount, email, phone_no, user_name, user_surname, user_status, role_id) VALUE ('ex', 'ex', 'ex, EX', 15, 'exex@ex.ex', '666 123 123', 'ex', 'ex', 'BANNED', 1);

INSERT INTO equipment_version (equipment_name, description) VALUE ('CLASSIC', 'Automatic air condition, Rear parking sensor');
INSERT INTO equipment_version (equipment_name, description) VALUE ('ELEGANCE', 'Automatic air condition, Rear parking sensor, Front parking sensor, Leather seats, Rain sensor');
INSERT INTO equipment_version (equipment_name, description) VALUE ('ELEGANCE', 'Automatic air condition, Rear parking sensor, Front parking sensor, Leather seats, Rain sensor, Keyless, Reversing camera');

INSERT INTO model (name, generation, foto_directory, car_type, equipment_version_id) VALUE ('E500', 'W211', 'https://xx.xx/xx.jpg', 'PREMIUM_CAR', 3);
INSERT INTO model (name, generation, foto_directory, car_type, equipment_version_id) VALUE ('E220CDI', 'W210', 'https://xx.xx/xy.jpg', 'LARGE_CAR', 1);

INSERT INTO cars (registration_number, mark, fuel_level, production_year, car_status, model_id, car_condition_note) VALUE ('B0 LUX', 'MERCEDES', 1.0, 2010, 'UNRESERVED', 1, 'Only company client');
INSERT INTO cars (registration_number, mark, fuel_level, production_year, car_status, model_id, car_condition_note) VALUE ('B0 BIEDA', 'MERCEDES', 0.8, 2007, 'RESERVED', 2, 'Only plebs');