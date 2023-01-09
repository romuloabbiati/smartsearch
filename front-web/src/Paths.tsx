import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Header from './components/Header';
import Home from './pages/Home';
import Records from './pages/Records';
import Charts from './pages/Charts';

const Path = () => (
    <BrowserRouter>
        <Header />
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/records" element={<Records />} />
            <Route path="/charts" element={<Charts />}></Route>
        </Routes>
    </BrowserRouter>
);

export default Path;