export interface Item {
  star_rating?: string;
  price: string;
  title: string;
  image_key: string;
}

export const isItem = (t: object): t is Item => {
  return "price" in t && "title" in t && "image_key" in t;
};

export const isItemArray = (t: object[]): t is Item[] => {
  return t.find((item) => !isItem(item)) === undefined;
};

export type CreateListPayload = Omit<List, "id">;

export interface List {
  id: string;
  created_at: number;
  from: string;
  message_for_santa: string;
  behaviour_score: number;
  item_names: string[];
}
