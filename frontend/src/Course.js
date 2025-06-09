import './App.css';
import React from "react";
import ArrowButton from './components/ArrowButton';
function Course() {
    return (
        <div>
            <ArrowButton />
            <div className="container flex-column">
                <div className="video-player">
                    <video controls>
                        <source src="/img/instalacja.mp4" type="video/mp4"/>
                    </video>
                    <div className="side-nav">
                        <h2>1. Wstęp i pierwsze ustawienia</h2>
                        <a href="#">Introduction & Setup</a>
                        <a href="#">Delivery Driver</a>
                        <a href="#">Game Design</a>
                        <a href="#">Coding Basics</a>
                        <a href="#">Game Mechanics</a>
                        <a href="#">UI & UX</a>
                        <a href="#">Advanced Techniques</a>
                        <a href="#">Final Project</a>
                        <a href="#">Community & Support</a>
                        <a href="#">Introduction & Setup</a>
                        <a href="#">Delivery Driver</a>
                        <a href="#">Game Design</a>
                        <a href="#">Coding Basics</a>
                        <a href="#">Game Mechanics</a>
                        <a href="#">UI & UX</a>
                        <a href="#">Advanced Techniques</a>
                        <a href="#">Final Project</a>
                        <a href="#">Community & Support</a>
                        <a href="#">Introduction & Setup</a>
                        <a href="#">Delivery Driver</a>
                        <a href="#">Game Design</a>
                        <a href="#">Coding Basics</a>
                        <a href="#">Game Mechanics</a>
                        <a href="#">UI & UX</a>
                        <a href="#">Advanced Techniques</a>
                        <a href="#">Final Project</a>
                        <a href="#">Community & Support</a>
                    </div>
                </div>
                <div className="course-bottom">
                    <div className="course-bottom-description">
                        <p className="bold fs-large-x">Tytuł sekcji kursu np. Instalacja IDE</p>
                        <p className="fs-large">Opis sekcji kursu np. pobieramy visual studio 2022 <br/>
                            i instalujemy rozszerzenia potrzebne w unity.</p>
                    </div>
                    <div>
                        <div className="Buttons special">Następna Lekcja</div>
                    </div>
                </div>
                <div className="course-bottom">
                    <div>
                        <h2>QA</h2>
                        <input
                            className="course-bottom-input-field"
                            type="text"
                            placeholder="Wpisz pytanie na które szukasz odpowiedzi"
                        />
                        <div className="Buttons special">Zadaj pytanie</div>
                    </div>
                    <div>
                        <h2>Do Pobrania</h2>
                        <p>Link</p>
                        <p>Link</p>
                    </div>
                </div>
                <div className="chat">
                    <div className="chat-element">
                        <p className="bold fs-large">Imię Nazwisko </p>
                        <p> Teść wiadomości ............... </p>
                    </div>
                    <div className="chat-element">
                        <p className="bold fs-large">Imię Nazwisko </p>
                        <p> Teść wiadomości ............... </p>
                    </div>
                    <div className="chat-element">
                        <p className="bold fs-large">Imię Nazwisko </p>
                        <p> Teść wiadomości ............... </p>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Course;
