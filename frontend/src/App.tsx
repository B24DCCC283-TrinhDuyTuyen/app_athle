
import { BrowserRouter, Routes, Route } from 'react-router-dom'

import LandingPage from './pages/home/LandingPage'
import Login from './pages/auth/Login'

function RegisterPlaceholder() {
  return (
    <div style={{ color: 'white', background: '#101820', minHeight: '100vh', padding: '40px' }}>
      <h1>Đăng ký tài khoản</h1>
      <p>Trang đăng ký đang được phát triển.</p>
    </div>
  )
}

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<RegisterPlaceholder />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
