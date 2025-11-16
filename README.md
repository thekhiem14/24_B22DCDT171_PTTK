# 🚀 Hệ thống Quản lý Nhà hàng (PTTK)

Đây là một dự án Java Web được xây dựng nhằm mục đích quản lý các nghiệp vụ cơ bản trong một nhà hàng, bao gồm quản lý món ăn, thống kê doanh thu theo khách hàng, và xem chi tiết đơn hàng/hóa đơn.

Dự án được xây dựng trên nền tảng **Java (Servlet)**, **JSP/JSTL** và cơ sở dữ liệu **MySQL**.

---

## 📸 Tính năng chính

* **Quản lý Món ăn (Dish Management):**
    * Thêm món ăn mới (tên, mô tả, giá, giảm giá).
    * Kiểm tra trùng lặp tên món ăn.
    * (Dự kiến) Xem danh sách, sửa, và xóa món ăn.
* **Thống kê (Statistics):**
    * Xem thống kê doanh thu của tất cả khách hàng trong một khoảng thời gian (Start Date, End Date).
    * Phân trang danh sách khách hàng (5 người/trang).
* **Quản lý Hóa đơn (Expense):**
    * Xem danh sách các hóa đơn (chi tiêu) của một khách hàng cụ thể.
* **Chi tiết Đơn hàng (Order Detail):**
    * Xem chi tiết một đơn hàng, bao gồm các món ăn (Dish) và combo (Combo) đã đặt.

---

## 🛠️ Công nghệ sử dụng

* **Backend:** Java (Servlet)
* **Frontend:** JSP, JSTL (JSP Standard Tag Library), CSS
* **Database:** MySQL (sử dụng JDBC)
* **Web Server:** Apache Tomcat
* **Build Tool:** Apache Maven
* **IDE:** IntelliJ IDEA

---

## 🏃 Cài đặt & Khởi chạy

1.  **Clone Repository:**
    ```bash
    git clone [https://github.com/thekhiem14/RestaurantManagement_PTTK.git](https://github.com/thekhiem14/RestaurantManagement_PTTK.git)
    cd RestaurantManagement_PTTK
    ```

2.  **Cơ sở dữ liệu (Database):**
    * Import file `.sql` của bạn (chứa các bảng `tblDish`, `tblOrder`, `tblInvoice`...) vào MySQL server.
    * Mở file `src/main/resources/database.properties`.
    * Cập nhật `URL`, `USER`, và `PASSWORD` để trỏ đến CSDL MySQL của bạn.

3.  **Build Dự án (Dùng Maven):**
    * Mở project bằng IntelliJ IDEA, chờ Maven tải các thư viện (dependencies).
    * Hoặc chạy lệnh:
    ```bash
    mvn clean install
    ```

4.  **Triển khai (Deploy):**
    * Cấu hình Apache Tomcat trong IntelliJ.
    * Deploy artifact (file `.war`) lên server Tomcat.

5.  **Chạy ứng dụng:**
    * Khởi động server Tomcat.
    * Truy cập vào trang chủ, ví dụ: `http://localhost:8080/pttk/` (tùy vào bối cảnh bạn deploy).

---

## 📂 Cấu trúc Thư mục

Đây là cấu trúc thư mục chuẩn của project (đã được đơn giản hóa):
RestaurantManagement_PTTK/<br>
├── src/<br>
│   └── main/<br>
│       ├── java/<br>
│       │   └── com/<br>
│       │       └── pttk/<br>
│       │           ├── dao/<br>
│       │           │   ├── CustomerStatDAO.java<br>
│       │           │   ├── DAO.java<br>
│       │           │   ├── DishDAO.java<br>
│       │           │   ├── InvoiceDAO.java<br>
│       │           │   └── OrderDAO.java<br>
│       │           ├── model/<br>
│       │           │   ├── Dish.java<br>
│       │           │   ├── Order.java<br>
│       │           │   ├── Invoice.java<br>
│       │           │   ├── Customer.java<br>
│       │           │   └── ... (và các model khác)<br>
│       │           └── servlet/<br>
│       │               ├── CustomerServlet.java<br>
│       │               ├── DishServlet.java<br>
│       │               ├── InvoiceServlet.java<br>
│       │               └── OrderServlet.java<br>
│       ├── resources/<br>
│       │   ├── database.properties<br>
│       │   └── log4j.properties<br>
│       └── webapp/<br>
│           ├── assets/<br>
│           │   └── css/<br>
│           │       ├── style.css<br>
│           │       ├── dish.css<br>
│           │       └── ... (các file css khác)<br>
│           ├── view/<br>
│           │   └── management/<br>
│           │       ├── uiAddDish.jsp<br>
│           │       ├── uiCustomerStat.jsp<br>
│           │       ├── uiExpenseDetail.jsp<br>
│           │       ├── uiManagerDish.jsp<br>
│           │       ├── uiManagerHome.jsp<br>
│           │       ├── uiOrderDetail.jsp<br>
│           │       └── uiStatistic.jsp<br>
│           ├── WEB-INF/<br>
│           │   └── web.xml<br>
│           └── index.jsp<br>
├── .gitignore<br>
├── pom.xml<br>
└── README.md<br>