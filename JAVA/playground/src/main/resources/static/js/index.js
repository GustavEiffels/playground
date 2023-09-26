

const joinBtn = document.getElementById('forward2Join');


const joinBtnEventListener = joinBtn.addEventListener('click',forward2Join)




function forward2Join()
{
    fetch('/joinPage').then(()=>{console.log('go to join!');})
}