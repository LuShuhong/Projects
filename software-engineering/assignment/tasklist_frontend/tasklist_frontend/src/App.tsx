import "./App.css";

import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Homepage } from "./pages/Homepage";
import { ProductsPage } from "./pages/ProductsPage";
import { MyWishList } from "./pages/MyLists";
import { CreateList } from "./pages/CreateList";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Homepage />}></Route>
        <Route path="/home" element={<Homepage />}></Route>

        <Route
          path="/find"
          element={<ProductsPage pathToGetItems="/items" baseUrl="/img" />}
        ></Route>

        <Route
          path="/my-lists"
          element={
            <MyWishList pathToGetLists="http://localhost:8080/api/task" />
          }
        ></Route>

        <Route
          path="/create-list"
          element={<CreateList urlToSend="http://localhost:8080/api/task" />}
        ></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
