import React from "react";
import "./ProductsPage.css";
import { useFetch } from "../hooks/useFetch";
import { Product } from "../components/product/Product";
import { productInterface } from "../components/product/Product";

interface productPageProps {
  baseUrl: string;
  pathToGetItems: string;
}

export const ProductsPage: React.FC<productPageProps> = (props) => {
  const { data: products, loading, error } = useFetch(props.pathToGetItems);
  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error.message}</p>;

  if (products ) {
    return (
      <div className="image-tile">
        {products.map((product) => {
            return (
              <Product
                url={props.baseUrl}
                imageKey={`${product.image_key}`}
                title={product.title}
                star={product.star_rating}
              ></Product>
            );
        })}
        ;
      </div>
    );
  }
  return <p>No products found</p>;
};
