import './App.css';
import Hero from './components/Hero';
import OurVision from './components/OurVision';
import Banner from './components/Banner';

function Home() {
    return (
        <div className="Fullpage">
            <Hero />
            <Banner />
            <OurVision />
        </div>
    );
}

export default Home;
