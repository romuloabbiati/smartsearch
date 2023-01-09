import React from 'react';
import Filters from '../../components/Filters';
import './styles.css';
import { barOptions } from './chart-options';
import Chart from 'react-apexcharts';

const chartData = [
    {
        x: 'Romulo',
        y: 10
    },
    {
        x: 'Isabela',
        y: 20
    }
]

const Charts = () => {
    return (
        <div className="page-container">
            <Filters link="/records" linkText="SEE TABLE" />
            <div className="chart-container">
                <div className="top-related">
                    <h1 className="top-related-title">
                        Top Rated Games
                    </h1>
                    <div className="games-container">
                        <Chart 
                            options={barOptions}
                            type="bar"
                            width="900"
                            height="150"
                            series={[{ data: chartData }]}
                        />
                    </div>
                </div>
                <div className="charts">
                    <div className="platform-chart">
                        <h2 className="chart-title">Platforms</h2>
                        
                    </div>
                    <div className="genre-chart">
                        <h2 className="chart-title">Genres</h2>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Charts;