extends Node2D

func _ready():
	randomize() #empiece de forma aleatoria
	
func nueva_partida():
	#rellenar
	$inicio.mostrar_mensaje("Que gane el mejor!")
	# se pude cambiar este mensaje o eliminar 
	pass 

func game_over():
	#Mirar
	$inicio.game_over() #es necesaria pero no esta programada
	pass