import express, { Request, Response } from "express";
import database from "./database";

const PORT = 8080;

const app = express();
app.use(express.json());

app.get("/health", (req: Request, res: Response) => {
  res.send("OK");
});

app.get("/items", (req: Request, res: Response) => {
  const { query } = req;

  console.log(query);
  res.status(200).json(database.getItems());
});

app.get("/lists", (req: Request, res: Response) => {
  res.status(200).json(database.getLists());
});

app.post("/lists", (req: Request, res: Response) => {

  const { created_at, from, behaviour_score, message_for_santa, item_names } = req.body;

  if (
    typeof created_at !== 'string' ||
    typeof from !== 'string' ||
    typeof behaviour_score !== 'string' ||
    typeof message_for_santa !== 'string' ||
    typeof item_names !== 'string'
  ) {
    return res.status(400).json({ error: "Invalid or missing fields. All fields must be strings." });
  }

  
try{
  const { body } = req;
  const newItem = database.
  addList(body);
  res.appendHeader("Location", `/lists/${newItem.id}`);
  res.status(201).json(newItem);
} catch(error) {
  console.error(error);
    return res.status(500).json({ error: "Internal Server Error" });
}
  
});

app.delete("/lists/:id", (req: Request, res: Response) => {
  const { params } = req;

  database.deleteList(params.id);
  res.status(200).send();
});

app.use("/img", express.static("products/img"));

app.listen(PORT, () => {
  console.log(
    `API server listening on port ${PORT} - http://localhost:${PORT}`
  );
});
