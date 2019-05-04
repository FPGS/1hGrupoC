extends MenuButton

var popup #menu
signal atk_esp #cuando emitas una señal llamara otra función
signal atk_pata
func _ready():
    popup = get_popup()
    popup.add_item("espada") #contesto del menu
    popup.add_item("patada")
    popup.connect("id_pressed", self, "_on_item_pressed")
	#primera var lo que manda , , función que llamara
func _on_item_pressed(ID):
	#te devuelve un id del texto del ataque selecionado
	if popup.get_item_text(ID)=="espada":
		get_node("..").visible=false
		emit_signal("atk_esp")
	if popup.get_item_text(ID)=="patada":
		get_node("..").visible=false #oculta el menu
		emit_signal("atk_pata") #realiza el ataque