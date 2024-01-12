import React from "react";
import "./MyWishList.css";
import { useFetch } from "../hooks/useFetch";
import { Product } from "../components/product/Product";

interface myWishListProps {
    pathToGetLists: string;
}

export const MyWishList: React.FC<myWishListProps> = (props) => {
  const { data: lists, loading, error } = useFetch(props.pathToGetLists);
  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error.message}</p>;

  if (lists) {
    return (
      <div className="lists">
        {lists.map((list) => {
          return (
            <p>test</p>
          )
        })}
      </div>
    );
  }
  return <p>No lists found</p>;
};
