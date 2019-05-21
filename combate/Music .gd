extends Button
var aux=0;
signal apagar
signal encender
# Declare member variables here. Examples:
# var a = 2
# var b = "text"

# Called when the node enters the scene tree for the first time.
func _ready():
	pass # Replace with function body.

# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass


func _on_Music__pressed():
	if aux==0:
		emit_signal("apagar")
		aux=1
	else:
		emit_signal("encender")
		aux=0
	pass # Replace with function body.
