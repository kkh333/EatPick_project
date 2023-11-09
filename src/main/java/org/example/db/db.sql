#테이터베이스 삭제 및 생성
DROP DATABASE IF EXISTS proj1;
CREATE DATABASE proj1;

#테이터베이스 선택
USE proj1;

#테이블 조회
SHOW tables;

#테이블 생성
DROP TABLE `member`;
DROP TABLE article;

#테이블 생성
CREATE TABLE `member` (
    id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nickname char(100) NOT NULL UNIQUE,
    `password` char(100) NOT NULL,
    regDate datetime  NOT NULL
);

CREATE TABLE article (
    id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    category char(100) NOT NULL,
    foodName char(100) NOT NULL,
    brandName char(100) NOT NULL,
    price int NOT NULL,
    weight int NOT NULL,
    `scope` int NOT NULL,
    review text NOT NULL,
    writer char(100) NOT NULL,
    regDate datetime  NOT NULL
);

#기본 관리자 및 사용자 생성
INSERT INTO `member`
SET nickname = "관리자",
`password` = "123",
regDate = now();

INSERT INTO `member`
SET nickname = "김경호",
`password` = "123",
regDate = now();

INSERT INTO `member`
SET nickname = "장진윤",
`password` = "123",
regDate = now();

INSERT INTO `member`
SET nickname = "한재현",
`password` = "123",
regDate = now();

#기본 데이터 생성
INSERT INTO article
SET category = "육류",
foodName = "소안창살",
brandName = "한돈",
price = 45000,
weight = 600,
`scope` = 5,
review = "가성비로 먹기 좋아요.",
writer = "김경호",
regDate = now();

INSERT INTO article
SET category = "육류",
foodName = "소등심살",
brandName = "한돈",
price = 35000,
weight = 600,
`scope` = 3,
review = "좀 질기네요.",
writer = "장진윤",
regDate = now();

INSERT INTO article
SET category = "육류",
foodName = "소갈비살",
brandName = "한돈",
price = 65000,
weight = 500,
`scope` = 5,
review = "역시 소는 갈비살이죠.",
writer = "한재현",
regDate = now();

INSERT INTO article
SET category = "육류",
foodName = "닭가슴살",
brandName = "맛있닭",
price = 1800,
weight = 100,
`scope` = 5,
review = "가격대비 너무 맛있어요.",
writer = "김경호",
regDate = now();

INSERT INTO article
SET category = "육류",
foodName = "닭안심살",
brandName = "아임닭",
price = 2300,
weight = 100,
`scope` = 4,
review = "맛있기는 하지만 너무 비싸요.",
writer = "장진윤",
regDate = now();

INSERT INTO article
SET category = "육류",
foodName = "닭다리살",
brandName = "허닭",
price = 2800,
weight = 100,
`scope` = 5,
review = "닭가슴살이 너무 지겨워서 구매했는데 맛있어요.",
writer = "한재현",
regDate = now();

INSERT INTO article
SET category = "어류",
foodName = "고등어",
brandName = "오늘의바다",
price = 4500,
weight = 100,
`scope` = 5,
review = "소금으로 구우면 밥반찬으로 너무 좋아요.",
writer = "한재현",
regDate = now();

INSERT INTO article
SET category = "어류",
foodName = "문어",
brandName = "오늘의바다",
price = 15000,
weight = 200,
`scope` = 5,
review = "타코야끼 만들려고 샀는데 너무 만족합니다.",
writer = "김경호",
regDate = now();

INSERT INTO article
SET category = "탄수화물",
foodName = "오트밀",
brandName = "마이바디",
price = 23000,
weight = 1000,
`scope` = 3,
review = "이렇게 맛없는 오트밀 처음이에요..",
writer = "김경호",
regDate = now();

INSERT INTO article
SET category = "보충제",
foodName = "프로틴스 초코맛",
brandName = "마이프로틴",
price = 45000,
weight = 1000,
`scope` = 5,
review = "역시 보충제는 초코맛이 짱이죠.",
writer = "한재현",
regDate = now();

#테이블 조회
SELECT *
FROM `member`;
SELECT *
FROM article;

#테이블 구조 조회
DESC `member`;
DESC article;



