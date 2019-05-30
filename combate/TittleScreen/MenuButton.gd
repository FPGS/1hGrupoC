extends MenuButton
signal camvio()
var popup #menu

func _ready():
	popup = get_popup()
	popup.add_item("angel1")
	popup.add_item("angel2")
	popup.add_item("angel3")
	popup.add_item("ogro1")
	popup.add_item("ogro2")
	popup.add_item("ogro3")
	popup.connect("id_pressed", self, "_on_item_pressed")
	pass # Replace with function body.

func _on_item_pressed(ID):
	
	if popup.get_item_text(ID)=="angel1":
		emit_signal("camvio","res://personaje/angel1_anim.tres")
	if popup.get_item_text(ID)=="angel2":
		emit_signal("camvio","res://personaje/ange2_anim.tres")
	if popup.get_item_text(ID)=="angel3":
		emit_signal("camvio","res://personaje/angel3_anim.tres")
	if popup.get_item_text(ID)=="ogro1":
		emit_signal("camvio","res://personaje/green1_anim.tres")
	if popup.get_item_text(ID)=="ogro2":
		emit_signal("camvio","res://personaje/green2_anim.tres")
	if popup.get_item_text(ID)=="ogro3":
		emit_signal("camvio","res://personaje/green3_anim.tres")
