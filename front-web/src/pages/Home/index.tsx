import React from 'react';
import { ReactComponent as ArrowIcon } from '../../assets/arrow.svg';
import { ReactComponent as GamerImage } from '../../assets/gamer.svg';
import { Link } from 'react-router-dom';
import './styles.css';

const Home = () => (
    <div className="home-container">
        <div className="home-text">
            <h1 className="home-text-title">
                What games do you think most people enjoy?
            </h1>
            <h3 className="home-text-subtitle">
                Click the button below and find out which games are the players choosing?
            </h3>
            <Link to="/records">
                <div className="home-actions">
                    <button className="home-btn">
                        I WANT TO FIND OUT
                    </button>
                    <div className="home-btn-icon">
                        <ArrowIcon />
                    </div>
                </div>
            </Link>
        </div>
        <GamerImage className="home-image" />
    </div>
);

export default Home;