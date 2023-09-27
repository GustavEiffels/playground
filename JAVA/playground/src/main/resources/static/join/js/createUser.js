
const createUserBtn             = document.getElementById('createUserInfo') ;
const forward2Index             = document.getElementById('forward2Index')  ;

const createUserBtnClickEvent   = createUserBtn.addEventListener('click',createUserBtnClickEventFunction);
const forward2IndexClickEvent   = forward2Index.addEventListener('click',forward2IndexClickEventFunction);


function forward2IndexClickEventFunction()
{ window.location.href = 'http://localhost:8099/'; }

function createUserBtnClickEventFunction()
{ 
    const username                  = document  .getElementById('username')         ;
    const userage                   = document  .getElementById('userage' )         ;
    const userid                    = document  .getElementById('userid'  )         ;
    const gender                    = document  .getElementById('gender'  )         ;
    const usernameValue             = username  .value                              ;
    const userageValue              = userage   .value                              ;
    const useridValue               = userid    .value                              ;
    const genderValue               = gender    .elements['gender'].value           ;

         if(usernameValue == '')         alert('유저 이름 넣어'  )                   ;
    else if(userageValue  == '')         alert('유저 나이 넣어'  )                   ;
    else if(useridValue   == '')         alert('유저 아이디 넣어')                   ;
    else if(genderValue   == '')         alert('유저 성별 넣어'  )                   ;

    console.log(usernameValue)                                                      ;
    console.log(userageValue )                                                      ;
    console.log(useridValue  )                                                      ;
    console.log(genderValue  )                                                      ;

    const body = {'name':usernameValue, 'age':userageValue, 'id':useridValue, 'gender':genderValue};

    fetch('/createAccount',{
        method  :'POST',
        headers :{
            'Content-Type' : 'application/json',
        },
        body : JSON.stringify(body),
    })
    .then((result)=>{
        console.log(result);
    })
}