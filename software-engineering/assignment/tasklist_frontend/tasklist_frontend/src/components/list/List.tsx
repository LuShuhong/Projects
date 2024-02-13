import React, { useState } from "react";
import "./List.css";
import { deleteFuntion } from "../../hooks/deleteUtility";
import { putFunction } from "../../hooks/putUtility";

interface listProps {
  dateCreated: string;
  status: string;
  desc: string;
  priority: number;
  taskName: string;
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
  const [isEditMode, setIsEditMode] = useState(false);
  const [editedTask, setEditedTask] = useState({
    id: props.id,
    taskName: props.taskName,
    status: props.status,
    priority: props.priority,
    dateCreated: props.dateCreated,
    desc: props.desc,
  });

  const handleDelete = async () => {
    deleteFuntion(props.url, props.id);
  };

  const handleEdit = () => {
    setIsEditMode(true);
  };

  const handleSave = async () => {
    setIsEditMode(false);
    const taskUrl = props.url + "/" + props.id;
    console.log(taskUrl);
    console.log(editedTask);
    await putFunction(taskUrl, editedTask);
  };

  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) => {
    setEditedTask({ ...editedTask, [e.target.name]: e.target.value });
  };

  return (
    <div className="eachList">
      {isEditMode ? (
        <>
          <input name="id" value={editedTask.id} readOnly />
          <input
            name="taskName"
            value={editedTask.taskName}
            onChange={handleChange}
          />
          <input
            name="status"
            value={editedTask.status}
            onChange={handleChange}
          />
          <input
            name="priority"
            type="number"
            value={editedTask.priority}
            onChange={handleChange}
          />
          <textarea
            name="desc"
            value={editedTask.desc}
            onChange={handleChange}
          />
          <button className="saveButton" onClick={handleSave}>
            Save
          </button>
        </>
      ) : (
        <>
          <p>ID: {props.id}</p>
          <p>Task: {props.taskName}</p>
          <p>Status: {props.status}</p>
          <p>Priority: {props.priority}</p>
          <p>Description: {props.desc}</p>
          <p>Created at: {props.dateCreated}</p>
          <button className="editButton" onClick={handleEdit}>
            Edit
          </button>
          <button className="deleteButton" onClick={handleDelete}>
            Delete
          </button>
        </>
      )}
    </div>
  );
};
