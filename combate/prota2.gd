extends AnimatedSprite
signal turno_enemigo

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
	vida_enemigo.set_value(vida_enemigo.value-rand_range(4,8) )
	vida_actual_enemigo_num.set_text(String(vida_enemigo.get_value()))
	medir_vida(vida_enemigo.value)
	pass # Replace with function body.

func _on_MenuButton_atk_pata():
	vida_enemigo.set_value(vida_enemigo.value-rand_range(4,8) )
	vida_actual_enemigo_num.set_text(String(vida_enemigo.get_value()))
	medir_vida(vida_enemigo.value)
	pass # Replace with function body.

func _on_MenuButton2_atk_magia_1():
	if magia.value>=5:
		vida_enemigo.set_value(vida_enemigo.value-10)
		vida_actual_enemigo_num.set_text(String(vida_enemigo.get_value()))
		magia.set_value(magia.value-5)
		magia_actual_num.set_text(String(magia.get_value()))
		medir_vida(vida_enemigo.value)
	pass # Replace with function body.

func medir_vida(delta):
	if delta<=0:
		get_node("../enemigo").play("Muerte")
	else:
		
		emit_signal("turno_enemigo")
	pass


