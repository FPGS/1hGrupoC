extends AnimationPlayer
signal medir_vida(delta)
signal turno_enemigo
onready var vida_enemigo=get_node("../../enemigo/valores_enemigos/constantes/vida/barra1/PS")
onready var vida_actual_enemigo_num=get_node("../../enemigo/valores_enemigos/constantes/vida/barra1/contenedor/fondo/valor")

func _ready():
	pass # Replace with function body.





func _on_prota1_mover():
	play("espada")
	pass # Replace with function body.


func _on_AnimationPlayer_animation_finished(anim_name):
	if anim_name=="espada":
		vida_enemigo.set_value(vida_enemigo.value-rand_range(4,8) )#elige un valor aleatorio para el daño
		vida_actual_enemigo_num.set_text(String(vida_enemigo.get_value())) #actualizar barra de vida
		emit_signal("medir_vida",vida_enemigo.value) 
	if anim_name=="volver":
		emit_signal("turno_enemigo")
	pass # Replace with function body.


func _on_prota1_volver():
	play("volver")
	pass # Replace with function body.
