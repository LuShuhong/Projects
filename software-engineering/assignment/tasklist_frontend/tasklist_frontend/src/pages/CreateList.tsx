import React from "react";
import "./CreateList.css";
import { postFunction } from "../hooks/postUtility";

interface Props {
  urlToSend: string;
}

export const CreateList: React.FC<Props> = (props) => {
  const currentDate = new Date().toISOString();

  const handleSubmit = async (event: React.FormEvent) => {
    const form = event.target as HTMLFormElement;
    const formData = new FormData(form);
    const jsonObject: Record<string, string | File> = {};
    formData.forEach((value, key) => {
      jsonObject[key] = value;
    });

    await postFunction(props.urlToSend, jsonObject);
    console.log(jsonObject);
  };

  return (
    <div className="creation-page">
      <h1 className="create-list-heading">Create New Task</h1>
      <form onSubmit={handleSubmit}>
        <ul>
          <li>
            <label htmlFor="dateCreated">Date:</label>
            <input
              type="text"
              id="dateCreated"
              name="dateCreated"
              value={currentDate}
              readOnly
            />
          </li>

          <li>
            <label htmlFor="taskName">Task:</label>
            <input type="text" id="taskName" name="taskName" />
          </li>

          <li>
            <label htmlFor="priority">Priority: </label>
            <input type="number" id="priority" name="priority" />
          </li>

          <li>
            <label htmlFor="status">Status: </label>
            <textarea
              id="status"
              name="status"
              defaultValue="COMPLETED/IN_PROGRESS"
            ></textarea>
          </li>

          <li>
            <label htmlFor="desc">Description: </label>
            <textarea
              id="desc"
              name="desc"
              defaultValue="Write Anything"
            ></textarea>
          </li>

          <li className="submit-button">
            <button type="submit">Send your task!</button>
          </li>
        </ul>
      </form>
    </div>
  );
};
