extends MenuButton

var popup
signal atk_esp
func _ready():
    popup = get_popup()
    popup.add_item("espada")
    popup.add_item("arco")
    popup.connect("id_pressed", self, "_on_item_pressed")

func _on_item_pressed(ID):
	if popup.get_item_text(ID)=="espada":
		get_node("..").visible=false
		emit_signal("atk_esp")