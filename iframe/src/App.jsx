import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import './App.css'
import MainPage from "./page/mainPage/mainPage";
function App() {

  return (
  <Router>
    <Routes>
      <Route path='/' element={<MainPage/>}/>
    </Routes>
  </Router>

  )
}

export default App
