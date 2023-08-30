create database library;
create table kategoriler (
	kategori_id SERIAL primary KEY,
	kategori_adi varchar(50)
);
create table uyeler (
	uye_id SERIAL primary key,
	uye_adi varchar(50),
	uye_soyadi varchar(50),
	uye_dogum_tarihi date,
	adres text,
	eposta varchar(50),
	kayit_tarihi date
);

create table yazarlar(
	yazar_id SERIAL primary key,
	yazar_adi VARCHAR(50),
	yazar_soyadi VARCHAR(50),
	yazar_dogum_tarihi DATE,
	ulus VARCHAR(50)
);
select* from yazarlar;

create table kitaplar(
	kitap_id serial primary key,
	kitap_adi varchar(200),
	yazar_id int references yazarlar(yazar_id),
	yayinlanma_yili int,
	isbn varchar(20),
	kategori_id int references kategoriler(kategori_id),
	erisilebilirlik_durumu boolean
)
insert into uyeler 
(uye_adi, uye_soyadi, adres, eposta, uye_dogum_tarihi, kayit_tarihi) 
values ('Tammie', 'Howen', 'Suite 6', 'thowen1@theguardian.com', '9/12/1998', '8/21/2022'),
('Vale', 'Liggins', 'Room 17', 'vliggins2@patch.com', '9/7/1996', '8/13/2022'),
('Nickey', 'Tomich', '1st Floor', 'ntomich3@xrea.com', '10/31/1998', '7/29/2022'),
('Corinna', 'Peddar', 'PO Box 4734', 'cpeddar4@fda.gov', '8/29/2004', '7/6/2023'),
('Woodman', 'Upex', 'Apt 223', 'wupex5@shutterfly.com', '1/24/2004', '8/9/2023'),
('Ruthe', 'Owain', '4th Floor', 'rowain6@jimdo.com', '1/24/1997', '3/8/2023'),
('Howard', 'Olekhov', '16th Floor', 'holekhov7@ezinearticles.com', '2/8/2011', '3/17/2023'),
('Melisse', 'Ralfe', 'Apt 945', 'mralfe8@businessweek.com', '2/28/2005', '2/13/2022'),
('Milissent', 'Brabender', 'PO Box 82097', 'mbrabender9@dell.com', '12/4/1999', '10/15/2022'),
('Artemus', 'Adds', 'PO Box 85771', 'aaddsa@dion.ne.jp', '4/13/1990', '4/2/2023');

insert into yazarlar
(yazar_adi, yazar_soyadi, yazar_dogum_tarihi, ulus) values 
('Arlie', 'Voce', '07/13/2003', 'Greece'),
('Gabby', 'Davidove', '05/28/1996', 'Philippines'),
('Ferdinande', 'Whitnall', '03/29/2015', 'Russia'),
('Oriana', 'Cantor', '08/01/2018', 'France'),
('Emanuele', 'Manners', '06/07/1980', 'Syria'),
('Elset', 'Beauchop', '08/01/1977', 'Portugal'),
('Odie', 'Alenikov', '08/30/1984', 'Portugal'),
('Babbette', 'Shelmerdine', '02/17/2017', 'Turks and Caicos Islands'),
('Lief', 'Gulberg', '07/04/1993', 'Indonesia'),
('Jody', 'Delgadillo', '06/07/1993', 'China')
show datestyle
select *from uyeler