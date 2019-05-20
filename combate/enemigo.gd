extends AnimatedSprite
var per=1
signal mover(delta, pro)
signal volver(per)

onready var magia=get_node("valores_enemigos/constantes/magia/barra2/PM")

func _ready():
	
	pass
#poner esta linea cuando muera el enemigo
#get_tree().get_nodes_in_group("sonidos")[0].get_node("zombie").play()


func medir_vida(delta):
	print(per)
	if delta<=0:
		get_node("../prota"+str(per)).play("Muerte")
	else:
		emit_signal("volver")
	

func turno_enemigo(personaje):
	per=personaje
	
	var tipo_ataque=int(rand_range(1,4))
	if magia.value<5:
		tipo_ataque=1
	if tipo_ataque==2:#patada
		emit_signal("mover",2,per)
	if tipo_ataque==1:#espada
		emit_signal("mover",1, per)
	if tipo_ataque==3:#magia
		emit_signal("mover",3, per)
	pass # Replace with function body.