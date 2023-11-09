import "./Keyboard.css";
import { Button } from "./Button";

let keyboard = [
  "q",
  "w",
  "e",
  "r",
  "t",
  "y",
  "u",
  "i",
  "o",
  "p",
  "a",
  "s",
  "d",
  "f",
  "g",
  "h",
  "j",
  "k",
  "l",
  "z",
  "x",
  "c",
  "v",
  "b",
  "n",
  "m",
];

export const Keyboard = ({ onClick }) => {
  return (
    <div className="keyboard">
      {keyboard.map((element, index) => {
        return (
          <Button
            key={index}
            id={index}
            value={element}
            onClick={onClick}
          ></Button>
        );
      })}
    </div>
  );
};
