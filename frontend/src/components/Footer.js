import React from 'react';

function Footer() {
    return (
        <div className="Footer">
            <div className="footer-widget flow-small">
                <h2>Newsletter</h2>
                <div>
                    <input
                        className="newsletter-input-field"
                        type="text"
                        placeholder="E-mail"
                    />
                    <div className="Buttons special">Zapisz się</div>
                </div>
            </div>

            <div className="footer-widget flow-small">
                <h2>Kursy</h2>
                <p><a>Unity</a></p>
                <p><a>Roblox</a></p>
            </div>

            <div className="footer-widget flow-small">
            <h2>Nawigacja</h2>
                <p><a src="#">Kursy</a></p>
                <p><a>Kontakt</a></p>
                <p><a>Forum</a></p>
                <p><a>Pomoc</a></p>
            </div>

            <div className="footer-widget flow-small">
                <h2>Kontakt</h2>
                <p><a>Tel: 123-123-123</a></p>
                <p><a>E-mail: email@email.com</a></p>
            </div>
        </div>
    );
}

export default Footer;
