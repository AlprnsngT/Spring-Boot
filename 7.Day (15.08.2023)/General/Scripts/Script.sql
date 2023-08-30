/*COPY kitaplar 
 * FROM 'C:/Users/Administrator/Desktop/Btk-Innova-Spring Boot/7.Day (15.08.2023)/bulk.txt' 
 * WITH (FORMAT text, DELIMITER '-', HEADER true)
 * */

insert into 
kitaplar (kitap_adi,kitap_id) 
values
('alperen',19),
('kucuk prens',5),
('küçük prens',1)
