extends MenuButton
signal camvio()
var popup #menu

func _ready():
	popup = get_popup()
	popup.add_item("caballero1") #contesto del menu
	popup.add_item("caballero2")
	popup.connect("id_pressed", self, "_on_item_pressed")
	pass # Replace with function body.

func _on_item_pressed(ID):
	
	if popup.get_item_text(ID)=="caballero1":
		emit_signal("camvio","res://personaje/angel1_anim.tres")
	if popup.get_item_text(ID)=="patada":
		print("llega")
