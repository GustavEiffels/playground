
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
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json(); // JSON 데이터를 추출하는 Promise 반환
    })
    .then(resultBody => {
        // 이제 resultBody는 파싱된 JSON 데이터입니다.
        console.log(resultBody);
        alert(JSON.stringify(resultBody)); // JSON 데이터를 문자열로 변환하여 alert로 표시
    })
    .catch(error => {
        console.error('Error:', error);
    });

}