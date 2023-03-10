import React, { useState, useEffect } from 'react';
import Filters from '../../components/Filters';
import './styles.css';
import { barOptions, pieOptions } from './chart-options';
import Chart from 'react-apexcharts';
import axios from 'axios';
import { buildBarSeries, getPlatformChartData, getGenreChartData } from './helpers';

type PieChartData = {
    labels: string[];
    series: number[];
}

type BarChartData = {
    x: string;
    y: number;
}

const initialPieData = {
    labels: [],
    series: []
}

const BASE_URL = 'https://smartsearch-abbiati.herokuapp.com'

const Charts = () => {
    const [barChartData, setBarChartData] = useState<BarChartData[]>([]);
    const [platformData, setPlatformData] = useState<PieChartData>(initialPieData);
    const [genreData, setGenreData] = useState<PieChartData>(initialPieData);
    
    useEffect(() => {
        async function getData() {
            const recordsResponse = await axios.get(`${BASE_URL}/records`);
            const gamesResponse = await axios.get(`${BASE_URL}/games`)
            
            const barData = buildBarSeries(gamesResponse.data, recordsResponse.data.content);
            setBarChartData(barData);
            console.log(barData);

            const platformChartData = getPlatformChartData(recordsResponse.data.content);
            setPlatformData(platformChartData);

            const genreChartData = getGenreChartData(recordsResponse.data.content);
            setGenreData(genreChartData);
        }

        getData();
    }, [])

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
                            height="650"
                            series={[{ data: barChartData }]}
                        />
                    </div>
                </div>
                <div className="charts">
                    <div className="platform-chart">
                        <h2 className="chart-title">Platforms</h2>
                        <Chart 
                            options={{ ...pieOptions, labels: platformData?.labels}}
                            type="donut"
                            series={platformData?.series}
                            width="350"
                        />
                    </div>
                    <div className="genre-chart">
                        <h2 className="chart-title">Genres</h2>
                        <Chart 
                            options={{ ...pieOptions, labels: genreData?.labels}}
                            type="donut"
                            series={genreData?.series}
                            width="350"
                        />
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Charts;