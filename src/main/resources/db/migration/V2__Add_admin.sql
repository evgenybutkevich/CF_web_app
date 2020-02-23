INSERT INTO users (username, password, email, first_name, last_name, sex, avatar, active)
    VALUES ("admin", "$2a$08$vXsfy.raoc9D8in1Y94/Vep.gLaVFOAJhbEbOoNdZ7..8RPA2nQVi", "evge_nik@tut.by", "Evgeny", "Butkevich", "male", "user-male.png", true);

INSERT INTO user_role (user_id, roles) VALUES (1, "ADMIN"), (1, "USER");