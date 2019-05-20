extends AnimationPlayer
signal medir_vida(delta)
signal turno_enemigo
var prota=1
onready var vida=get_node("../../prota1/valores_aliados/constantes/vida/barra1/PS")
onready var vida_actual_num=get_node("../../prota1/valores_aliados/constantes/vida/barra1/contenedor/fondo/valor")
onready var vida2=get_node("../../prota2/valores_aliados/constantes/vida/barra1/PS")
onready var vida_actual_num2=get_node("../../prota2/valores_aliados/constantes/vida/barra1/contenedor/fondo/valor")
onready var magia=get_node("../../prota1/valores_aliados/constantes/magia/barra2/PM")
onready var magia_actual_num=get_node("../../prota1/valores_aliados/constantes/magia/barra2/contenedor/fondo/valor")
onready var magia2=get_node("../../prota2/valores_aliados/constantes/magia/barra2/PM")
onready var magia_actual_num2=get_node("../../prota2/valores_aliados/constantes/magia/barra2/contenedor/fondo/valor")

func _ready():
	pass # Replace with function body.

func _on_enemigo_mover(delta, prot):
	prota=prot
	print(delta)
	if(delta == 1 && prota ==1):
		play("espada3")
	if(delta == 1 && prota ==2):
		play("espada4")
	if(delta == 2 && prota ==1):
		play("patada3")
	if(delta == 2 && prota ==2):
		play("patada4")
	if(delta == 3 && prota ==1):
		play("magia3")
	if(delta == 3 && prota ==2):
		play("magia4")	
	pass # Replace with function body.


func _on_AnimationPlayer_animation_finished(anim_name):
	if anim_name=="espada3":
		vida.set_value(vida.value-rand_range(4,8) )#elige un valor aleatorio para el daño
		vida_actual_num.set_text(String(vida.get_value())) #actualizar barra de vida
		emit_signal("medir_vida",vida.value) 
	if anim_name=="espada4":
		vida2.set_value(vida.value-rand_range(4,8) )#elige un valor aleatorio para el daño
		vida_actual_num2.set_text(String(vida.get_value())) #actualizar barra de vida
		emit_signal("medir_vida",vida.value) 
	if anim_name == "patada3":
		vida.set_value(vida.value-rand_range(4,8) )#elige un valor aleatorio para el daño
		vida_actual_num.set_text(String(vida.get_value())) #actualizar barra de vida
		emit_signal("medir_vida",vida.value) 
	if anim_name == "patada4":
		vida2.set_value(vida.value-rand_range(4,8) )#elige un valor aleatorio para el daño
		vida_actual_num2.set_text(String(vida.get_value())) #actualizar barra de vida
		emit_signal("medir_vida",vida.value) 
	if anim_name =="magia3":
		vida.set_value(vida.value-10 )
		vida_actual_num.set_text(String(vida.get_value()))
		magia.set_value(magia.value-5)
		magia_actual_num.set_text(String(magia.get_value()))
		get_node("../../prota"+str(2)+"/menu_accion").visible=true
	if anim_name =="magia4":
		vida2.set_value(vida.value-10 )
		vida_actual_num2.set_text(String(vida.get_value()))
		magia2.set_value(magia.value-5)
		magia_actual_num2.set_text(String(magia.get_value()))
		get_node("../../prota"+str(1)+"/menu_accion").visible=true
	if anim_name=="volver3":
		get_node("../../prota"+str(2)+"/menu_accion").visible=true
	if anim_name=="volver4":
		get_node("../../prota"+str(1)+"/menu_accion").visible=true
	pass # Replace with function body.

func _on_enemigo_volver(pro):
	if prota==1:
		play("volver3")
	if prota==2:
		play("volver4")
	pass # Replace with function body.
