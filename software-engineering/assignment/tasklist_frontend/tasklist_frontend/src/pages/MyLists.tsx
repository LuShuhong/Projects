import React, { useEffect, useState } from "react";
import "./MyLists.css";
import { List, listInterface } from "../components/list/List";

interface myWishListProps {
  pathToGetLists: string;
}

export const MyWishList: React.FC<myWishListProps> = (props) => {
  const [lists, setList] = useState<listInterface[]>([]);

  const fetchLists = async (url: string): Promise<void> => {
    try {
      const response = await fetch(url);
      const jsonResponse = await response.json();
      setList(jsonResponse);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    fetchLists(props.pathToGetLists);
  }, [lists]);

  if (lists) {
    return (
      <div className="lists">
        <h1 className="heading">My Lists</h1>
        {lists.map((list) => {
          return (
            <List
          
              created_at={list.dateCreated}
              description={list.desc}
              priority={list.priority}
              status={list.status}
              item_names={list.taskName}
              id={list.id}
              url={props.pathToGetLists}
            />
          );
        })}
      </div>
    );
  }
  return <p>No lists found</p>;
};
