import React from "react";
import { Link } from 'react-router-dom'

function ArrowButton() {
    return (
        <div className="course-title">
            <Link className="arrow-button" to="/">
                <img src="/img/left-arrow.png" alt="Wróć do kursów"/>
                <p className="bold fs-large-x">Kursy</p>
            </Link>
            <div className="bold fs-large-x">|</div>
            <p className="bold fs-large-x">Kompletny Kurs Tworzenia Gier 2D: Stwórz Własne Gry w Unity z C#</p>
        </div>
    );
}

export default ArrowButton;