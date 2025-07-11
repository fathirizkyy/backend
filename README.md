# Spring Boot CRUD API - Item

Proyek ini adalah RESTful CRUD API untuk mengelola data **Item**, dibangun menggunakan **Spring Boot**, **Spring Data JPA**, **Lombok**, dan **MySQL**. Aplikasi ini juga memiliki **Custom Exception Handling** dan **Global Exception Handler** untuk memberikan response error yang konsisten dan informatif.

## 🔧 Teknologi yang Digunakan

- Java 17+
- Spring Boot
- Spring Data JPA
- Lombok
- MySQL Driver
- Maven

## 📦 Fitur Utama

### ✅ CRUD Endpoint untuk Item

| Metode | Endpoint     | Deskripsi                                     |
| ------ | ------------ | --------------------------------------------- |
| GET    | `/items`     | Ambil semua item (dapat ditambahkan paginasi) |
| GET    | `/items/:id` | Ambil detail item berdasarkan ID              |
| POST   | `/items`     | Tambah item baru                              |
| PATCH  | `/items/:id` | Perbarui data item berdasarkan ID             |
| DELETE | `/items/:id` | Hapus item berdasarkan ID                     |

### ⚠️ Custom Exception

- `DataNotFoundException`  
  Dilempar saat item dengan ID tertentu tidak ditemukan.

- `EmptyDatabaseException`  
  Dilempar saat tidak ada data item di database.

### 🛡️ Global Exception Handler

Semua exception ditangani secara global menggunakan `@ControllerAdvice`, sehingga response error menjadi seragam dan lebih mudah dibaca oleh client/frontend.

### 📂 Response Payload

Terdapat dua class di dalam folder `payload`:

- `ApiResponse<T>`  
  Digunakan untuk response sukses, menyertakan status, pesan, dan data.

- `ApiErrorResponse`  
  Digunakan untuk response gagal, menyertakan status, pesan error, dan detail kesalahan dalam bentuk map.

## 🚀 Cara Menjalankan

1. **Clone repository**

   ```bash
   git clone https://github.com/username/nama-repo.git
   cd nama-repo
   ```

2. **Atur konfigurasi database di application.properties**

   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/namadb
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Jalankan aplikasi**
   ```bash
   ./mvnw spring-boot:run
   ```

## 📬 Contoh Response

**Response Berhasil**

```bash
{
"success": true,
"message": "Item berhasil ditemukan",
"data": {
"id": 1,
"name": "Contoh Item",
"price": 5000
}
}
```

**Response Gagal**

```bash
{
"success": false,
"message": "Validasi gagal",
"errors": {
"name": "Nama item tidak boleh kosong"
}
}
```

## 👤 Author

Nama: Nanda F Rizky
GitHub: [fathirizkyy](https://github.com/fathirizkyy)  
Email: nandafathirizky@gmail.com
