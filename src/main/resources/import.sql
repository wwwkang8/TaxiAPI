INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (1, 'wwwkang1@gmail.com', '123456789', 'passenger', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (2, 'wwwkang2@gmail.com', '123456789', 'passenger', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (3, 'wwwkang3@gmail.com', '123456789', 'passenger', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (4, 'wwwkang4@gmail.com', '123456789', 'passenger', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (5, 'wwwkang5@gmail.com', '123456789', 'passenger', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (6, 'wwwkang6@gmail.com', '123456789', 'passenger', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (7, 'wwwkang7@gmail.com', '123456789', 'passenger', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (8, 'wwwkang8@gmail.com', '123456789', 'passenger', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (9, 'wwwkang9@gmail.com', '123456789', 'passenger', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (10, 'wwwkang10@gmail.com', '123456789', 'passenger', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (11, 'driver1@gmail.com', '123456789', 'driver', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (12, 'driver2@gmail.com', '123456789', 'driver', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (13, 'driver3@gmail.com', '123456789', 'driver', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (14, 'driver4@gmail.com', '123456789', 'driver', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (15, 'driver5@gmail.com', '123456789', 'driver', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (16, 'driver6@gmail.com', '123456789', 'driver', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (17, 'driver7@gmail.com', '123456789', 'driver', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (18, 'driver8@gmail.com', '123456789', 'driver', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (19, 'driver9@gmail.com', '123456789', 'driver', 1);
INSERT INTO user (id, user_email, password, user_type, is_available) VALUES (20, 'driver10@gmail.com', '123456789', 'driver', 1);

INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (1, '광화문 15길','wwwkang1@gmail.com', '배차대기', null,now(), null , 1);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (2, '인덕원 503동','wwwkang2@gmail.com', '배차대기', null,now(), null , 2);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (3, '건영 캐스빌 1602호','wwwkang3@gmail.com', '배차대기', null, now(), null , 3);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (4, '아주대학교 팔달관','wwwkang4@gmail.com', '배차대기',  null, now(), null , 4);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (5, '아주대학교 용지관','wwwkang5@gmail.com', '배차대기', null,  now(), null , 5);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (6, '아주대학교 원천관','wwwkang6@gmail.com', '배차대기',  null, now(), null , 6);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (7, '신사동 가로수길','wwwkang7@gmail.com', '배차대기',  null, now(), null , 7);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (8, '아주대학교 화홍관','wwwkang8@gmail.com', '배차대기',  null, now(), null , 8);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (9, '아주대학교 종합관','wwwkang9@gmail.com', '배차대기',  null, now(), null , 9);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (10, '익선동', 'wwwkang10@gmail.com', '배차대기', null,  now(), null , 10);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (11, '드라마앤컴퍼니', 'wwwkang1@gmail.com', '배차대기',  null, now(), null , 1);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (12, '수원시 장안구', 'wwwkang2@gmail.com', '배차대기', null,  now(), null , 2);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (13, '태영 아파트', 'wwwkang3@gmail.com', '배차대기', null,  now(), null , 3);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (14,  '롯데몰','wwwkang4@gmail.com', '배차대기', null,  now(), null , 4);
INSERT INTO booking (id, destination,passenger, status, driver, create_date, assigned_date, user_id) VALUES (15,  '아주대학교 도서관','wwwkang5@gmail.com', '배차대기',  null, now(), null , 5);
INSERT INTO booking (id, destination,passenger, status, driver, create_date, assigned_date, user_id) VALUES (16, '아주대학교 카페', 'wwwkang6@gmail.com', '배차대기', null,  now(), null , 6);
INSERT INTO booking (id, destination,passenger, status, driver, create_date, assigned_date, user_id) VALUES (17, '아주대학교 정문', 'wwwkang7@gmail.com', '배차대기',  null, now(), null , 7);
INSERT INTO booking (id, destination,passenger, status, driver, create_date, assigned_date, user_id) VALUES (18,  '아주대학교 다산관','wwwkang8@gmail.com', '배차대기', null,  now(), null , 8);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (19, '아주대학교 율곡관', 'wwwkang9@gmail.com', '배차대기', null,  now(), null , 9);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (20, '아주대학교 성호관', 'wwwkang10@gmail.com', '배차대기', null,  now(), null , 10);
INSERT INTO booking (id, destination,  passenger, status, driver, create_date, assigned_date, user_id) VALUES (21, '아주대학교 학생회관', 'wwwkang1@gmail.com', '배차대기', null,  now(), null , 1);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (22, '아주대학교 기숙사', 'wwwkang2@gmail.com', '배차대기', null,  now(), null , 2);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (23, '아주대학교 국제학사', 'wwwkang3@gmail.com', '배차대기',  null, now(), null , 3);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (24, '아주대학교 홍문관', 'wwwkang4@gmail.com', '배차대기',  null, now(), null , 4);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (25, '홍대 곱창집 15길', 'wwwkang5@gmail.com', '배차대기',  null, now(), null , 5);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (26, '마포구 상수역', 'wwwkang6@gmail.com', '배차대기',  null, now(), null , 6);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (27, '수원역 로데오거리','wwwkang7@gmail.com', '배차대기', null,  now(), null , 7);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (28, '권선구 권선동','wwwkang8@gmail.com', '배차대기', null,  now(), null , 8);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (29, '경희대학교 정문','wwwkang9@gmail.com', '배차대기', null,  now(), null , 9);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (30, '연세대학교 정문', 'wwwkang10@gmail.com', '배차대기',  null, now(), null , 10);
INSERT INTO booking (id, destination, passenger, status, driver, create_date, assigned_date, user_id) VALUES (31, '연세대학교 후문', 'wwwkang10@gmail.com', '배차대기',  null, now(), null , 10);
