import React from "react";
import "./CreateList.css";
import { postFunction } from "../hooks/postUtility";

interface Props {
  urlToSend: string;
}

export const CreateList: React.FC<Props> = (props) => {
  const currentDate = new Date().toLocaleDateString();

  const handleSubmit = async (event: React.FormEvent) => {
    const form = event.target as HTMLFormElement;
    const formData = new FormData(form);
    const jsonObject: Record<string, string | File> = {};
    formData.forEach((value, key) => {
      jsonObject[key] = value;
    });

    await postFunction(props.urlToSend, jsonObject);
  };

  return (
    <div className="creation-page">
      <h1 className="create-list-heading">Create New Task</h1>
      <form onSubmit={handleSubmit}>
        <ul>
          <li>
            <label htmlFor="date">Date:</label>
            <input
              type="text"
              id="date"
              name="created_at"
              value={currentDate}
              readOnly
            />
          </li>

          <li>
            <label htmlFor="name">Task:</label>
            <input type="text" id="name" name="from" />
          </li>

          <li>
            <label htmlFor="score">Priority: </label>
            <input type="number" id="score" name="behaviour_score" />
          </li>

          <li>
            <label htmlFor="message">Status: </label>
            <textarea
              id="message"
              name="message_for_santa"
              defaultValue="COMPLETED/IN_PROGRESS"
            ></textarea>
          </li>

          <li>
            <label htmlFor="items">Description: </label>
            <textarea
              id="items"
              name="item_names"
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
