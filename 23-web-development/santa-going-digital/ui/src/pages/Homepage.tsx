import React from "react";
import "./Homepage.css";
import { Button } from "../components/button/Button";
import { Product } from "../components/product/Product";

interface Props {}

export const Homepage: React.FC<Props> = (props) => {
  return (
    <>
      <div className="App">
        <header className="App-header">
          <h1>Santa is here</h1>
          <div className="Home-page-button">
            <Button text="Create list" path="/create-list"></Button>
            <Button text="My lists" path="/my-lists"></Button>
            <Button text="Just Browsing" path="/products"></Button>
          </div>
        </header>
      </div>
    </>
  );
};
