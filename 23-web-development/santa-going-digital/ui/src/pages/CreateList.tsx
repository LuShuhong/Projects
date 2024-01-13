import React from "react";
import "./CreateList.css";
import { postFunction } from "../hooks/postUtility";

interface Props {
  urlToSend: string;
}


export const CreateList: React.FC<Props> = (props) => {

  const currentDate = new Date().toLocaleDateString();

  const handleSubmit = async(event: React.FormEvent) => {
    event.preventDefault();
    const form = event.target as HTMLFormElement;
    const formData = new FormData(form);
    const jsonObject: Record<string, string | File> = {};
    formData.forEach((value, key) => { jsonObject[key] = value; });

    await postFunction(props.urlToSend, jsonObject)
  }

  return (
    <div className="creation-page">
      <h1 className="create-list-heading">Tell Santa your List</h1>
      <form onSubmit={handleSubmit}>
        <ul>

        <li>
            <label htmlFor="date">Date:</label>
            <input type="text" id="date" name="created_at" value={currentDate} readOnly />
          </li>

          <li>
            <label htmlFor="name">Name:</label>
            <input type="text" id="name" name="from" />
          </li>

          <li>
          <label htmlFor="score">Behaviour Score: </label>
            <input type="number" id="score" name="behaviour_score" />
          </li>

          <li>
            <label htmlFor="message">Message for Santa: </label>
            <textarea id="message" name="message_for_santa" > Write your message here</textarea>
          </li>

          <li>
            <label htmlFor="items">Your Items: </label>
            <textarea id="items" name="item_names" > Input your items</textarea>
          </li>

          <li className="submit-button">
            <button type="submit">Send your message!</button>
          </li>
        </ul>
      </form>
    </div>
  );
};
