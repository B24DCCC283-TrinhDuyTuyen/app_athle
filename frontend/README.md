
# Athletics Management

Frontend của hệ thống quản lý điền kinh, được xây dựng bằng React, TypeScript và Vite.

## Công nghệ sử dụng

- React 19
- TypeScript
- Vite
- React Router
- CSS

## Yêu cầu môi trường

- Node.js
- npm

## Cài đặt và chạy dự án

Di chuyển vào thư mục frontend:

```bash
cd frontend
```

Cài đặt các dependencies:

```bash
npm install
```

Chạy ứng dụng ở chế độ development:

```bash
npm run dev
```

Mặc định, Vite chạy ứng dụng tại:

```text
http://localhost:5173
```

## Các lệnh thường dùng

| Lệnh | Chức năng |
|---|---|
| `npm run dev` | Chạy môi trường development |
| `npm run build` | Kiểm tra TypeScript và build production |
| `npm run lint` | Kiểm tra lỗi ESLint |
| `npm run preview` | Xem thử bản build production |

## Cấu trúc thư mục

```text
frontend/
├── public/
├── src/
│   ├── assets/
│   ├── pages/
│   │   ├── auth/
│   │   └── home/
│   ├── App.tsx
│   ├── index.css
│   └── main.tsx
├── index.html
├── package.json
├── package-lock.json
└── vite.config.ts
```

## Chức năng giao diện hiện tại

- Trang chủ giới thiệu hệ thống quản lý điền kinh.
- Trang đăng nhập.
- Điều hướng giữa các trang bằng React Router.
- Giao diện responsive cho máy tính và thiết bị di động.

## Build production

Chạy lệnh:

```bash
npm run build
```

Các tệp production được tạo trong thư mục `dist/`.
