import React from "react";

import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "./pages/home";

import "./index.css";
import Layout from "./pages/layout";

import Footer from "./pages/footer";
import Login from "./pages/login";

import NovoUsuario from "./pages/novo";

function App() {
  document.title = "SQL Inject Test";
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route index element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/novo-usuario" element={<NovoUsuario />} />
          </Route>
        </Routes>
        <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
