extends AnimatedSprite
var contadorDelta

func _ready():
	contadorDelta = 0

func _process(delta):
	cambiarFotogramaTrasXTiempo(0.15, delta)
	

func cambiarFotograma():
	frame += 1
	if(frame >= 3):
		frame = 0

func cambiarFotogramaTrasXTiempo(cadaCuanto, delta):
	contadorDelta += delta
	if(contadorDelta >= cadaCuanto):
		cambiarFotograma()
		contadorDelta = 0
	