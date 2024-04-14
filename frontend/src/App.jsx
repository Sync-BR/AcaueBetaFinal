import React from 'react';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import Header from './components/layouts/header'
import Home from './components/pages/Home';
import Portfolio from './components/pages/Portfolio';
import Project from './components/pages/ProjectSingle';
import Footer from './components/layouts/footer';


function App() {
//teste
  return (
    <Router>
      <Header />
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route path="/project/:id" element={<Project />} />
        <Route path="/portfolio" element={<Portfolio />} />
      </Routes>
      <Footer />
    </Router>
  )
}

export default App
