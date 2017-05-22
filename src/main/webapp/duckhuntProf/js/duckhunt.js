var duckSent = 0;

function duckReset(){
	$("#duck").css("top", Math.random() * 400);
	$("#duck").css("left", -130);		//replace le canard à gauche
	$("#duck").attr("src", "img/duck-right.gif");
}

function duckExit() {
	duckReset();
	flyRight();
}

function flyRight() {
	duckSent++;

	if (duckSent == 10){
		alert("partie finie !");
	}
	
	//anime vers la droite. duckExit sera appelée à la fin de l'animation
	$("#duck").animate({"left":800, "top": Math.random() * 400}, 1000 + Math.random() * 1000, duckExit);
}

function flyLeft() {
	
	//anime vers la gauche. duckExit sera appelée à la fin de l'animation
	$("#duck").animate({"left":-800, "top": Math.random() * 400}, 1000 + Math.random() * 1000, duckExit);	
}

function killDuck(){
	$("#duck").stop(); //arrête les animations sur le canard
	$("#duck").attr("src", "img/duck-dead.gif");
	$("#duck").animate({"top": 500}, 600, function(){
		duckReset();
		flyRight();	
	});
}

//met le canard sous écoute (pour devenir tuable)
$("#duck").on("mousedown", killDuck);

//lance l'animation
flyRight();