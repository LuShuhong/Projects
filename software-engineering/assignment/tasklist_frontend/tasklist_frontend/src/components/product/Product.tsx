import React from "react";
import "./Product.css";
import { useFetch } from "../../hooks/useFetch";
import { useFetchImage } from "../../hooks/useFetchImage";
import { Button } from "../button/Button";

export interface productProps {
  url: string;
  imageKey: string;
  title: string;
  star?: string;
}

export interface productInterface {
  star_rating?: string;
  price: string;
  title: string;
  image_key: string;
}

export const Product: React.FC<productProps> = (props) => {
  const imageUrl: string = `${props.url}/${props.imageKey}`;

  const { data, loading, error } = useFetchImage(imageUrl);
  if (loading) return <p>Loading...</p>;
  if (error) return <p>So bad, there is an error: {error.message}</p>;

  const star: number | null = props.star
    ? Number(Number(props.star).toFixed(2))
    : null;

    
  return (
    <div className="image">
      <img alt={props.imageKey} src={`${data}`} />
      <p>{props.title}</p>
      {props.star ? <p>Star rating: {star}</p> : null}
      {/* <div className="image-button">
        <Button text="Add to List as Guest" path=""></Button>
      </div> */}
    </div>
  );
};
