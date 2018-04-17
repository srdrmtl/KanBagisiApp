# KAN BAĞIŞI UYGULAMASI

![N|Solid](https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/20110510-jsf-logo.tiff/lossless-page1-1200px-20110510-jsf-logo.tiff.png)
![N|Solid](http://www.eclipse.org/eclipselink/images/logo.png)

JSF,JPA,MAVEN teknolojileri kullanılarak yapılmış olan kan bağışı uygulamasındaki bazı özellikler

  - Şehirlere ve kan gruplarına göre arama yapabilme.
  - Kayıt olup bağışçı olarak aramalarda gözükme.
  - Kayıt silme özelliği ile aramalardan çıkma.
  - Şifremi unuttum özelliği ile mail ile şifre aktivasyonu
 
### Teknolojiler

Bu uygulamada kullanılan teknolojiler ile ilgili daha ayrıntılı bilgi almak için:

* [JSF 2.2](http://www.oracle.com/technetwork/java/javaee/documentation/index-137726.html) 
* [EclipseLink JPA](http://www.eclipse.org/eclipselink/) 
* [PrimeFaces](https://www.primefaces.org/) 
* [GlassFish Server 4.0](https://javaee.github.io/glassfish/) 




### Kurulum

Kuruluma geçmeden şunların kurulu olduğundan emin olun!
* [Java Jdk 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [GlassFish Server 4.0](https://javaee.github.io/glassfish/)
* Veritabanı olarak kullanacağımız bir Server(Mysql kullanıldı)
* [Başlangıçta zorlananlar için kolay bir türkçe kaynak](http://ilkaygunel.com/blog/2016/jsfye-giris/)
* Not : Netbeans IDE 8.2'de geliştirilmiştir.


1. Proje dosyalarını kendi bilgisayarımıza yüklüyoruz.

```sh
$ git clone https://github.com/srdrmtl/KanBagisiApp.git
```

2. Netbeans'i açıp "open project" diyerek projemizi NetBeans'e ekliyoruz.

3. Localhosta bağlanıp veritabanımızı oluşturuyoruz
```sh
$ localhost/phpmyadmin
$ Oluşturmamız gereken veritabanı ismi "calisma" 
```

4. Veritabanımızı oluşturduktan sonra "içeri aktar" seçeneği ile 
```sh
$ calisma.sql
```
dosyasını seçip içeri aktarıyoruz. Tablolarımız artık oluştu.


5. (NetBeans İçin ) Netbeans açıldıktan sonra sol tarafta services sekmesine tıklayıp Databases'e sağ tıklıyoruz.



5.1. (NetBeans İçin) "New Connection" Tıklıyoruz.Driver olarak MySQL(Connector/JDriver) seçip next diyoruz.



5.2. (NetBeans İçin) Açılan ekranda Database kısmına "calisma" yazıyoruz. Diğer bilgileride doldurup Next-Next-Finish yapıyoruz.




6. Aşağıda gördüğünüz gibi src->main->resource->persistence.xml dosyasını açıp gerekli değişikleri yapıyoruz.


![N|Solid](http://resimag.com/p1/c30b9af64b.png)


```sh
$ <properties>
$       <property name="jdbc urlnizi gireceksiniz"/>
$       <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
$       <property name="javax.persistence.jdbc.user" value="localhost kullanıcı adınız"/>
$       <property name="javax.persistence.jdbc.password" value="localhost şifreniz"/>
$</properties>
```
7. Yukardaki değişiklikleri yaptıktan sonra persistence.xml Design kısmına girip "Data Source: oluşturduğumuz JDBC Server"  seçmeyi unutmayınız.

8. Mail sunucusu ile ilgili bilgileri SendMail() fonksiyonu altından doldurabilirsiniz.

9. Yukardaki işlemleri sorunsuz yaptığınız zaman uygulamamız çalışacaktır.

10. Veritabanında kayıtlı kullanıcı bilgileri---> mail : serdarmutlu006@gmail.com şifre:1234
## Uygulamadan Bazı Görüntüler
*Ana Ekran
![N|Solid](http://resimag.com/p1/0e31d13238.png)
* Giriş Ekranı
![N|Solid](http://resimag.com/p1/7b2916de29.png)
*Şifremi Unuttum Ekranı
![N|Solid](http://resimag.com/p1/817c22fd41.png)
* Kayıt Ekranı
![N|Solid](http://resimag.com/p1/8945cd83dc.png)
*Kullanıcı Paneli Ekranı
![N|Solid](http://resimag.com/p1/22c9573566.png)
*Arama Sonrası Gösterilen Ekran
![N|Solid](http://resimag.com/p1/db2485db56.png)



