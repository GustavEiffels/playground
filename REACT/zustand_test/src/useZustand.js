import {create} from 'zustand'

const useZustand = create((set)=>(
    {
        user:'test',
        userName:'테스트',
        userList:[],
        userInfo:{},
        setUser:(user)=>set({user}),
        setUserName:(userName)=>set({userName}),
        setUserList:(newUserInfo)=> set((prev)=>({
            userList:[...prev.userList, newUserInfo]
        }))
    }
))

export default useZustand;