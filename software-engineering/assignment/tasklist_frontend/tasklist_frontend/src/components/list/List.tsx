import React from "react";
import "./List.css";
import { deleteFuntion } from "../../hooks/deleteUtility";
import { useNavigate } from "react-router-dom";

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
  let navigate = useNavigate();
  const handleDelete = async () => {
    deleteFuntion(props.url, props.id);
  };

  const handleEdit = async () => {
    navigate("../create-list");
  };

  return (
    <div className="eachList">
      <p>ID:{props.id} </p>
      <p>Task: {props.item_names}</p>
      <p>Status: {props.status}</p>
      <p>Priority: {props.priority}</p>
      <p>Description: {props.description}</p>
      <p>Created at: {props.created_at}</p>
      <button className="editButton" onClick={handleEdit}>
        Edit
      </button>
      <button className="deleteButton" onClick={handleDelete}>
        Delete
      </button>
    </div>
  );
};
