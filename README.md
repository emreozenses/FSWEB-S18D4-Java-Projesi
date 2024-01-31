# FSWEB-S18D4-Java-Projesi
 Hibernate Advance Mappings
 Hedeflerimiz:

 Banking Rest Api

 Başlangıç

 Spring Initializr kullanarak bir Spring Boot projesi oluşturun.
 
İçerisinde Spring Web dependency eklenmeli.

 Maven dependency management sistemini kullanarak tüm dependencyleri install edin.

 Uygulamanızı 8080 portundan ayağa kaldırın.

 Bir banka uygulaması için rest api dizayn etmeniz istenmektedir.

 Görev 1

 Veri tabanı dizaynınız şu şekilde olmalı. Toplam 3 tablo yazmanız gerekmektedir.

 address tablosu => (id, street, no, city, country, description) kolonlarından oluşmalı.

 id primary_key olarak işaretlenmeli.
 
description alanı optional set edilmeli
 
customer tablosu => (id, first_name, last_name, email, salary, address_id) bilgilerini içermeli.


 Her Customer sadece bir tane adrese sahip olabilir.

 Herhangi bir customer ilgili tablodan silinirse Customer'a ait olan address bilgisi de veri tabanından silinmelidir.

 Herhangi bir adress bilgisi veri tabanından silinirse ilgili dataya sahip olan customer objesi veri tabanından silinmemelidir.

 account tablosu (id, account_name, money_amount, customer_id) kolonlarından oluşmalı.

 id primary_key olarak işaretlenmeli.

 Bir Customer'in birden çok Account'u olabilir.

 Görev 2
 
controller, service, dao, entity, isminde 4 adet daha paket oluşturunuz.

 entity paketinin altına Address, Customer, Account isimli üç tane sınıf oluşturunuz.

 Address, Customer ve Account sınıfları project lombok annotationlarını kullanarak oluşturulmalılar.

 Address ve Customer sınıflarının birbirleri arasındaki ilişkiyi tanımlayan annotationları kullanın.(One-to-One)

 Customer ve Account sınıflarının birbirleri arasındaki ilişkiyi tanımlayan annotationları kullanın.(One-to-Many)

 Görev 3

 AddressController, CustomerController, AccountController isimli 3 tane controller yazmalısınız.

Amacımız CRUD işlemlerini tanımlayan endpointler yazmak.

[GET]/workintech/address => veri tabanaında kayıtlı tüm address bilgilerini döner.

[GET]/workintech/address/{id} => İlgili id deki address objesini döner.

[POST]/workintech/address => Bir adet address objesini veri tabanına ekler.

[PUT]/workintech/address/{id} => İlgili id deki address objesinin değerlerini günceller.

[DELETE]/workintech/address/{id} => İlgili id değerindeki address objesini siler.

[GET]/workintech/customers => veri tabanında kayıtlı tüm customer bilgilerini döner.

[GET]/workintech/customers/{id} => İlgili id deki customer objesini dönmeli.

[POST]/workintech/customers => Bir adet customer objesini veri tabanına ekler

[PUT]/workintech/customers/{id} => İlgili id deki customer objesinin değerlerini günceller.

[DELETE]/workintech/customers/{id} => İlgili id değerindeki customer objesini siler.

[GET]/workintech/accounts => veri tabanında kayıtlı tüm account bilgilerini döner.

[GET]/workintech/accounts/{id} => İlgili id deki account objesini dönmeli.

[POST]/workintech/accounts/{customerId} => Parametre olarak gelen id ile ilgili customeri bulur ve Account objesini Customer ile ilişkilendirip veri tabanına kaydeder.

[PUT]/workintech/accounts/{customerId} =>Parametre olarak gelen id ile ilgili customeri bulur ve Account objesinin yeni bilgilerini güncelleyip Customer ile ilişkilendirip veri tabanına kaydeder.

[DELETE]/workintech/accounts/{id} => İlgili id değerindeki account objesini siler.
