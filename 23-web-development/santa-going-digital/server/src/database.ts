import fs from "fs";
import { CreateListPayload, isItemArray, Item, List } from "./types";
import { v4 as generateUUID } from "uuid";

class Database {
  items: Item[];
  lists: List[];
  constructor() {
    let rawItemFiles;
    try {
      rawItemFiles = JSON.parse(
        fs.readFileSync("products/products.json", "utf-8")
      );
    } catch {
      throw new Error("Unable to parse products data file");
    }

    if (!isItemArray(rawItemFiles)) {
      throw new Error("Format issue with products data file");
    }

    this.items = rawItemFiles;
    this.lists = JSON.parse(fs.readFileSync("products/lists.json", "utf-8"));
  }

  public getItems(): Item[] {
    return this.items;
  }

  public searchItems(query: string): Item[] {
    // TODO: Consider how we might use this function...
    return this.items;
  }

  public getLists(): List[] {
    return this.lists;
  }

  public addList(newList: CreateListPayload) {
    const listWithId = { ...newList, id: generateUUID() };

    this.lists.push(listWithId);
    this.writeListsToFile();

    return listWithId;
  }

  public deleteList(id: string) {
    this.lists = this.lists.filter((l) => l.id !== id);
    this.writeListsToFile();
  }

  private writeListsToFile() {
    fs.writeFileSync("products/lists.json", JSON.stringify(this.lists));
  }
}

const db = new Database();
export default db;
