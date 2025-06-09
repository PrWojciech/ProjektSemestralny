import React from 'react';

function Hero() {
    return (
        <div className="container">
            <div className="container-text flow">
                <h1>
                    Zadbaj o przyszłość swoich dzieci!
                </h1>
                <p>
                    Kursy stworzone przez specialistów z branży, <br/>
                    idealnie dostosowane do wieku i umiejętności Twojego dziecka
                </p>
                <div>
                    <div className="Buttons special">Sprawdź więcej</div>
                </div>
            </div>

            <div className="container-img">
            <img src="/img/hero.png" alt="Code Heroes Logo"/>
            </div>
        </div>
    );
}

export default Hero;
