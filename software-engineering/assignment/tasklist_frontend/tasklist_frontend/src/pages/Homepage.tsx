import React from "react";
import "./Homepage.css";
import { Button } from "../components/button/Button";

export const Homepage: React.FC = () => {
  return (
    <>
      <div className="App">
        <header className="App-header">
          <h1 className="text-5xl font-bold text-lime-400 my-8" >Tasklist App</h1>
          <div className="Home-page-button">
            <Button text="Create task" path="/create-list"></Button>
            <Button text="My tasks" path="/my-lists"></Button>
            <Button text="Just Browsing" path="/products"></Button>
          </div>
        </header>
      </div>
    </>
  );
};
