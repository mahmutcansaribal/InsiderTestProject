#### PROJE SON TEST KOŞUM TARİHİ

- 25.002.2025 (PASS)

- Proje Java 21 ile geliştirilmiştir.
- Proje bağımlılık yönetimi için Maven kullanmaktadır.
- Projeyi açıktan sonra Maven bağımlılıklarını yükleyiniz.

## Proje Açıklaması

Bu proje, Insider platformunda kullanıcı akışlarını test etmek ve doğrulamak amacıyla geliştirilmiş bir otomasyon test paketidir.
Test senaryoları, Insider web sitesinin kariyer sayfasındaki iş ilanlarını ve yönlendirmeleri test etmek için geliştirilmiş bir otomasyon test paketidir. Test senaryoları, ana sayfanın açılması, kariyer sayfasına erişim, iş ilanlarının lokasyon ve departmana göre filtrelenmesi ve ilan detay sayfasına yönlendirme işlemlerini kapsamaktadır. Proje, sayfa doğrulamalarını ve filtreleme işlevselliğini test ederek kullanıcı deneyiminin tutarlılığını sağlamayı amaçlamaktadır.
Proje, **Java**, **Selenium**, **TestNG**, **Allure Report** gibi teknolojilerle desteklenmiş ve **Page Object Model** tasarım deseni kullanılarak geliştirilmiştir.

---
- **İşletim Sistemi** : Windows 11 64-bit
- **Tarayıcı** : Google Chrome Version 131.0.6778.87
- **Java Version** : OpenJDK 21
- **IDE** : IntelliJ IDEA Community Edition 2024.3
---
- **İşlemci** : Intel Core i5 9300H
- **RAM** : 16GB
- **Monitör** : 2560x1440 
---
## Kullanılan Teknolojiler ve Araçlar

- **Programlama Dili** : Java
- **JAVA JDK** : 21
- **Test Framework** : TestNG 7.10.2
- **Otomasyon Tool** : Selenium WebDriver
- **Raporlama Tool** : Allure Report 2.29.0
- **Build Tool** : Maven

## Test Senaryoları aşağıdaki adımları kapsar

### Ana Sayfa Kontrolü:

- Insider Ana Sayfası açılır ve sayfanın düzgün yüklendiği doğrulanır.

---
### Kariyer Sayfası Kontrolü:

- Navigasyon çubuğundaki “Company” menüsü seçilir.
- Açılan menüden “Careers” seçilir ve yönlendirme doğrulanır.
- Kariyer sayfasında Locations, Teams ve Life at Insider bölümlerinin görüntülendiği doğrulanır.

---
### İş İlanları Filtreleme ve Doğrulama:

- Quality Assurance Kariyer Sayfası açılır.
- “See all QA jobs” butonuna tıklanır ve iş ilanları sayfasına geçiş doğrulanır.
- İş ilanları Lokasyon: İstanbul, Türkiye  
- Departman: Quality Assurance kriterleriyle filtrelenir. 
#### Listelenen tüm iş ilanlarının:
- Pozisyon başlığında “Quality Assurance” kelimesini içerdiği,
- Departman bilgisinin “Quality Assurance” olduğu,
- Lokasyon bilgisinin “Istanbul, Turkey” olduğu doğrulanır.

### Başvuru Sayfası Yönlendirme Kontrolü:

- Her bir ilan için "View Role" butonuna tıklanır.
- Kullanıcının Lever Application Form sayfasına yönlendirildiği kontrol edilir.

---

![CartTestAllureReport](https://github.com/mahmutcansaribal/InsiderTestProject/blob/main/assets/img.png?raw=true)