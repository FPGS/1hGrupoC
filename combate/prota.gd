extends AnimatedSprite
signal volver
signal mover
onready var vida=get_node("valores_aliados/constantes/vida/barra1/PS")
onready var vida_enemigo=get_node("../enemigo/valores_enemigos/constantes/vida/barra1/PS")
onready var vida_actual_num=get_node("valores_aliados/constantes/vida/barra1/contenedor/fondo/valor")
onready var vida_actual_enemigo_num=get_node("../enemigo/valores_enemigos/constantes/vida/barra1/contenedor/fondo/valor")
onready var magia=get_node("valores_aliados/constantes/magia/barra2/PM")
onready var magia_actual_num=get_node("valores_aliados/constantes/magia/barra2/contenedor/fondo/valor")
func _ready():
	
	vida_actual_num.set_text(String(vida.get_value()))
	vida_actual_enemigo_num.set_text(String(vida_enemigo.get_value()))
	magia_actual_num.set_text(String(magia.get_value()))
	
	pass


func _on_MenuButton_atk_esp(): 
	emit_signal("mover", 1)
	pass # Replace with function body.

func _on_MenuButton_atk_pata():
	emit_signal("mover", 2)
	pass # Replace with function body.

func _on_MenuButton2_atk_magia_1():
	if magia.value>=5:
		emit_signal("mover",3)
	else:
		emit_signal("mover", 1)
	pass # Replace with function body.

func medir_vida(delta):
	if delta<=0:
		get_tree().get_nodes_in_group("sonidos")[0].get_node("zombie").play()
		get_node("../enemigo").play("Muerte")
		get_tree().change_scene('res://TittleScreen/GameOver.tscn')
	else:
		emit_signal("volver")
	pass


