import React, { useState } from 'react';
import { useAuth } from '../context/AuthContext'; // Access global auth state
import LoginPopup from './loginComponents/LoginPopup'; // Import LoginPopup
import axios from 'axios';
import { Link } from 'react-router-dom'


function Menu() {
    const { user, setUser, logout } = useAuth(); // Access auth state and functions from AuthContext
    const [isPopupVisible, setIsPopupVisible] = useState(false); // Manage visibility of the login popup
    const [showDropdown, setShowDropdown] = useState(false); // Toggle dropdown visibility

    const showPopup = () => setIsPopupVisible(true);
    const hidePopup = () => setIsPopupVisible(false);
    const testApi = async () => {
        try {
            const response = await axios.get('http://localhost:8080/courses/auth/1', {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem('authToken')}`
                }
            });

            const courses = response.data;
            console.log(courses)
            // if (courses) {
            //     courses.forEach(course => {
            //         console.log('📚 Kurs:');
            //         console.log(`  ID: ${course.id}`);
            //         console.log(`  Tytuł: ${course.title}`);
            //         console.log(`  Opis: ${course.description}`);
            //
            //         console.log('  👥 Uczestnicy:');
            //         course.userCourses?.forEach(uc => {
            //             console.log(`    - ${uc.user?.username}`);
            //         });
            //
            //         console.log('---');
            //     });
            // } else {
            //     console.warn('⚠️ Oczekiwano tablicy, otrzymano:', courses);
            // }

        } catch (error) {
            console.error('❌ Błąd:', error);
        }
    };

    const handleLogout = () => {
        logout();
        setShowDropdown(false);
    };

    return (
    <div className="Menu">
        <div className="Logo">
            <Link to="/">
                <img src="/img/logo_new.png" alt="Code Heroes Logo" width="200"/>
            </Link>
        </div>

        {/* Main Menu */}
        <div className="Menu-buttons">
            <Link className="Buttons" to="/course">Kurs</Link>
            <Link className="Buttons" to="/">Kursy</Link>
            <Link className="Buttons" to="/">Kontakt</Link>
            <div className="Buttons inactive">Forum</div>
            <div className="Buttons inactive">Pomoc</div>
        </div>

        {/* User Section or Login Button */}
        {user ? (

            <div
                className="user-section"
                onMouseEnter={() => setShowDropdown(true)}
                onMouseLeave={() => setShowDropdown(false)}
            >
                <button className="account-button">
                    {user.username} ▼
                </button>
                {showDropdown && (
                    <div className="dropdown-menu">
                        <ul>
                            <li onClick={() => alert('Profile option clicked')}>Profil</li>
                            <li onClick={() => testApi()}>Moje kursy</li>
                            <li onClick={handleLogout}>Wyloguj</li>
                        </ul>
                    </div>
                )}
            </div>
        ) : (
            // If the user is not logged in, show the login button
            <div className="Buttons special" onClick={showPopup}>
                Wypróbuj za darmo!
            </div>
        )}

        {/* Show Login Popup if isPopupVisible is true */}
        {isPopupVisible && <LoginPopup setIsPopupVisible={setIsPopupVisible}/>}
    </div>
)
    ;
}

export default Menu;
