window.addEventListener('load', function(){
  new Glider(document.querySelector('.glider'), {
    slidesToShow: 1,
    slidesToScroll: 1,
    rewind: true,
    dots: '.dots',
    arrows: {
      prev: '.prev',
      next: '.next'
    },
    responsive: [{
      // screens greater than >=768px
      breakpoint: 768,
      settings: {
        slidesToShow: 2,
        slidesToScroll: 2
      }
    },{
      // screens greater than >= 1024px
      breakpoint: 1024,
      settings: {
        slidesToShow: 3,
        slidesToScroll: 3
      }
    }]
  });
});

const menu = document.getElementById("menu");
const listaMenu = menu.querySelectorAll("ul li a");
const secciones = document.querySelectorAll("section");
const iconMenu = document.getElementById("icon-movil");

function showMenu(){
  menu.classList.toggle("menu-mobile");
  iconMenu.classList.toggle("fa-bars");
  iconMenu.classList.toggle("fa-xmark");
}

function desableLink(){
  listaMenu.forEach(el => {
    el.classList.remove("active");
  }); 
}

function ocultarSeccion(){
  secciones.forEach(el => {
    el.classList.remove('section-show');  
  });
}

listaMenu.forEach( opc => {
  opc.addEventListener("click", el => {  
    desableLink();
    ocultarSeccion();
    el.target.classList.add("active");
    if(menu.classList.contains("menu-mobile"))
      showMenu();

    const seccion = el.target.getAttribute("href");
    if(seccion == "#header"){
      document.getElementById("header").classList.remove("header-top");
      document.getElementById("copyright").classList.remove("copyright-top");
    }
    else{
      document.getElementById("header").classList.add("header-top");
      document.querySelector(seccion).classList.add("section-show");
      document.getElementById("copyright").classList.add("copyright-top");
    }
  });
});