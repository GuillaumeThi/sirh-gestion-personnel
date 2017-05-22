function moveLeft()
{
	//cible le dernier lien
	//l'anime vers la gauche
	$("#slider img").last().animate({"left": -960}, 3000, function(){
		//prend la dernière image et la déplace au début du #slider
		$(this).css("left", 0);
		$("#slider").prepend(this);
		window.setTimeout(moveRight, 3000);
	});
}

function moveRight()
{
	//cible le dernier lien
	//l'anime vers la gauche
	$("#slider img").last().animate({"left": 960}, 3000, function(){
		//prend la dernière image et la déplace au début du #slider
		$(this).css("left", -130);
		$("#slider").prepend(this);
		window.setTimeout(moveRight, 500);
	});
}


window.setTimeout(moveRight, 500);


$("#slider img").on("mousedown", shotDown);

function shotDown() {
	$("#slider img").attr("src", "img/duck-dead.gif");

	$("#slider img").last().stop();
	$("#slider img").last().animate({"top": 300}, function(){
		$(this).css("left", -130);
		$(this).css("top", 0);
		$(this).attr("src", "img/duck-right.gif");
		$("#slider").prepend(this);
		window.setTimeout(moveRight, 1000);
	});
}


//appelle la fonction move dans 2 secondes
//window.setTimeout(move, 1000);

//appelle la fonction move toutes les 2 secondes
//window.setInterval(move, 1000);
