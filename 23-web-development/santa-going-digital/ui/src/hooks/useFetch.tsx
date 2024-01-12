import React, { useState, useEffect } from "react";
import { Product } from "../components/product/Product";

// interface Props{
//     url:string;
//     imageKey?: string;
// }

export const useFetch = (
  url: string
): { data: Product[] | undefined; loading: boolean; error: Error | null } => {
  const [data, setData] = useState();
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<Error | null>(null);

  const fetchData = async () => {
    setLoading(true);
    try {
      const response = await fetch(url);
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const jsonData = await response.json();
      setData(jsonData);
    } catch (error: any) {
      if (error instanceof Error) {
        setError(error);
      } else {
        setError(new Error("An unknown error occured!"));
      }
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchData();
  }, [url]);

  return { data, loading, error };
};
