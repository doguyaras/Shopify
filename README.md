Proje Adı: Shopify

Amaç:
Bu proje, bir e-ticaret platformu için temel CRUD (Create, Read, Update, Delete) işlemlerini gerçekleştiren bir Spring Boot uygulamasıdır.

Kullanılan Teknolojiler:
- Spring Boot
- Spring Data JPA
- H2 Database

Proje Yapısı:
1. Base Entity: Product, Customer, Cart ve Order gibi temel varlık sınıflarının ortak özelliklerini içeren bir base entity sınıfı bulunmaktadır.Bu sınıf, veritabanındaki tabloların miras alacağı temel yapıyı sağlar.
2. Product: Ürünlerin temel bilgilerini içeren sınıftır. Ürün adı, fiyatı, stok miktarı gibi bilgileri içerir.
3. Customer: Müşterilerin temel bilgilerini içeren sınıftır. Müşteri adı,e-posta gibi bilgileri içerir.
4. Cart: Müşterilerin sepetlerini temsil eder. Her müşteriye ait bir sepet bulunabilir. Sepetin içerisindeki ürünler ve miktarları burada tutulur. Sepetin toplam fiyatı her işlemde güncellenir.
5. Order: Müşterilerin geçmiş siparişlerini temsil eder

Servisler:
- getAllCustomers - Bütün müşterileri getirir.
- addCustomer - Yeni bir müşteri ekler.
- getAllProducts - Bütün ürünleri getirir.
- findById - Belirli bir ürünü getirir.
- addProduct - Yeni bir ürün ekler
- deleteProduct - Belirli bir ürünü siler.
- updateProduct - Belirli bir ürünü günceller.
- addCart - Sepete yeni bir ürün ekler.
- removeCart - Sepeti temizler.
- cartResponse - Sepet içerisindeki ürün ve müşteri bilgisini getirir.
