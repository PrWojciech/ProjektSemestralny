import React from 'react';

function Banner() {
    return (
        <div className="banner">
            <div className="container">
                <div>
                    <img src="/img/quality.png" alt="Code Heroes Logo"/>
                    <h3>Najwyższa jakość kursów</h3>
                </div>
                <div>
                    <img src="/img/experience.png" alt="Code Heroes Logo"/>
                    <h3>Specjalistyczna wiedza <br/>
                        potwierdzona doświadczeniem</h3>
                </div>
                <div>
                    <img src="/img/customer.png" alt="Code Heroes Logo"/>
                    <h3>Doskonała jakość obsługi</h3>
                </div>
            </div>
        </div>
    );
}

export default Banner;
