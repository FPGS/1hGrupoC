extends AudioStreamPlayer

# Declare member variables here. Examples:
# var a = 2
# var b = "text"

# Called when the node enters the scene tree for the first time.
func _ready():
	pass # Replace with function body.

# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass


func _on_Music__apagar():
	playing=false
	pass # Replace with function body.


func _on_Music__encender():
	playing=true
	pass # Replace with function body.
