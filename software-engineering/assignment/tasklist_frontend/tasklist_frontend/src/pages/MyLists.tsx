import React, { useEffect, useState } from "react";
import "./MyLists.css";
import { List, listInterface } from "../components/list/List";

interface myListProps {
  pathToGetLists: string;
}

export const MyWishList: React.FC<myListProps> = (props) => {
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
  }, [props.pathToGetLists]);

  if (lists) {
    return (
      <div className="lists">
        <h1 className="heading">My Tasks</h1>
        {lists.map((list) => {
          return (
            <List
              dateCreated={list.dateCreated}
              desc={list.desc}
              priority={list.priority}
              status={list.status}
              taskName={list.taskName}
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
