extends MenuButton

var popup
signal atk_magia_1
func _ready():
    popup = get_popup()
    popup.add_item("Bola de fuego")
    popup.connect("id_pressed", self, "_on_item_pressed")

func _on_item_pressed(ID):
	if popup.get_item_text(ID)=="Bola de fuego":
		get_node("..").visible=false
		emit_signal("atk_magia_1")