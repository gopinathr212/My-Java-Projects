let current = 0;
let clicked = null;
let events = localStorage.getItem('events') ? JSON.parse(localStorage.getItem('events')) : [];

const calender = document.getElementById("calender");
const weekdays = ['Sunday' , 'Monday' , 'Tuesday' , 'Wednesday' , 'Thursday' , 'Friday' , 'Saturday'];

function effect() {
    const date = new Date();

    if(current !== 0){
        date.setMonth(new Date,getMonth()+current);
    }
    const day = date.getDate();
    const month = date.getMonth();
    const year = date.getFullYear();

    const firstDayInMonth = new Date(year,month,1);
    const lastDayInMonth = new Date(year,month+1,0).getDate();
    
    const dateString = firstDayInMonth.toLocaleDateString('en-in',{
        weekday: 'long',
        year: 'numeric',
        month: 'numeric',
        day: 'numeric'
    });
    const paddingDays = weekdays.indexOf(dateString.split(', ')[0]);

    document.getElementById('monthDisplay').innerText=
    `${date.toLocaleDateString('en-in',{month:'long'})} ${year}`;

    calender.innerHTML = '';

    for(let i=1;i<=paddingDays+lastDayInMonth;i++) {
        const daySquare = document.createElement('div');
        daySquare.classList.add('day');
        if(i>paddingDays){
            daySquare.innerText = i - paddingDays;
            daySquare.addEventListener('click',()=>console.log('click'));
        }else{
            daySquare.classList.add('padding');
        }

        calender.appendChild(daySquare);
    }
       
}

function initiButtons(){
    document.getElementById('nextButton').addEventListener('click',()=>{
        current++;
        effect();
    });
    document.getElementById('backButton').addEventListener('click',()=>{
        current--;
        effect();
    });

}
effect();