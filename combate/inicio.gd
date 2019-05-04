extends CanvasLayer

signal iniciar_juego

func mostrar_mensaje(texto) :
	$Mensaje.text = texto #variable texto que utiliza mensaje
	$Mensaje.show() #Muestra mensaje
	$MensajeTimer.start() #

func game_over():
	#primero mostrara el game over y después nombre juego
	mostrar_mensaje("Game Over")
	yield($MensajeTimer, "timeout")# esperara a la señal que se emita para ejecutar lo siguiente
	$BotonPlay.show() 
	$Mensaje.text = "Nombre Juego"
	$Mensaje.show()


func _on_MensajeTimer_timeout():
	$Mensaje.hide()
	
func _on_BotonPlay_pressed():
	$BotonPlay.hide()
	emit_signal("iniciar_juego")


