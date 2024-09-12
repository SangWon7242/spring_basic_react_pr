import { BrowserRouter, Routes, Route, json } from "react-router-dom";
import "./App.css";

import { useEffect, useState } from "react";
import axios from "axios";

const Home = () => {
  const [hello, setHello] = useState("");

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/home")
      .then((res) => setHello(res.data))
      .catch((error) => console.log(error));
  }, []);

  return <div>백엔드에서 받은 데이터 : {hello}</div>;
};

const List = () => {
  const [articles, setArticles] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/list")
      .then((res) => setArticles(res.data))
      .catch((error) => console.log(error));
  }, []);

  return (
    <nav>
      <ul>
        {articles.map((article) => (
          <li key={article.id}>
            <div>id : {article.id}</div>
            <div>제목 : {article.subject}</div>
            <div>내용 : {article.content}</div>
          </li>
        ))}
      </ul>
    </nav>
  );
};

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/list" element={<List />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
