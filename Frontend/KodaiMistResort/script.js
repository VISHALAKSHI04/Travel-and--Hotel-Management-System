const topbar=document.querySelector('.topbar');
window.addEventListener('scroll',()=>{if(topbar)topbar.classList.toggle('scrolled',scrollY>40)});
const menu=document.querySelector('.menu'); const nav=document.querySelector('nav');
if(menu)menu.addEventListener('click',()=>nav.classList.toggle('open'));
const observer=new IntersectionObserver(entries=>entries.forEach(e=>{if(e.isIntersecting)e.target.classList.add('visible')}),{threshold:.12});
document.querySelectorAll('.reveal').forEach(el=>observer.observe(el));
document.querySelectorAll('.gallery-item').forEach(item=>item.addEventListener('click',()=>{const box=document.querySelector('.lightbox');if(!box)return;box.querySelector('img').src=item.querySelector('img').src;box.classList.add('show')}));
const close=document.querySelector('.close');if(close)close.addEventListener('click',()=>document.querySelector('.lightbox').classList.remove('show'));
const light=document.querySelector('.lightbox');if(light)light.addEventListener('click',e=>{if(e.target===light)light.classList.remove('show')});
function bookDemo(e){e.preventDefault();const t=document.querySelector('.toast');t.classList.add('show');setTimeout(()=>t.classList.remove('show'),3500);return false}
