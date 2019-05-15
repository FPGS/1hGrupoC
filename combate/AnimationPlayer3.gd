extends AnimationPlayer
signal medir_vida(delta)
signal turno_enemigo
var prota
onready var vida=get_node("../../prota"+str(prota)+"/valores_aliados/constantes/vida/barra1/PS")
onready var vida_actual_num=get_node("../../prota"+str(prota)+"/valores_aliados/constantes/vida/barra1/contenedor/fondo/valor")
	
func _ready():
	pass # Replace with function body.

func _on_enemigo_mover(delta, prota):
	var vida=get_node("../../prota"+str(prota)+"/valores_aliados/constantes/vida/barra1/PS")
	var vida_actual_num=get_node("../../prota"+str(prota)+"/valores_aliados/constantes/vida/barra1/contenedor/fondo/valor")
	if(delta == 1):
		play("espada3")
	if(delta == 2):
		play("patada3")
	
	pass # Replace with function body.


func _on_AnimationPlayer_animation_finished(anim_name):
	if anim_name=="espada3":
		vida.set_value(vida.value-rand_range(4,8) )#elige un valor aleatorio para el daño
		vida_actual_num.set_text(String(vida.get_value())) #actualizar barra de vida
		emit_signal("medir_vida",vida.value) 
	if anim_name == "patada3":
		vida.set_value(vida.value-rand_range(4,8) )#elige un valor aleatorio para el daño
		vida_actual_num.set_text(String(vida.get_value())) #actualizar barra de vida
		emit_signal("medir_vida",vida.value) 
	if anim_name=="volver3":
		emit_signal("turno_enemigo")
	pass # Replace with function body.

func _on_enemigo_volver():
	play("volver3")
	pass # Replace with function body.
