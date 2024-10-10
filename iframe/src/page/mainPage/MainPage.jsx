import { useState } from "react"
import './MainPage.css'

const MainPage =()=>{

    const [inputVal, setInputVal] = useState('')    

    const changeHandler = (e)=>{
        const changeVal = e.target.value
        setInputVal(changeVal)
    }

    const clickHandler = (e)=>{
        console.log('inputval : ',inputVal)
        alert('changeVal : '+inputVal)
        setInputVal('')
    }
    
    return (
        <div className="wrapper">
            <h2>IFAME TEST</h2>
            <div className="navi">
                <input type="text" value={inputVal} onChange={changeHandler}/>
                <button onClick={clickHandler}>GENERATE</button>
            </div>
            {inputVal}
        </div>
    )
}

export default MainPage