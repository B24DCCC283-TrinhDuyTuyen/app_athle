
import { Link } from 'react-router-dom'
import athleteImage from '../../assets/athlete.jpg'
import './LandingPage.css'

function LandingPage() {
    return (
        <main className="landing-page">
            {/* Navigation */}
            <header className="landing-header">
                <Link to="/" className="landing-logo">
                    <span className="logo-symbol">A</span>
                    <span>ATHLETICS<span className="logo-highlight">.</span></span>
                </Link>

                <nav className="landing-nav">
                    <a href="#home">Trang chủ</a>
                    <a href="#about">Giới thiệu</a>
                    <a href="#features">Tính năng</a>
                    <a href="#contact">Liên hệ</a>
                </nav>

                <div className="landing-actions">
                    <Link to="/login" className="nav-login">
                        Đăng nhập
                    </Link>
                    <Link to="/register" className="nav-register">
                        Đăng ký
                    </Link>
                </div>
            </header>

            {/* Hero */}
            <section className="landing-hero" id="home">
                <div className="hero-content">
                    <div className="hero-label">
                        <span className="label-line" />
                        ATHLETICS MANAGEMENT SYSTEM
                    </div>

                    <h1>
                        PUSH YOUR
                        <br />
                        <span>LIMITS.</span>
                        <br />
                        OWN YOUR
                        <br />
                        <span>VICTORY.</span>
                    </h1>

                    <p className="hero-description">
                        Nền tảng quản lý và phát triển thành tích điền kinh.
                        Kết nối huấn luyện viên và vận động viên trên cùng
                        một hành trình chinh phục giới hạn.
                    </p>

                    <div className="hero-buttons">
                        <Link to="/register" className="hero-primary-button">
                            BẮT ĐẦU NGAY
                            <span>↗</span>
                        </Link>

                        <a href="#about" className="hero-secondary-button">
                            KHÁM PHÁ HỆ THỐNG
                        </a>
                    </div>

                    <div className="hero-stats">
                        <div>
                            <strong>01</strong>
                            <span>MỘT NỀN TẢNG</span>
                        </div>
                        <div>
                            <strong>02</strong>
                            <span>HAI VAI TRÒ</span>
                        </div>
                        <div>
                            <strong>∞</strong>
                            <span>GIỚI HẠN MỚI</span>
                        </div>
                    </div>
                </div>

                <div className="hero-visual">
                    <div className="hero-image-frame">
                        <img src={athleteImage} alt="Vận động viên thi đấu điền kinh" />
                    </div>

                    <div className="hero-image-overlay" />

                    <div className="hero-image-caption">
                        <span>01 / ATHLETICS</span>
                        <strong>BEYOND THE LIMIT</strong>
                    </div>

                    <div className="hero-circle">
                        <span>TRAIN</span>
                        <strong>HARD</strong>
                        <span>WIN</span>
                        <strong>MORE</strong>
                    </div>
                </div>

                <div className="hero-background-text">
                    ATHLETICS
                </div>

                <div className="hero-scroll">
                    <span />
                    SCROLL TO EXPLORE
                </div>
            </section>

            {/* About */}
            <section className="landing-about" id="about">
                <div className="section-label">01 — ABOUT US</div>

                <div className="about-content">
                    <h2>
                        MORE THAN
                        <br />
                        <span>JUST SPORTS.</span>
                    </h2>

                    <p>
                        Athletics Management là nền tảng hỗ trợ quản lý hoạt động
                        điền kinh, kết nối huấn luyện viên với vận động viên,
                        theo dõi quá trình tập luyện và hướng tới những thành tích
                        tốt hơn.
                    </p>
                </div>
            </section>

            {/* Features */}
            <section className="landing-features" id="features">
                <div className="section-label">02 — OUR FEATURES</div>

                <div className="features-heading">
                    <h2>
                        EVERYTHING
                        <br />
                        <span>IN ONE PLACE.</span>
                    </h2>
                    <p>
                        Những công cụ cần thiết để quản lý,
                        huấn luyện và phát triển thành tích.
                    </p>
                </div>

                <div className="features-grid">
                    <article className="feature-card">
                        <span className="feature-number">01</span>
                        <div className="feature-icon">↗</div>
                        <h3>QUẢN LÝ VẬN ĐỘNG VIÊN</h3>
                        <p>
                            Theo dõi thông tin cá nhân, hồ sơ và quá trình
                            phát triển của từng vận động viên.
                        </p>
                    </article>

                    <article className="feature-card">
                        <span className="feature-number">02</span>
                        <div className="feature-icon">◎</div>
                        <h3>KẾT NỐI HUẤN LUYỆN VIÊN</h3>
                        <p>
                            Tạo liên kết giữa huấn luyện viên và vận động viên,
                            quản lý các yêu cầu kết nối.
                        </p>
                    </article>

                    <article className="feature-card">
                        <span className="feature-number">03</span>
                        <div className="feature-icon">⌁</div>
                        <h3>THEO DÕI THÀNH TÍCH</h3>
                        <p>
                            Hướng tới việc lưu trữ, theo dõi và đánh giá
                            kết quả thi đấu của vận động viên.
                        </p>
                    </article>
                </div>
            </section>

            {/* Contact */}
            <section className="landing-contact" id="contact">
                <div className="section-label">03 — YOUR JOURNEY STARTS HERE</div>

                <h2>
                    READY TO
                    <br />
                    <span>GO FASTER?</span>
                </h2>

                <Link to="/register" className="hero-primary-button">
                    THAM GIA NGAY
                    <span>↗</span>
                </Link>
            </section>

            {/* Footer */}
            <footer className="landing-footer">
                <Link to="/" className="landing-logo">
                    <span className="logo-symbol">A</span>
                    <span>ATHLETICS<span className="logo-highlight">.</span></span>
                </Link>

                <p>ATHLETICS MANAGEMENT SYSTEM</p>

                <span>© 2026 ATHLETICS MANAGEMENT</span>
            </footer>
        </main>
    )
}

export default LandingPage
