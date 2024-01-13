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
  const { body } = req;
  // TODO: fix dangerous code...
  const newItem = database.addList(body);

  res.appendHeader("Location", `/lists/${newItem.id}`);

  res.status(201).json(newItem);
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