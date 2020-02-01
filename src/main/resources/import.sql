INSERT INTO role (role_name) VALUE ('ADMIN');
INSERT INTO role (role_name) VALUE ('MODERATOR');
INSERT INTO role (role_name) VALUE ('USER');

INSERT INTO users (login, password, address, discount, email, phone_no, user_name, user_surname, user_status, role_id) VALUE ('dami', 'damimiiim', 'sosnowiec, PL', 0, 'dami@ex.ex', '999 999 999', 'Damian', 'Soltysiuk', 'KEY_CLIENT', 3);
INSERT INTO users (login, password, address, discount, email, phone_no, user_name, user_surname, user_status, role_id) VALUE ('dada', 'dada', 'dada, PL', 10, 'dada@ex.ex', '123 123 123', 'dada', 'dada', 'NORMAL_CLIENT', 2);
INSERT INTO users (login, password, address, discount, email, phone_no, user_name, user_surname, user_status, role_id) VALUE ('ex', 'ex', 'ex, EX', 15, 'exex@ex.ex', '666 123 123', 'ex', 'ex', 'BANNED', 1);
