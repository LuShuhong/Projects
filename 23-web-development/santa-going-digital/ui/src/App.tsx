import React from "react";
import logo from "./logo.svg";
import "./App.css";

import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Homepage } from "./pages/Homepage";
import { ProductsPage } from "./pages/ProductsPage";
import {MyWishList} from "./pages/MyWishList";

function App() {
  return (
    <BrowserRouter>
      <Routes>
      <Route path="/" element={<Homepage />}></Route>
        <Route path="/home" element={<Homepage />}></Route>
      
        <Route path="/products" element={<ProductsPage pathToGetItems= "/items" baseUrl="/img"/>}></Route>

        <Route path="/my-wishlist" element={<MyWishList pathToGetLists= "/lists" />}></Route>
      
      </Routes>
    </BrowserRouter>
  );
}

export default App;
