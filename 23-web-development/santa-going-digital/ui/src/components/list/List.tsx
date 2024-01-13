import React, { useEffect, useState } from "react";
import { productInterface } from "../product/Product";
import { Button } from "../button/Button";
import "./List.css";
import { deleteFuntion } from "../../hooks/deleteUtility";

interface listProps {
  created_at: string;
  from: string;
  message_for_santa: string;
  behaviour_score: number;
  item_names: string;
  id: string;
  url: string;
}

export interface listInterface {
  created_at: string;
  from: string;
  message_for_santa: string;
  behaviour_score: number;
  item_names: string;
  id: string;
}

export const List: React.FC<listProps> = (props) => {
  const handleDelete = async () => {
    deleteFuntion(props.url, props.id);
  };

  return (
    <div className="eachList">
      <p>Created at: {props.created_at}</p>
      <p>From: {props.from}</p>
      <p>Behaviour score: {props.behaviour_score}</p>
      <p>Message: {props.message_for_santa}</p>
      <p>List: {props.item_names}</p>
      <button className="deleteButton" onClick={handleDelete}>
        Delete
      </button>
    </div>
  );
};
