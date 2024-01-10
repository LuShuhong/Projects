import React from "react";
import "./product.css";

interface Props {
  imageKey: string;
}

export const Product: React.FC<Props> = (props) => {
  
  return (
    <div className="image">
    <img alt={props.imageKey}/>
    </div>
  );
};