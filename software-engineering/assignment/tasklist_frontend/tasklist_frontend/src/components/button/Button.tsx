import React, {MouseEvent, FC} from "react";
import "./Button.css";
import { useNavigate } from "react-router-dom";

interface Props {
  text: string;
  path:string;
}

export const Button: React.FC<Props> = ({path,text}) => {
  let navigate = useNavigate();

  const handleClick =(event:MouseEvent<HTMLButtonElement>):void =>{
    navigate(path)
  }

  return (
    <button className="button" role="button" onClick={handleClick}>
      {text}
    </button>
  );
};
