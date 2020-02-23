INSERT INTO users (username, password, email, registration_date, first_name, last_name, sex, birth_date, avatar, active)
    VALUES ("user", "$2y$12$AV/CwFh7rSP8BtbUwowaCeahbFAgTyUTUoJfb/mIncjOnsYw7XWIW", "evgenik91@gmail.com", NOW(), "Svetlava", "Stelmakh", "female", NOW(), "user-female.png", true);

INSERT INTO user_role (user_id, roles) VALUES (2, "USER");