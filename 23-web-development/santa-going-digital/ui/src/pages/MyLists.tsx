import React, { useEffect, useState } from "react";
import "./MyLists.css";
import { List, listInterface } from "../components/list/List";
import { useFetch } from "../hooks/useFetch";

interface myWishListProps {
  pathToGetLists: string;
}

export const MyWishList: React.FC<myWishListProps> = (props) => {
  // const [lists, setList] = useState<listInterface[]>([]);

  // const fetchLists = async (url: string): Promise<void> => {
  //   try {
  //     const response = await fetch(props.pathToGetLists);
  //     const jsonResponse = await response.json();
  //     setList(jsonResponse);
  //   } catch (error) {
  //     console.error(error);
  //   }
  // };

  // useEffect(() => {
  //   fetchLists(props.pathToGetLists);
  // }, [lists]);

  const {data:lists} = useFetch(props.pathToGetLists);

  const isListArray = (array: any[]): array is listInterface[] => {
    return array.every(item => item.from !== undefined);
  }


  if (lists && isListArray(lists)) {
    return (
      <div className="lists">
        <h1 className="heading">My Lists</h1>
        {lists.map((list) => {
          return (
            <List created_at={list.created_at} message_for_santa={list.message_for_santa} behaviour_score={list.behaviour_score} from={list.from} item_names={list.item_names} id = {list.id} url = {props.pathToGetLists}/>
          )
        })}
      </div>
    );
  }
  return <p>No lists found</p>;
};
