import React from 'react';

function OurVision() {
    return (
        <div className="container">
            <div className="container-img">
                <img src="/img/hero_2.png" alt="Code Heroes Logo"/>
            </div>

            <div className="container-text flow">
                <h2>
                    Witaj w Krainie Nauki i Zabawy!
                </h2>
                <p>
                    Dziecięca ciekawość nie zna granic, u nas rozkwita każdego dnia! <br/>
                    Nasze kursy zostały stworzone z myślą o najmłodszych odkrywcach, <br/>
                    którzy chcą poznawać świat przez zabawę, kreatywność i rozwój.
                </p>

                <div className="two-text-columns">
                    <div className="flow">
                        <h3>Nasza Wizja</h3>
                        <p>
                            Tworzymy przestrzeń, gdzie dzieci mogą rozwijać swoje pasje i talenty w przyjaznej
                            atmosferze. Stawiamy na edukację przez doświadczenie, aby nauka była nie tylko skuteczna,
                            ale też pełna radości.
                        </p>
                        <p>Zajęcia kreatywne</p>
                        <p>Gry i zabawy ruchowe</p>
                        <p>Warsztaty tematyczne</p>
                    </div>

                    <div className="flow">
                        <h3>Nasza Misja</h3>
                        <p>
                            Pomagamy dzieciom odkrywać świat pełen możliwości, rozwijać ich naturalne talenty i budować pewność siebie. <br />
                            Każdy dzień u nas to nowa przygoda, pełna nauki, śmiechu i inspiracji!
                        </p>
                    </div>
                </div>

                <div>
                    <p className="bold">Zapisz się już dziś i rozpocznij niezapomnianą przygodę z nauką!</p>
                    <div className="Buttons special">Zapisz się!</div>
                </div>
            </div>
        </div>
    );
}

export default OurVision;
