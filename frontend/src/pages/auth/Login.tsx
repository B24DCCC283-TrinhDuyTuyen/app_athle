import './Login.css'
function Login() {
    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault()

        // Sẽ kết nối API đăng nhập Spring Boot ở bước sau.
    }

    return (
        <main className="login-page">
            <section className="login-content">
                <div className="login-intro">
                    <span className="login-label">ATHLETICS MANAGEMENT</span>

                    <h1>
                        BUILD YOUR
                        <br />
                        <span>LIMITS.</span>
                    </h1>

                    <p>
                        Nền tảng quản lý và phát triển thành tích
                        điền kinh dành cho huấn luyện viên và vận động viên.
                    </p>

                    <div className="login-tags">
                        <span>TRAINING</span>
                        <span>PERFORMANCE</span>
                        <span>ATHLETICS</span>
                    </div>
                </div>

                <div className="login-form-wrapper">
                    <h2>Đăng nhập</h2>
                    <p>Chào mừng bạn quay trở lại!</p>

                    <form onSubmit={handleSubmit}>
                        <div className="form-group">
                            <label htmlFor="username">Tên đăng nhập</label>
                            <input
                                id="username"
                                name="username"
                                type="text"
                                placeholder="Nhập tên đăng nhập"
                                autoComplete="username"
                                required
                            />
                        </div>

                        <div className="form-group">
                            <label htmlFor="password">Mật khẩu</label>
                            <input
                                id="password"
                                name="password"
                                type="password"
                                placeholder="Nhập mật khẩu"
                                autoComplete="current-password"
                                required
                            />
                        </div>

                        <button type="submit" className="login-button">
                            ĐĂNG NHẬP
                        </button>
                    </form>

                    <p className="register-link">
                        Chưa có tài khoản? <a href="/register">Đăng ký ngay</a>
                    </p>
                </div>
            </section>
        </main>
    )
}

export default Login
