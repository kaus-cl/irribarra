INSERT INTO user(id, name, email, password, created, last_login, token, active) VALUES ('661b3d58-f2ce-48f9-a018-95e78499deb1', "janis joplin", "password1", 1684873367275, null, null, true);
INSERT INTO user(id, name, email, password, created, last_login, token, active) VALUES ('7b3e2499-73d4-426a-bc52-e7de359d513f', "elvis presley", "password2", 1684873822444, null, null, true);
INSERT INTO user(id, name, email, password, created, last_login, token, active) VALUES ('c4d2ef93-8c27-4669-ac6c-41af4f8e06b3', "michael jackson", "password3", 1684873831884, null, null, true);

INSERT INTO phone(id, user_id, number, city_code, country_code) VALUES (1, '661b3d58-f2ce-48f9-a018-95e78499deb1', 555123456, 2, "1");
INSERT INTO phone(id, user_id, number, city_code, country_code) VALUES (2, '661b3d58-f2ce-48f9-a018-95e78499deb1', 555789012, 2, "1");
INSERT INTO phone(id, user_id, number, city_code, country_code) VALUES (3, 'c4d2ef93-8c27-4669-ac6c-41af4f8e06b3', 555000123, 5, "1");