

const joinBtn = document.getElementById('forward2Join');


const joinBtnEventListener = joinBtn.addEventListener('click',forward2Join)




function forward2Join()
{
    fetch('/joinPage')
    .then((result)=>{
        console.log(result);
        window.location.href = result.url;
    })
}