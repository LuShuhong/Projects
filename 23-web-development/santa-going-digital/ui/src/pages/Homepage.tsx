import React from "react";
import "./Homepage.css";
import { Button } from "../button/Button";

interface Props {}

export const Homepage: React.FC<Props> = (props) => {
  return (
    <>
      <div className="App">
        <header className="App-header">
          <h1>Santa is here</h1>
          <div className="Home-page-button">
            <Button text="Create Wishlist" path = '/create-wishlist'></Button>
            <Button text="My Wishlist" path = '/my-wishlist'></Button>
            <Button text="Just Browsing" path = '/products'></Button>
          </div>
        </header>
      </div>
    </>
  );
};
