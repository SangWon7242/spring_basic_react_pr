import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import "./App.css";
import "./index.css";

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

const Header = () => {
  return (
    <header className="top-bar h-[80px] bg-[#dfdfdf]">
      <div className="con mx-auto max-w-[1100px] flex h-full">
        <div className="logo-box">
          <Link to="/">로고</Link>
        </div>
        <nav className="menu-1">
          <ul className="flex gap-x-[10px]">
            <li>
              <Link to="/">글쓰기</Link>
            </li>
            <li>
              <Link to="/list">리스트</Link>
            </li>
          </ul>
        </nav>
      </div>
    </header>
  );
};

function App() {
  return (
    <BrowserRouter>
      <Header />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/list" element={<List />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
