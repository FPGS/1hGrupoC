extends AnimatedSprite

# Declare member variables here. Examples:
# var a = 2
# var b = "text"

# Called when the node enters the scene tree for the first time.
func _ready():
	pass # Replace with function body.

# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass


func _on_MenuButton_camvio(string):
	
	get_node("").set_sprite_frames(load(string))
	get_tree().('res://suMadre.tscn').get_node("Node2D/prota1").set_sprite_frames(load(string))
	pass # Replace with function body.
