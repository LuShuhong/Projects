import React from "react";
import "./CreateList.css";

interface Props {
  urlToSend: string;
}


export const CreateList: React.FC<Props> = (props) => {
  return (
    <div className="creation-page">
      <h1 className="create-list-heading">Tell Santa your List</h1>
      <form action={props.urlToSend} method="post">
        <ul>
          

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
            <button type="submit">Send your message</button>
          </li>
        </ul>
      </form>
    </div>
  );
};
