import React from 'react'

const Footer = () => {
  return (
    <footer className="footer">
        <div className="container">
            <div className="row">
                <div className="col-md-12">
                    <div className="footer-manu">
                        <ul>
                            <li><a href="about.html">About Us</a></li>
                            <li><a href="contact.html">Contact us</a></li>
                            <li><a href="service.html">How it works</a></li>
                            <li><a href="faq.html">FAQ</a></li>
                            <li><a href="pricing.html">Pricing</a></li>
                        </ul>
                    </div>
                    <p className="copyright mb-0">Copyright <script>document.write(new Date().getFullYear())</script> &copy; Designed & Developed by <a
                            href="#">Quoc Tuan</a>. All rights reserved.
                    </p>
                </div>
            </div>
        </div>
    </footer>
  )
}

export default Footer