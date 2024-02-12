import React, { useEffect, useState } from "react";
import "./List.css";
import { deleteFuntion } from "../../hooks/deleteUtility";

interface listProps {
  created_at: string;
  status: string;
  description: string;
  priority: number;
  item_names: string;
  id: string;
  url: string;
}

export interface listInterface {
  id: string;
  taskName: string;
  status: string;
  priority: number;
  dateCreated: string;
  desc: string;
}

export const List: React.FC<listProps> = (props) => {
  const handleDelete = async () => {
    deleteFuntion(props.url, props.id);
  };

  return (
    <div className="eachList">
      <p>ID:{props.id} </p>
      <p>Task: {props.item_names}</p>
      <p>Status: {props.status}</p>
      <p>Priority: {props.priority}</p>
      <p>Description: {props.description}</p>
      <p>Created at: {props.created_at}</p>
      <button className="deleteButton" onClick={handleDelete}>
        Delete
      </button>
    </div>
  );
};
