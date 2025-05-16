 Proyek Automated Test - Sauce Demo (https://www.saucedemo.com/)

## Tujuan Proyek

Proyek ini merupakan automated test untuk web Sauce Demo (https://www.saucedemo.com/) menggunakan Selenium WebDriver dan Cucumber. 
Pengujian ini ditulis dalam Gherkin.

Tujuannya untuk menguji fungsionalitas login dan filter produk berdasarkan harga terendah ke tertinggi ( Price low to high) dalam web Sauce Demo.

## Fitur yang Dites

* Login:
    * Valid Login
      Berhasil Login dengan username ("standard_user") dan password ("secret_sauce") yang valid.
    * Invalid Login 
      Gagal Login dengan username ("user") dan password ("123") tidak valid dengan notifikasi pesan eror login ("Epic sadface: Username and password do not match any user in this service").
* Homepage: 
    * Filter produk 
      Filter produk berdasarkan harga terendah ke tertinggi (Price low to high).
    * Boundary Test
      Verifikasi bahwa harga produk pertama adalah yang terendah setelah pengurutan.
      Verifikasi bahwa harga produk terakhir adalah yang tertinggi setelah pengurutan.
    * Negatif Test
      Verifikasi bahwa produk tidak diurutkan dengan benar.
      
## Prasyarat

Sebelum melakukan automated test, pastikan Anda telah menginstal perangkat lunak berikut:

* **Java Development Kit (JDK):** Proyek ini menggunakan JDK 23.0.2
* **Maven:** Alat otomatisasi build.
* **ChromeDriver:** Pastikan versi ChromeDriver kompatibel dengan browser Chrome Anda.
* **Cucumber untuk Java:** Dependensi Maven.
* **Selenium WebDriver:** Dependensi Maven.
* **Gradle** versi 8.10
* **Browser web:** Google Chrome (versi 136.0.7103.114)

## Pengujian
* Clone Repository dari Github (Menggunakan Bash Code):
  git clone https://github.com/junnhoo/MODUL21PR19.git
  cd MODUL21PR19
* Downlaod Dependencies
  ./gradlew build
* Run the test
  ./gradlew test
  

