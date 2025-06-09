import './App.css';
import './styles/LoginPopup.css';

import Menu from './components/Menu';
import Home from './Home';
import Course from './Course';
import Footer from './components/Footer';
import Underfooter from './components/Underfooter';
import { AuthProvider } from './context/AuthContext';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';


function App() {
    return (
        <Router>
            <AuthProvider>
                <div className="Fullpage">
                    <Menu />
                        <Switch>
                            <Route exact path="/">
                                <Home />
                            </Route>
                            <Route path="/course">
                                <Course />
                            </Route>
                        </Switch>
                    <div className="wrapper">
                        <Footer />
                        <Underfooter />
                    </div>
                </div>
            </AuthProvider>
        </Router>
    );
}

export default App;
