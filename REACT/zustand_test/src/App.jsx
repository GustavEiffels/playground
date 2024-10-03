
import { useState } from 'react'
import './App.css'
import useZustand from './useZustand'



function App() {

  const {user,userName, setUserName, userList, setUserList} = useZustand()
  
  const [inputVal, setInputVal] = useState('')
  const onChangeHandler = (e)=>{
    const currentVal =  e.target.value
    setInputVal(currentVal)
    console.log(inputVal)
  }

  const readName = ()=>{
    alert(userName)
  }
  
  const changeName = ()=>{
    setUserName(inputVal)
  }

  const addUserInUserList = ()=>{
    setUserList(inputVal)
  }

  const readUserList = ()=>{
    alert(JSON.stringify(userList))
  }

  return (
    <>
      <div className='testCmp'>
        <input onChange={onChangeHandler}/>
        <div className='btnLine'>
          <button onClick={changeName}> CHANGE NAME </button>
          <button onClick={readName}> READ NAME </button>
          <button onClick={addUserInUserList}> ADD USER </button>
          <button onClick={readUserList}> READ USER LIST </button>
        </div>
      </div>
    </>
  )
}

export default App