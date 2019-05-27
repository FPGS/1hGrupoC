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
	print(string)
	print(get_sprite_frames())
	get_node("").frames.resource_path=string
	pass # Replace with function body.
