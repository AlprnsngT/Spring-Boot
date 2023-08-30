select * from kitaplar k where k.kategori_id = 1
select isbn from kitaplar k2 where k2.kitap_adi ='antika'

select * from kitaplar k where k.kitap_adi = 'Antika';

select yazar_id,kitap_adi from kitaplar k where k.kitap_adi = 'Antika';


--GRUPLAMA 
select k3.yazar_id, count(*)
from kitaplar k3 
group by k3.yazar_id ;

select k3.yazar_id, count(*) as "kitap sayısı" 
from kitaplar k3 
group by k3.yazar_id ;

/* 
 * select * from kitaplar k3 group by k3.yazar_id ;
 * bu hatalı bir sorgudur sebebi ise gruplandırdığımız bu verileri bir columns olacak şekilde yazdırmalı
 * veya bu sorgu sonucunda istenen veriyi selec-from arasına yazılmalı
 */

-- Sıralama
select k3.yazar_id, k3.kategori_id, count(*) 
from kitaplar k3 
group by k3.yazar_id ,k3.kategori_id 
order by yazar_id desc ;


--								 Joins
-- Inner join
select kitap.kitap_adi ,kategori.kategori_adi
-- kategoriler tablosunu kategori diye kısaltıyorum
from kategoriler kategori
-- kesişimlerini alalım
inner join kitaplar kitap
-- neye göre kesişim alıyoruz
on kategori.kategori_id = kitap.kitap_id;

select kategori.kategori_adi , kitap.kitap_adi
from kategoriler kategori
inner join kitaplar kitap
on kategori.kategori_id = kitap.kitap_id;

select kategori.kategori_adi , kitap.kitap_adi
from kategoriler kategori
inner join kitaplar kitap
on kategori.kategori_id = kitap.kitap_id;

-- Left 
select kategori.kategori_adi , kitap.kitap_adi
from kategoriler kategori
left join kitaplar kitap
on kategori.kategori_id = kitap.kitap_id;

-- Right
select kategori.kategori_adi , kitap.kitap_adi
from kategoriler kategori
Right join kitaplar kitap
on kategori.kategori_id = kitap.kitap_id;

-- Full
select kategori.kategori_adi ,kitap.kitap_adi
from kitaplar kitap
full join kategoriler kategori
on kategori.kategori_id = kitap.kitap_id;

select k.kitap_adi , k.yazar_id from kitaplar k order by k.kitap_adi asc;

select k.yayinlanma_yili , count(*) as "Toplam_kitap_sayısı" from kitaplar k group by k.yayinlanma_yili;

select count(k.yayinlanma_yili) from kitaplar k 

select k.kitap_id , k.yayinlanma_yili, count(k.kategori_id)
from kitaplar k 
group by k.yayinlanma_yili , k.kitap_id;

create table oduncler(
odunc_id serial primary key,
kitap_id int references kitaplar(kitap_id),
uye_id int references uyeler(uye_id),
odunc_verme_tarihi date,
geri_alma_tarihi date
)

insert into oduncler(kitap_id,uye_id,odunc_verme_tarihi,geri_alma_tarihi) values (1,1,'01/01/2020','01/02/2022');
insert into oduncler(kitap_id,uye_id,odunc_verme_tarihi,geri_alma_tarihi) values (8,4,'11/11/2020','11/12/2022');
insert into oduncler(kitap_id,uye_id,odunc_verme_tarihi,geri_alma_tarihi) values (3,1,'11/21/2020','12/21/2022');

select kitap_adi , uye_adi ,odunc_verme_tarihi ,geri_alma_tarihi
from kitaplar
inner join oduncler on kitaplar.kitap_id = oduncler.kitap_id 
inner join uyeler on uyeler.uye_id = oduncler.uye_id ;

select k.kitap_id as "kitaplardaki kitap id",o.kitap_id  as "odunclerdeki kitap_id" from oduncler o 
full join kitaplar k on o.kitap_id = k.kitap_id
full join uyeler u on u.uye_id = o.uye_id;

select k.kitap_id as "kitaplardaki kitap id" from oduncler o 
full join kitaplar k on o.kitap_id = k.kitap_id
full join uyeler u on u.uye_id = o.uye_id;

select k.kitap_id as "kitaplardaki_id"
from kitaplar k 
left join oduncler o on k.kitap_id = o.kitap_id
right join kitaplar k2 on o.kitap_id = k2.kitap_id;


show datestyle