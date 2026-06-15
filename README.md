# UAS Kualitas Perangkat Lunak - Appium Automation Testing

Repositori ini berisi *Project Automation Testing* yang dikembangkan sebagai pemenuhan tugas Ujian Akhir Semester (UAS) mata kuliah **Kualitas Perangkat Lunak**. Proyek ini menggunakan **Appium** dan **Java** untuk menguji antarmuka aplikasi *mobile* secara otomatis.

## 📱 Tentang Aplikasi yang Diuji
Aplikasi yang digunakan sebagai target pengujian adalah **SauceLabs My Demo App (React Native version)**. Ini adalah aplikasi *e-commerce* tiruan standar industri yang sering digunakan oleh QA Engineer untuk berlatih dan mengimplementasikan *script automation*. 
- **File APK:** `app.apk` (Tersedia langsung di dalam root repositori ini).

## 🛠️ Teknologi dan Framework
Proyek ini dibangun menggunakan *stack* teknologi pengujian modern:
- **Bahasa Pemrograman:** Java (JDK 17)
- **Automation Framework:** Appium (UIAutomator2)
- **Dependency Management:** Apache Maven
- **Test Runner & Assertions:** TestNG
- **Locator Strategy:** Accessibility ID & XPath

## 🧪 Skenario Pengujian (Test Case)
**Skenario:** Negative Test - Invalid Login
**Tujuan:** Memastikan sistem menolak autentikasi ketika pengguna memasukkan format/kredensial yang salah dan menampilkan pesan peringatan yang sesuai.
**Langkah-langkah Eksekusi (Steps):**
1. Buka aplikasi SauceLabs My Demo App.
2. Klik ikon *Hamburger Menu* di pojok kiri atas.
3. Pilih menu **Log In**.
4. Masukkan string acak pada form *Username* (misal: `user_salah@mail.com`).
5. Masukkan angka acak pada form *Password* (misal: `123456`).
6. Klik tombol **Login**.
7. **Expected Result (Asersi):** Sistem harus menampilkan pesan error teks *"Provided credentials do not match any user in this service."*.

## 🚀 Cara Menjalankan Project (How to Run)
Bagi evaluator atau siapapun yang ingin menjalankan proyek ini di mesin lokal, silakan ikuti instruksi berikut:

### Prasyarat (Prerequisites)
1. **Node.js** dan **NPM** telah terinstal.
2. Server **Appium** (v2.x atau yang terbaru) berjalan di `http://127.0.0.1:4723`.
3. Driver **UiAutomator2** telah diinstal ke dalam Appium (`appium driver install uiautomator2`).
4. **Android SDK** telah diatur di dalam *Environment Variables* (`ANDROID_HOME`).
5. Emulator Android berjalan, atau HP Fisik terhubung dengan status **USB Debugging** aktif.

### Eksekusi Tes
1. *Clone* repositori ini:
   ```bash
   git clone https://github.com/fariszain/KPL_FARIS.git
   cd KPL_FARIS
   ```
2. Pastikan file `app.apk` berada di *root* direktori.
3. Buka file `src/test/java/UasTest.java` dan sesuaikan parameter berikut (jika diperlukan):
   - `options.setDeviceName("Nama Device Anda")`
   - `options.setUdid("UDID Anda dari perintah adb devices")`
4. Buka terminal dan eksekusi perintah Maven:
   ```bash
   mvn clean test
   ```
5. Tunggu proses instalasi dan otomasi berjalan di perangkat Anda hingga terminal mengeluarkan status **BUILD SUCCESS**.

---
*Dibuat oleh Faris Zain untuk UAS KPL 2026.*
