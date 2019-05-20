extends AnimatedSprite
var per=1
signal mover(delta, pro)
signal volver(per)
onready var vida=get_node("../prota"+str(per)+"/valores_aliados/constantes/vida/barra1/PS")
onready var vida_actual_num=get_node("../prota"+str(per)+"/valores_aliados/constantes/vida/barra1/contenedor/fondo/valor")
onready var magia=get_node("valores_enemigos/constantes/magia/barra2/PM")
onready var magia_actual_num=get_node("valores_enemigos/constantes/magia/barra2/contenedor/fondo/valor")
func _ready():
	
	pass
#poner esta linea cuando muera el enemigo
#get_tree().get_nodes_in_group("sonidos")[0].get_node("zombie").play()


func medir_vida(delta):
	print(per)
	if delta<=0:
		get_node("../prota"+str(per)).play("Muerte")
	else:
		emit_signal("volver", per)
	

func turno_enemigo(personaje):
	per=personaje
	var vida=get_node("../prota"+str(per)+"/valores_aliados/constantes/vida/barra1/PS")
	var vida_actual_num=get_node("../prota"+str(per)+"/valores_aliados/constantes/vida/barra1/contenedor/fondo/valor")
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